package boundary.rest_implementation;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import boundary.rest_interface.IWeightREST;
import boundary.weight.WeightTranslation;
import controller.controller_implementation.CommodityBatchController;
import controller.controller_implementation.CommodityController;
import controller.controller_implementation.ProductBatchController;
import controller.controller_implementation.RecipeComponentController;
import controller.controller_implementation.UserController;
import controller.controller_implementation.WeightController;
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
			wc = new WeightController(new ProductBatchController(), new UserController(), new RecipeComponentController(), new CommodityBatchController(), new CommodityController(), new WeightTranslation("62.79.16.17", 8000));
			wc.weightFlow();
			return "Forbindelse blev oprettet korrekt";
		} 
		catch (DALException e) 
		{
			return "Der skete en fejl, prøv igen: " + e.getMessage();
		}
	}

	
}
