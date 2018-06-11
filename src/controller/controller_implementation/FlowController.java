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
		WeightTranslation weight = new WeightTranslation("62.79.16.17");

		int state = 1;
		int userID = 0;
		double tara = 0;
		int productBatchID = 0;
		int goBack = 0;

		ProductBatchController pbc = new ProductBatchController();
		UserController user = new UserController();
		RecipeController recipe = new RecipeController();
		CommodityController com = new CommodityController();
		CommodityBatchController cbc = new CommodityBatchController();

		while(true)
		{
			switch(state)
			{
			case 1:
			{
				weight.removeMsg();
				weight.getInputWithMsg("Tryk c for at fortsaette", "0 for at gaa tilbage", "&3");
				state +=1;
				break;
			}
			case 2:
			{
				System.out.println("-----------------------");
				System.out.println("TRIES TO GET USERID");
				userID = Integer.parseInt(weight.getInputWithMsg("Indtast operatoer nummer", "", "&3"));
				
				System.out.println("USER ID: " + userID);
				System.out.println("-----------------------");

				if(userID == goBack)
					state -= 1;
				else state += 1;
				break;
			}
			case 3:
			{
				int choice = Integer.parseInt(weight.getInputWithMsg("Velkommen " + user.getUser(userID).getName(), "", "&3")); 

				System.out.println("-----------------------");
				System.out.println("Welcome: " + user.getUser(userID).getName());
				System.out.println("-----------------------");

				if(choice == goBack)
					state -= 1;
				else state += 1;
				break;
			}
			case 4:
			{
				System.out.println("-----------------------");
				System.out.println("GETS PRODUCTBATCHID");
				productBatchID = Integer.parseInt(weight.getInputWithMsg("Indtast productBatchID", "", "&3"));
				System.out.println("PRODUCTBATCH ID = " + productBatchID);
				System.out.println("-----------------------");

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
				System.out.println("-----------------------");
				System.out.println("GETS TARA");
				tara = Double.parseDouble(weight.getInputWithMsg("Placer beholder paa vaegt", "", "&3"));
				System.out.println("TARA = " + tara);
				System.out.println("-----------------------");

				if(tara == goBack)
					state -= 1;
				else state += 1;
				break;
			}
			case 6:
			{
				int recipeID = pbc.getProductBatch(productBatchID).getRecipeID();
				List<Integer> commodityIDList = recipe.getRecipe(recipeID).getCommodityList();

				for (int comID : commodityIDList)
				{
					weight.getInputWithMsg("Vej: " + com.getCommodity(comID).getName(), "", "&3");
					double comWeight = weight.getWeight();

					double max = recipe.getRecipe(recipeID).getNonNetto() + recipe.getRecipe(recipeID).getTolerance();
					double min = recipe.getRecipe(recipeID).getNonNetto() - recipe.getRecipe(recipeID).getTolerance();

					while(comWeight > max || comWeight < min)
					{
						if(comWeight > max)
							weight.getInputWithMsg("Raavare vejer for meget", "", "&3");
						if (comWeight < min)
							weight.getInputWithMsg("Raavare vejer for lidt", "", "&3"); 
					}
					cbc.getCommodityBatch(comID).setAmount(comWeight);

				}
			}
			}
		}
	}
}