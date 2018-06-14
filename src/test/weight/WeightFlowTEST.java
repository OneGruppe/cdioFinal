package test.weight;


import java.io.IOException;

import boundary.weight.WeightTranslation;
import boundary.weight_interface.IWeightTranslation;
import config.Constant;
import controller.controller.CommodityBatchController;
import controller.controller.CommodityController;
import controller.controller.ProductBatchComponentController;
import controller.controller.ProductBatchController;
import controller.controller.RecipeComponentController;
import controller.controller.UserController;
import controller.controller.WeightController;
import controller.controller_interface.ICommodityBatchController;
import controller.controller_interface.ICommodityController;
import controller.controller_interface.IProductBatchComponentController;
import controller.controller_interface.IProductBatchController;
import controller.controller_interface.IRecipeComponentController;
import controller.controller_interface.IUserController;
import controller.controller_interface.IWeightController;
import exceptions.DALException;
import exceptions.WeightException;

public class WeightFlowTEST {

	public static void main(String[] args) 
	{
		IProductBatchController pbc;
		try {
			pbc = new ProductBatchController();
			IUserController user = new UserController();
			IRecipeComponentController rcc = new RecipeComponentController();
			ICommodityBatchController cbc = new CommodityBatchController();
			ICommodityController cc = new CommodityController();
			IProductBatchComponentController pbcc = new ProductBatchComponentController();
			IWeightTranslation weight = new WeightTranslation(Constant.weightPortOne);

			IWeightController wc = new WeightController(pbc, user, rcc, cbc, cc, pbcc, weight);
			wc.weightFlow();
		} 
		catch (DALException | WeightException | IOException e)
		{
			System.out.println(e.getMessage());
		}

	}


}
