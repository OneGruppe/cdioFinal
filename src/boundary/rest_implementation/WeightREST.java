package boundary.rest_implementation;

import javax.ws.rs.FormParam;
import javax.ws.rs.Path;

import boundary.rest_interface.IWeightREST;
import boundary.weight.WeightTranslation;
import controller.controller_implementation.CommodityBatchController;
import controller.controller_implementation.ProductBatchController;
import controller.controller_implementation.RecipeComponentController;
import controller.controller_implementation.UserController;
import controller.controller_implementation.WeightController;
import exceptions.DALException;

//@Path("Weight")
public class WeightREST implements IWeightREST {

	private WeightController wc;

	//@Path("doConnection")
	public void doConnection(@FormParam("port") int port)
	{
		try 
		{
			wc = new WeightController(new ProductBatchController(), new UserController(), new RecipeComponentController(), new CommodityBatchController(), new WeightTranslation("62.79.16.17", port));
			wc.weightFlow();
		} 
		catch (DALException e) 
		{
			wc.restart();
		}
	}


}
