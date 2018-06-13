package test.weight;

import boundary.weight.WeightTranslation;
import controller.controller_implementation.CommodityBatchController;
import controller.controller_implementation.CommodityController;
import controller.controller_implementation.ProductBatchController;
import controller.controller_implementation.RecipeComponentController;
import controller.controller_implementation.UserController;
import controller.controller_implementation.WeightController;
import exceptions.DALException;

public class WeightFlowTEST {

	public static void main(String[] args) 
	{
		try 
		{
			ProductBatchController pbc = new ProductBatchController();
			UserController user = new UserController();
			RecipeComponentController rcc = new RecipeComponentController();
			CommodityBatchController cbc = new CommodityBatchController();
			CommodityController cc = new CommodityController();
			WeightTranslation weight = new WeightTranslation("62.79.16.17", 8000);

			WeightController wc = new WeightController(pbc, user, rcc, cbc, cc, weight);
			wc.weightFlow();

		} 
		catch (DALException e) 
		{
			System.out.println("Main " + e.getMessage());
		}
	}


}
