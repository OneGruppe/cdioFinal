package controller.controller_implementation;

import boundary.weight.WeightTranslation;
import controller.controller_interface.IWeightController;
import exceptions.DALException;

public class WeightController implements IWeightController
{

	ProductBatchController pbc;
	UserController user;
	RecipeComponentController rcc;
	CommodityBatchController cbc;
	WeightTranslation weight;

	int state = 1;
	int userID = -10;
	double tara = 0;
	int productBatchID = -100;
	int goBack = 0;
	int commodityBatchID = -1000;

	public WeightController(ProductBatchController pbc, UserController user, RecipeComponentController rcc, CommodityBatchController cbc, WeightTranslation weight) throws DALException
	{
		this.pbc = pbc;
		this.user = user;
		this.rcc = rcc;
		this.cbc = cbc;
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
				pbc.getProductBatch(productBatchID).setID(1);
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
			double comWeight = 0;

			for (int i = 0; i < rcc.getRecipeComponent(recipeID).size(); i++)
			{
				int choice = weight.getInputWithMsg("Vej: " + rcc.getRecipeComponent(recipeID).get(i), 0, rcc.getRecipeComponent(recipeID).get(i).getNon_netto() + "kg");
				System.out.println("Weight: " + rcc.getRecipeComponent(recipeID).get(i) + " netto: " + rcc.getRecipeComponent(recipeID).get(i).getNon_netto());

				if(choice == goBack)
					break;
				double max = rcc.getRecipeComponent(recipeID).get(i).getNon_netto() + rcc.getRecipeComponent(recipeID).get(i).getTolerance();
				double min = rcc.getRecipeComponent(recipeID).get(i).getNon_netto() - rcc.getRecipeComponent(recipeID).get(i).getTolerance();

				while(weight.getWeight() > min && weight.getWeight() < max)
				{
					comWeight = weight.getWeight();
					System.out.println("comWeight: " + comWeight);
					cbc.getCommodityBatch(commodityBatchID).setAmount(comWeight);

					double temp = tara + comWeight;
					double temp2 = tara + rcc.getRecipeComponent(recipeID).get(i).getNon_netto();
					System.out.println("Temp: " + temp + " temp2: " + temp2);
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

}