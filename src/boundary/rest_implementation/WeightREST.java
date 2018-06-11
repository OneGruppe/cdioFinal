package boundary.rest_implementation;

import javax.ws.rs.FormParam;

import boundary.rest_interface.IWeightREST;
import boundary.weight.WeightTranslation;
import controller.controller_implementation.CommodityBatchController;
import controller.controller_implementation.ProductBatchController;
import controller.controller_implementation.RecipeComponentController;
import controller.controller_implementation.UserController;
import controller.controller_implementation.WeightController;
import controller.controller_interface.IWeightController;
import exceptions.DALException;

//@Path("Weight")
public class WeightREST implements IWeightREST {

	private IWeightController wc;

	//@Path("doConnection")
	public void doConnection(@FormParam("ip") String ip, @FormParam("port") int port) throws DALException
	{
		try 
		{
			wc = new WeightController(new ProductBatchController(), new UserController(), new RecipeComponentController(), new CommodityBatchController(), new WeightTranslation(ip, port));
			wc.weightFlow();
		} 
		catch (DALException e) 
		{
			wc.restart();
		}
	}
	

	
}
