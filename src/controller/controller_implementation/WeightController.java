package controller.controller_implementation;

import java.util.concurrent.TimeUnit;

import boundary.weight.WeightTranslation;
import controller.controller_interface.ICommodityBatchController;
import controller.controller_interface.IProductBatchController;
import controller.controller_interface.IRecipeComponentController;
import controller.controller_interface.IUserController;
import controller.controller_interface.IWeightController;
import exceptions.DALException;

public class WeightController implements IWeightController {

	private IProductBatchController pbc;
	private IUserController user;
	private IRecipeComponentController rcc;
	private ICommodityBatchController cbc;
	private WeightTranslation weight;
	private CommodityController cc;

	private int state = 1;
	private int userID = -10;
	private double tara = 0;
	private int productBatchID = -100;
	private int goBack = 0;
	private int commodityBatchID = -1000;

	public WeightController(ProductBatchController pbc, UserController user, RecipeComponentController rcc, CommodityBatchController cbc, CommodityController cc, WeightTranslation weight) throws DALException
	{
		this.pbc = pbc;
		this.user = user;
		this.rcc = rcc;
		this.cbc = cbc;
		this.cc = cc;
		this.weight = weight;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#weightFlow()
	 */
	public void weightFlow() throws DALException
	{
		while(state < 9)
		{
			switch(state)
			{
			case 1:
				welcome();
				break;
			case 2:
				enterOprID();
				break;
			case 3:
				welcomeAnswer();
				break;
			case 4:
				enterPBID();
				break;
			case 5:
				taraWeight();
				break;
			case 6:
				enterCBID();
				break;
			case 7:
				weightCommodities();
				break;
			case 8:
				finish();
				break;
			default:
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#welcome()
	 */
	public void welcome() throws DALException
	{
		try
		{
			System.out.println("State: " + state);
			weight.getInputWithMsg("Tryk 0 for tilbage", 0, "");
			state++;
		}
		catch (DALException e)
		{
			System.out.println("Failure in Welcome()");
			welcome();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#enterOprID()
	 */
	public void enterOprID() throws DALException
	{		
		System.out.println("State: " + state);
		try
		{
			userID = weight.getInputWithMsg("Indtast operatoer ID", 0, "");
			if (userID == goBack)
				state--;
			else state++;
		}
		catch (DALException e)
		{
			System.out.println("failure in enterOprID()" + e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#welcomeAnswer()
	 */
	public void welcomeAnswer() throws DALException
	{
		System.out.println("State: " + state);
		try
		{
			int response = weight.getInputWithMsg("Velkommen " + user.getUser(userID).getName(), 0, "");
			if(response == 0)
				state--;
			else
				state++;
		}
		catch (DALException e)
		{
			System.out.println("Failure in WelcomeAnswer(): " + e.getMessage());
			weight.getInputWithMsg("Forkert input proov igen", 0, "");
			state--;
		}
	}	

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#enterPBID()
	 */
	public void enterPBID() throws NumberFormatException, DALException
	{
		System.out.println("State: " + state);
		try
		{
			productBatchID = weight.getInputWithMsg("Indtast produktBatchID", 0, "");
			if(productBatchID == goBack)
				state--;
			else
			{
				pbc.getProductBatch(productBatchID).setId(1);
				state++;
			}
		}
		catch (DALException e)
		{
			System.out.println("Failure in enterPBID(): " + e.getMessage());
			weight.getInputWithMsg("Forkert input proov igen", 0, "");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#taraWeight()
	 */
	public void taraWeight() throws NumberFormatException, DALException
	{
		System.out.println("State: " + state);
		try
		{
			int response = weight.getInputWithMsg("Placer beholderen", 0, "");
			if(response == goBack)
				state--;
			else
			{
				tara = weight.getTaraWeight();
				state++;
			}
		}
		catch (DALException e)
		{
			System.out.println("Failure in taraWeight: " + e.getMessage());
			weight.getInputWithMsg("Forkert input, proov igen", 0, "");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#enterCBID()
	 */
	public void enterCBID() throws NumberFormatException, DALException
	{
		System.out.println("State: " + state);
		try
		{
			commodityBatchID = weight.getInputWithMsg("Indtast raavarebatch ID", 0, "");
			if (commodityBatchID == 0)
				state--;
			else
				state++;
		}
		catch (DALException e)
		{
			System.out.println("Failure in enterCBID(): " + e.getMessage());
			weight.getInputWithMsg("Forkert input, proov igen", 0, "");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#weightCommodities()
	 */
	public void weightCommodities() throws DALException
	{
		System.out.println("State: " + state);
		try
		{
			int recipeID = pbc.getProductBatch(productBatchID).getRecipeID();
			System.out.println("RecipeID: " + recipeID);

			for (int i = 0; i < rcc.getRecipeComponent(recipeID).size(); i++) {
				double comWeight = 0;
				int commodityID = rcc.getRecipeComponent(recipeID).get(i).getCommodityID();
				String commodityName = cc.getCommodity(commodityID).getName();
				int choice = weight.getInputWithMsg("vej " + commodityName, 0, rcc.getRecipeComponent(recipeID).get(i).getNonNetto() + " kg");
				if(choice == goBack)
					break;
				double min = rcc.getRecipeComponent(recipeID).get(i).getNonNetto() - rcc.getRecipeComponent(recipeID).get(i).getTolerance();
				double max = rcc.getRecipeComponent(recipeID).get(i).getNonNetto() + rcc.getRecipeComponent(recipeID).get(i).getTolerance();
				System.out.println("Min = " + min + " max = " + max);

				while(!(weight.getWeight() < min) || !(weight.getWeight() > max))
				{
					comWeight = weight.getWeight();
					System.out.println("comWeight = " + comWeight);
					cbc.getCommodityBatchSingle(commodityBatchID).setAmount(comWeight);
					System.out.println("cbc after weight = " + cbc.getCommodityBatchSingle(commodityID));
				}
			}
			state += 1;
		}
		catch (DALException e)
		{
			System.out.println("Failure in weightCommodities(): " + e.getMessage());	
			weight.getInputWithMsg("Forkert input, proov igen", 0, "");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#finish()
	 */
	public void finish() throws NumberFormatException, DALException
	{
		System.out.println("State: " + state);
		try
		{
			int response =weight.getInputWithMsg("Faerdig?", 0, "");
			if(response == goBack)
				state--;
			else
			{
				state++;
				pbc.getProductBatch(productBatchID).setStatus(2);
			}
		}
		catch (DALException e)
		{
			System.out.println("Failure in finish(): " + e.getMessage());
			weight.getInputWithMsg("Forkert input, proov igen", 0, "");
			state--;
		}
	}

	public void restart()
	{
		try 
		{
			weight.showLongMsg("Erorr has occured, restarting");
			TimeUnit.SECONDS.sleep(2);
			weight.removeLongMsg();
			weightFlow();
		} 
		catch (DALException | InterruptedException e) 
		{
			System.out.println(e.getMessage());
		}
	}


}
