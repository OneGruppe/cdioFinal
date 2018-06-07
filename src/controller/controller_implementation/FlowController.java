package controller.controller_implementation;

import java.util.List;
import boundary.weight.WeightTranslation;
import exceptions.DALException;

public class FlowController
{
	public static void main(String[] args)
	{
		try {
			weightFlow();
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void weightFlow() throws DALException
	{
		WeightTranslation weight = new WeightTranslation("62.79.16.17", 0);

		int state = 1;
		int userID = 0;
		double tara = 0;
		int productBatchID = 0;
		int goBack = 0;
		int commodityBatchID = 0;

		ProductBatchController pbc = new ProductBatchController();
		UserController user = new UserController();
		CommodityController com = new CommodityController();
		RecipeComponentController rcc = new RecipeComponentController();
		CommodityBatchController cbc = new CommodityBatchController();


		while(state < 9)
		{
			switch(state)
			{
			case 1:
			{
				System.out.println("State: " + state);
				weight.removeMsg();
				weight.getInputWithMsg("Tryk -> for at fortsaette", "0 for at gaa tilbage", "&3");
				state +=1;
				break;
			}
			case 2:
			{
				System.out.println("State: " + state);
				userID = Integer.parseInt(weight.getInputWithMsg("Indtast operatoer nummer", "", "&3"));

				System.out.println("USER ID: " + userID);

				if(userID == goBack)
					state -= 1;
				else state += 1;
				break;
			}
			case 3:
			{
				System.out.println("State: " + state);
				int choice = Integer.parseInt(weight.getInputWithMsg("Velkommen " + user.getUser(userID).getName(), "", "&3")); 

				System.out.println("Welcome: " + user.getUser(userID).getName());

				if(choice == goBack)
					state -= 1;
				else state += 1;
				break;
			}
			case 4:
			{
				System.out.println("State: " + state);
				productBatchID = Integer.parseInt(weight.getInputWithMsg("Indtast productBatchID", "", "&3"));
				System.out.println("PRODUCTBATCH ID = " + productBatchID);

				pbc.getProductBatch(productBatchID).setStatus(1);

				if (productBatchID == goBack)
				{
					state -= 1;
					pbc.getProductBatch(productBatchID).setStatus(0);
				}

				else state += 1;
				break;
			}
			case 5:
			{
				System.out.println("State: " + state);
				tara = Double.parseDouble(weight.getInputWithMsg("Placer beholder paa vaegt", "", "&3"));
				System.out.println("TARA = " + tara);

				if((int) tara == goBack)
					state -= 1;
				else state += 1;
				break;
			}
			case 6:
			{
				commodityBatchID = Integer.parseInt(weight.getInputWithMsg("Indtast raavare batch ID", "", "&3"));
				System.out.println("CommodityBatch ID: " + commodityBatchID);

				if (commodityBatchID == goBack)
					state -= 1;
				else state += 1;
			}
			case 7:
			{
				System.out.println("State: " + state);
				int recipeID = pbc.getProductBatch(productBatchID).getRecipeID();
				System.out.println("RecipeID: " + recipeID);
				double comWeight = 0;

				for (int i = 0; i < rcc.getRecipeComponent(recipeID).size(); i++)
				{
					int choice = Integer.parseInt(weight.getInputWithMsg("Vej: " + rcc.getRecipeComponent(recipeID).get(i), "", rcc.getRecipeComponent(recipeID).get(i).getNon_netto() + "g"));
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
				break;
			}
			case 8:
			{
				System.out.println("State: " + state);
				int choice = Integer.parseInt(weight.getInputWithMsg("Faerdig?", "", "&3"));
				if(choice == goBack)
					state -= 1;
				else
				{
					pbc.getProductBatch(productBatchID).setStatus(2);
					state += 1;
				}
			}
			}
		}
	}
}