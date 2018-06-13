package test.weight;

import boundary.weight.WeightTranslation;
import controller.controller.CommodityBatchController;
import controller.controller.CommodityController;
import controller.controller.ProductBatchComponentController;
import controller.controller.ProductBatchController;
import controller.controller.RecipeComponentController;
import controller.controller.UserController;
import controller.controller.WeightController;
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
			ProductBatchComponentController pbcc = new ProductBatchComponentController();
			WeightTranslation weight = new WeightTranslation("62.79.16.17", 8000);

			WeightController wc = new WeightController(pbc, user, rcc, cbc, cc, weight, pbcc);
			wc.weightFlow();

		} 
		catch (DALException e) 
		{
			System.out.println("Main " + e.getMessage());
		}
	}


}
