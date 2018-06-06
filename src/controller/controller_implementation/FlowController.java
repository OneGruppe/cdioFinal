package controller.controller_implementation;

import java.util.List;
import boundary.weight.WeightTranslation;
import exceptions.DALException;

public class FlowController
{
	public static void main(String[] args) throws DALException {
		weightFlow();
	}

	public static void weightFlow() throws DALException
	{
		WeightTranslation weight = new WeightTranslation("62.79.16.17");

		int state = 1;
		int userID = 0;
		int tara = 0;
		int productBatchID = 0;
		int temp = 12;
		int temp2 = 0;

		ProductBatchController pbc = new ProductBatchController();
		UserController user = new UserController();
		RecipeController recipe = new RecipeController();
		CommodityController com = new CommodityController();
		
		while(true)
		{
			switch(state)
			{
			case 1:
			{
				weight.removeMsg();
				weight.getInputWithMsg("Tryk 12 for at fortsaette, 0 for at gaa tilbage");
				state +=1;
				break;
			}
			case 2:
			{
				System.out.println("-----------------------");
				System.out.println("TRIES TO GET USERID");
				userID = weight.getInputWithMsg("Indtast operatoer nummer");
				System.out.println("USER ID: " + userID);
				System.out.println("-----------------------");

				if(userID != temp2)
				{
					state += 1;
				}
				else state -= 1;
				break;
			}
			case 3:
			{
				int choice = weight.getInputWithMsg("Velkommen " + user.getUser(userID).getName()); 

				System.out.println("-----------------------");
				System.out.println("Welcome: " + user.getUser(userID).getName());
				System.out.println("-----------------------");

				if(choice == temp)
					state += 1;
				else state -= 1;
				break;
			}
			case 4:
			{
				System.out.println("-----------------------");
				System.out.println("GETS PRODUCTBATCHID");
				productBatchID = weight.getInputWithMsg("Indtast productBatchID");
				System.out.println("PRODUCTBATCH ID = " + productBatchID);
				System.out.println("-----------------------");
				
				pbc.getProductBatch(productBatchID).setStatus(1);

				if (productBatchID != temp2)
					state += 1;
				else {
					state -= 1;
					pbc.getProductBatch(productBatchID).setStatus(0);
				}
				break;
			}
			case 5:
			{
				System.out.println("-----------------------");
				System.out.println("GETS TARA");
				tara = weight.getInputWithMsg("Placer beholder på vaegt");
				System.out.println("TARA = " + tara);
				System.out.println("-----------------------");

				if(tara != temp2)
					state += 1;
				else state -= 1;
				break;
			}
			case 6:
			{
				int recipeID = pbc.getProductBatch(productBatchID).getRecipeID();
				List<Integer> commodityIDList = recipe.getRecipe(recipeID).getCommodityID();
				
				for (int comID : commodityIDList)
				{
					weight.getInputWithMsg("Vej: " + com.getCommodity(comID).getName());
					double comWeight = weight.getWeight();
					
					double max = recipe.getRecipe(recipeID).getNonNetto() + recipe.getRecipe(recipeID).getTolerance();
					double min = recipe.getRecipe(recipeID).getNonNetto() - recipe.getRecipe(recipeID).getTolerance();
					
					
					if(comWeight > max)
						weight.getInputWithMsg("Raavare vejer for meget");
					if (comWeight < min)
						weight.getInputWithMsg("Raavare vejer for lidt");
					//pbc.getProductBatch(productBatchID).set
						
				}
			}
			}

		}
	}
}