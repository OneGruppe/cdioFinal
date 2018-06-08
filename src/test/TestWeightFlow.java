package test;

import boundary.weight.WeightTranslation;
import controller.controller_implementation.CommodityBatchController;
import controller.controller_implementation.WeightController;
import controller.controller_implementation.ProductBatchController;
import controller.controller_implementation.RecipeComponentController;
import controller.controller_implementation.UserController;
import exceptions.DALException;

public class TestWeightFlow
{
	public static void main(String[] args) {
		try {
			ProductBatchController pbc = new ProductBatchController();
			UserController user = new UserController();
			RecipeComponentController rcc = new RecipeComponentController();
			CommodityBatchController cbc = new CommodityBatchController();
			WeightTranslation weight = new WeightTranslation("62.79.16.17", 8000);
			
			WeightController fc = new WeightController(pbc, user, rcc, cbc, weight);
			fc.weightFlow();
			
		} catch (DALException e) {
			System.out.println("Main " + e.getMessage());
		}
		
		
	}
}
