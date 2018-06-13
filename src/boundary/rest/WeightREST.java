package boundary.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import boundary.rest_interface.IWeightREST;
import boundary.weight.WeightTranslation;
import controller.controller.CommodityBatchController;
import controller.controller.CommodityController;
import controller.controller.ProductBatchComponentController;
import controller.controller.ProductBatchController;
import controller.controller.RecipeComponentController;
import controller.controller.UserController;
import controller.controller.WeightController;
import controller.controller_interface.IWeightController;
import exceptions.DALException;

@Path("Weight")
public class WeightREST implements IWeightREST {

	private IWeightController wc;

	@Override
	@POST
	@Path("doConnection")
	public String doConnection() throws DALException
	{
		try 
		{
			wc = new WeightController(
					new ProductBatchController(), new UserController(), 
					new RecipeComponentController(), new CommodityBatchController(), 
					new CommodityController(), new WeightTranslation("62.79.16.17", 8000), new ProductBatchComponentController());
					wc.weightFlow();
			return "Forbindelse blev oprettet korrekt";
		} 
		catch (DALException e) 
		{
			return "Der skete en fejl, prøv igen: " + e.getMessage();
		}
	}


}
