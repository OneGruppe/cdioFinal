package controller.controller;

import java.util.concurrent.TimeUnit;

import boundary.weight_interface.IWeightTranslation;
import controller.controller_interface.ICommodityBatchController;
import controller.controller_interface.ICommodityController;
import controller.controller_interface.IProductBatchComponentController;
import controller.controller_interface.IProductBatchController;
import controller.controller_interface.IRecipeComponentController;
import controller.controller_interface.IUserController;
import controller.controller_interface.IWeightController;
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
	public void weightFlow()
	{
		while(!finish)
		{
			switch(state)
			{
			case 1:	//Check the users ID
				enterOprID();
				break;
			case 2:	//Display a wellcome msg on the weight
				welcomeAnswer();
				break;
			case 3:	//Define the given ProductBatch needed for use
				enterPBID();
				break;
			case 4:	//Set the tara value of the given container
				taraWeight();
				break;
			case 5:	//Weigh the given Commodities and add the ProductBatchComponent to the database
				weightCommodities();
				break;
			case 6:	//Restart the program if desired or finish the weighing process
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
			
			//Check if the user wants to go back
			if (userID == goBack || userID == -1)
				weightFlow();
			
			//Check if the user is inactive and thereby not able to interact with the weight 
			if(user.getUser(userID).getActive() == 0) 
				weight.getInputWithMsg("Bruger inaktiv prov igen", 0, "");
			
			//Else continue the flow
			else state++; 
		}
		catch (WeightException | DALException e)
		{
			try 
			{
				System.out.println("Failure in enterOprID(): " + e.getMessage());
				weight.getInputWithMsg("Forkert input, prov igen", 0, "");
				enterOprID();
			} 
			catch (WeightException e1) 
			{
				System.out.println(e1.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#welcomeAnswer()
	 */
	@Override
	public void welcomeAnswer()
	{
		System.out.println("State: " + state);
		try
		{
			int response = weight.getInputWithMsg("Velkommen " + user.getUser(userID).getName(), 0, "");
			
			//Check if the user wants to go back
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
				state--;
			} 
			catch (WeightException e1) 
			{
				System.out.println(e1.getMessage());
			}
		} 
		catch (DALException e) 
		{
			System.out.println("Failure in welcomeAnswer(): " + e.getMessage());
			try 
			{
				weight.getInputWithMsg("Forkert input, prov igen", 0, "");
				welcomeAnswer();
			} 
			catch (WeightException e1) 
			{
				System.out.println(e1.getMessage());
			}
		}
	}	

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#enterPBID()
	 */
	@Override
	public void enterPBID()
	{
		System.out.println("State: " + state);
		try
		{
			productBatchID = weight.getInputWithMsg("Indtast produktBatchID", 0, "");
		
			//Check if the user wants to go back
			if(productBatchID == goBack)
				state--;
			else
			{
				System.out.println(pbc.getProductBatch(productBatchID).getStatus());
				
				//Check if the entered ProductBatch is a finished product
				if(pbc.getProductBatch(productBatchID).getStatus() == 2)
				{
					weight.getInputWithMsg("Produktbatch er afsluttet", 0, "");
					enterPBID(); 
				}
				//Update the given ProductBatch to be "under process" and continue flow
				else 
				{
				recipeID = pbc.getProductBatch(productBatchID).getRecipeID();
				pbc.updateProductBatch(productBatchID, recipeID, 1);
				state++;
				}
			}
		}
		catch (WeightException | DALException e)
		{
			System.out.println("Failure in enterPBID(): " + e.getMessage());
			try 
			{
				weight.getInputWithMsg("Forkert input, prov igen", 0, "");
				enterPBID();
			} 
			catch (WeightException e1) 
			{
				System.out.println(e1.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#taraWeight()
	 */
	@Override
	public void taraWeight()
	{
		System.out.println("State: " + state);
		try
		{
			int response = weight.getInputWithMsg("Placer beholderen", 0, "");
			
			//Check if the user wants to go back
			if(response == goBack)
				state--;
			
			//Assign tara and continue flow
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
			try 
			{
				weight.getInputWithMsg("Forkert input, prov igen", 0, "");
				taraWeight();
			} 
			catch (WeightException e1) 
			{
				System.out.println(e1.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#weightCommodities()
	 */
	@Override
	public void weightCommodities()
	{
		System.out.println("State: " + state);
		try
		{
			System.out.println("RecipeID: " + recipeID);
			System.out.println("size = " + rcc.getRecipeComponent(recipeID).size());
			System.out.println("ToString = " + rcc.getRecipeComponent(recipeID).toString());

			commodityBatchID = weight.getInputWithMsg("Indtast raavarebatch ID", 0, "");
			
			for (int i = 0; i < rcc.getRecipeComponent(recipeID).size(); i++)
			{
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

					int choice = weight.getInputWithMsg("Afvej " + commodityName, 0, rcc.getRecipeComponent(recipeID).get(i).getNonNetto() + " kg - T: " + rcc.getRecipeComponent(recipeID).get(i).getTolerance() + "%");
					if (choice == goBack)
					{
						state--;
					}
					else 
					{
						double min = rcc.getRecipeComponent(recipeID).get(i).getNonNetto() * (1 - (rcc.getRecipeComponent(recipeID).get(i).getTolerance()/100)); //Minimum weight of the commodity
						double max = rcc.getRecipeComponent(recipeID).get(i).getNonNetto() * (1 + (rcc.getRecipeComponent(recipeID).get(i).getTolerance()/100)); //Maximum weight of the commodity
						System.out.println("Min = " + min + " max = " + max);

						/*
						 * While true loop that will only continue if current weight load is between min and max
						 */
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
									TimeUnit.SECONDS.sleep(2);
									comWeight = weight.getWeight();
									weight.showLongMsg("Vaegt: " + comWeight);
									TimeUnit.SECONDS.sleep(2);
									weight.removeLongMsg();
									choice = weight.getInputWithMsg("Ravare afvejet, fortsat?", 0, "");
									weight.removeMsg();
									if(choice == -2) //If cancel is pressed, sleep for 2 seconds and continues in the loop
										TimeUnit.SECONDS.sleep(2);
								}
								catch (InterruptedException e) 
								{
									System.out.println(e.getMessage());
								}

								if(choice == -1) //OK is pressed on the weight
								{
									netto = weight.getWeight(); //Current weight load is saved into variable
									pbcc.createProductBatchComponent(commodityID, productBatchID, userID, tara, netto); //Creates a new productBatch with the weight, and all IDs
									double originalAmount = cbc.getCommodityBatchSingle(commodityBatchID).getAmount(); //Saves the stored amount from the storage into a variable
									double newAmount = originalAmount - comWeight; //Calculates the new amount that will be in the storage
									cbc.updateCommodityBatch(commodityBatchID, commodityID, newAmount); //Updates the commodity batch with the new amount
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
			try 
			{
				weight.getInputWithMsg("Forkert input, prov igen", 0, "");
				weightCommodities();
			} 
			catch (WeightException e1) 
			{
				System.out.println(e1.getMessage());
			}
		} 
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IWeightController#finish()
	 */
	@Override
	public void finish()
	{
		System.out.println("State: " + state);
		try
		{
			int response =weight.getInputWithMsg("Afvejning faerdig, sluk?", 0, "");
			
			//Check if the user is done using the weight
			if(response == goBack)
			{
				pbc.updateProductBatch(productBatchID, recipeID, 2); //No matter what, the productBatch is done by now
				state = 1; //Sets state back to one to restart the loop
				finish = false; //While loop continues to be true
			}
			//Change Product to be finished and make sure all leaks are covered
			else
			{
				pbc.updateProductBatch(productBatchID, recipeID, 2); //No matter what, the productBatch is done by now
				finish = true; //This will close the while loop that runs the entire flow
				weight.closeAllLeaks();
			}
		}
		catch (WeightException | DALException e)
		{
			System.out.println("Failure in finish(): " + e.getMessage());
			try 
			{
				weight.getInputWithMsg("Forkert input, prov igen", 0, "");
				state--;
			} 
			catch (WeightException e1) 
			{
				System.out.println(e1.getMessage());
			}
		}
	}

}
