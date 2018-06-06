package controller.controller_implementation;

import java.util.List;
import java.util.ArrayList;

import boundary.weight.WeightTranslation;
import exceptions.DALException;

public class FlowController
{

	public void weightFlow() throws DALException
	{
		WeightTranslation weight = new WeightTranslation("169.254.2.3");

		int state = 1;
		int userID = 0;
		int tara = 0;
		int productBatchID = 0;

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
				weight.getInputWithMsg("Tryk temp for at fortsaette, temp2 for at gaa tilbage");
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

				if(choice = temp)
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

				if (productBatchID != temp2)
					state += 1;
				else state -= 1;
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
						
				}
			}
			}

		}
	}
}