package controller.controller;

import java.util.concurrent.TimeUnit;
import boundary.weight_interface.IWeightTranslation;
import controller.controller_interface.*;
import exceptions.DALException;
import exceptions.WeightException;

public class WeightController implements IWeightController {

	private IProductBatchController pbc;
	private IUserController user;
	private IRecipeComponentController rcc;
	private ICommodityBatchController cbc;
	private ICommodityController cc;
	private IProductBatchComponentController pbcc;
	private IWeightTranslation weight;

	private int state = 1;
	private int commodityBatchID = -1000;
	private int productBatchID = -100;
	private int userID = -10;
	private double tara = 0;
	private double netto = 0;
	private int goBack = -2;
	private boolean finish = false;
	private int recipeID = 0;

	public WeightController(IProductBatchController pbc, IUserController user, IRecipeComponentController rcc, ICommodityBatchController cbc, ICommodityController cc, IProductBatchComponentController pbcc, IWeightTranslation weight) throws DALException
	{
		this.pbc = pbc;
		this.user = user;
		this.rcc = rcc;
		this.cbc = cbc;
		this.cc = cc;
		this.pbcc = pbcc;
		this.weight = weight;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#weightFlow()
	 */
	@Override
	public void weightFlow() throws WeightException, DALException
	{
		while(!finish)
		{
			switch(state)
			{
			case 1:
				enterOprID();
				break;
			case 2:
				welcomeAnswer();
				break;
			case 3:
				enterPBID();
				break;
			case 4:
				taraWeight();
				break;
			case 5:
				weightCommodities();
				break;
			case 6:
				finish();
				break;
			default:
				break;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#enterOprID()
	 */
	@Override
	public void enterOprID()
	{		
		System.out.println("State: " + state);
		try
		{
			userID = weight.getInputWithMsg("Indtast operatoer ID", 0, "");
			if (userID == goBack || userID == -1)
				weightFlow();
			if(user.getUser(userID).getActive() == 0) 
				weight.getInputWithMsg("Bruger inaktiv prov igen", 0, "");
			else state++;
		}
		catch (WeightException e)
		{
			System.out.println("failure in enterOprID()" + e.getMessage());
		}
		catch (DALException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#welcomeAnswer()
	 */
	@Override
	public void welcomeAnswer() throws WeightException
	{
		System.out.println("State: " + state);
		try
		{
			int response = weight.getInputWithMsg("Velkommen " + user.getUser(userID).getName(), 0, "");
			if(response == goBack)
				state--;
			else
				state++;
		}
		catch (WeightException e)
		{
			System.out.println("Failure in WelcomeAnswer(): " + e.getMessage());
			try 
			{
				weight.getInputWithMsg("Forkert input prov igen", 0, "");
			} 
			catch (WeightException e1) 
			{
				System.out.println(e1.getMessage());
			}
			state--;
		} 
		catch (DALException e) 
		{
			System.out.println("Failure in welcomeAnswer(): " + e.getMessage());
			weight.getInputWithMsg("Forkert input, proov igen", 0, "");
			welcomeAnswer();
		}
	}	

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#enterPBID()
	 */
	@Override
	public void enterPBID() throws WeightException
	{
		System.out.println("State: " + state);
		try
		{
			productBatchID = weight.getInputWithMsg("Indtast produktBatchID", 0, "");
			if(productBatchID == goBack)
				state--;
			else
			{
				recipeID = pbc.getProductBatch(productBatchID).getRecipeID();
				pbc.updateProductBatch(productBatchID, recipeID, 1);
				state++;
			}
		}
		catch (WeightException | DALException e)
		{
			System.out.println("Failure in enterPBID(): " + e.getMessage());
			weight.getInputWithMsg("Forkert input, prov igen", 0, "");
			enterPBID();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#taraWeight()
	 */
	@Override
	public void taraWeight() throws WeightException
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
				System.out.println("Tara = " + tara);
				state++;
			}
		}
		catch (WeightException e)
		{
			System.out.println("Failure in taraWeight(): " + e.getMessage());
			weight.getInputWithMsg("Forkert input, prov igen", 0, "");
			taraWeight();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#weightCommodities()
	 */
	@Override
	public void weightCommodities() throws WeightException
	{
		System.out.println("State: " + state);
		try
		{
			pbc.getProductBatch(productBatchID).getRecipeID();
			System.out.println("RecipeID: " + recipeID);
			System.out.println("size = " + rcc.getRecipeComponent(recipeID).size());
			System.out.println("ToString = " + rcc.getRecipeComponent(recipeID).toString());

			for (int i = 0; i < rcc.getRecipeComponent(recipeID).size(); i++)
			{
				commodityBatchID = weight.getInputWithMsg("Indtast raavarebatch ID", 0, "");
				if (commodityBatchID == goBack)
				{
					state--;
				}
				else
				{
					cbc.getCommodityBatchSingle(commodityBatchID);
					System.out.println(rcc.getRecipeComponent(recipeID).get(i).getCommodityID());
					double comWeight = 0;
					int commodityID = rcc.getRecipeComponent(recipeID).get(i).getCommodityID();
					String commodityName = cc.getCommodity(commodityID).getName();
					System.out.println(commodityName);

					int choice = weight.getInputWithMsg("Afvej " + commodityName, 0, rcc.getRecipeComponent(recipeID).get(i).getNonNetto() + " kg");
					if (choice == goBack)
					{
						state--;
					}
					else 
					{
						double min = rcc.getRecipeComponent(recipeID).get(i).getNonNetto() * (1 - (rcc.getRecipeComponent(recipeID).get(i).getTolerance()/100));
						double max = rcc.getRecipeComponent(recipeID).get(i).getNonNetto() * (1 + (rcc.getRecipeComponent(recipeID).get(i).getTolerance()/100));
						System.out.println("Min = " + min + " max = " + max);

						while(true)
						{
							comWeight = weight.getWeight();

							if(comWeight < min) 
							{
								weight.showLongMsg("Mere vaegt");
							} 
							else if(comWeight > max)
							{
								weight.showLongMsg("For meget vaegt");
							} 
							else if(comWeight > min && max > comWeight) 
							{
								try 
								{
									TimeUnit.SECONDS.sleep(3);
									comWeight = weight.getWeight();
									weight.showLongMsg("Vaegt: " + comWeight);
									TimeUnit.SECONDS.sleep(3);
									weight.removeLongMsg();
									choice = weight.getInputWithMsg("Ravare afvejet, fortsat?", 0, "");
									weight.removeMsg();
									if(choice == -2) 
										TimeUnit.SECONDS.sleep(5);
								}
								catch (InterruptedException e) 
								{
									e.printStackTrace();
								}

								if(choice == -1) 
								{
									netto = weight.getWeight();
									pbcc.createProductBatchComponent(commodityID, productBatchID, userID, tara, netto);
									double originalAmount = cbc.getCommodityBatchSingle(commodityBatchID).getAmount();
									double newAmount = originalAmount - comWeight;
									cbc.updateCommodityBatch(commodityBatchID, commodityID, newAmount);
									System.out.println("BATCH ID =" + commodityBatchID + " ID =" + commodityID + " " + originalAmount + " " + newAmount + " " + comWeight);
									System.out.println(comWeight + " fjernet fra " + commodityName + " totalt på lager " + cbc.getCommodityBatchSingle(commodityID).getAmount());
									break;

								} 
								else if(choice == -2)
								{
									continue;
								}
							}
							System.out.println(comWeight);
						}

						System.out.println(comWeight);
					}

					weight.removeMsg();
				}
			}
			state += 1;
		}
		catch (WeightException | DALException e)
		{
			System.out.println("Failure in weightCommodities(): " + e.getMessage());
			weight.getInputWithMsg("Forkert input, proov igen", 0, "");
			weightCommodities();
		} 
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#finish()
	 */
	@Override
	public void finish() throws WeightException
	{
		System.out.println("State: " + state);
		try
		{
			int response =weight.getInputWithMsg("Afvejning faerdig, sluk?", 0, "");
			if(response == goBack)
			{
				pbc.updateProductBatch(productBatchID, recipeID, 2);
				state = 1;
				finish = false;
			}
			else
			{
				pbc.updateProductBatch(productBatchID, recipeID, 2);;
				finish = true;
				weight.closeAllLeaks();
			}
		}
		catch (WeightException | DALException e)
		{
			System.out.println("Failure in finish(): " + e.getMessage());
			weight.getInputWithMsg("Forkert input prov igen", 0, "");
			state--;
		}
	}

}
