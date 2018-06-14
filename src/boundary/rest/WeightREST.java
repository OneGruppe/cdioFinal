package boundary.rest;

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.json.JSONObject;

import boundary.rest_interface.IWeightREST;
import boundary.weight.WeightTranslation;
import boundary.weight_interface.IWeightTranslation;
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

@Path("weight")
public class WeightREST implements IWeightREST {

	private IWeightController wc;
	private IProductBatchController pbc;
	private IUserController uc;
	private IRecipeComponentController rcc;
	private ICommodityBatchController cbc;
	private ICommodityController cc;
	private IProductBatchComponentController pbcc;
	private IWeightTranslation iwc;

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IWeightREST#doConnection(java.lang.String)
	 */
	@Override
	@POST
	@Path("doConnection")
	public String doConnection(@FormParam("portNumber") int chooseWeightPort)
	{
		JSONObject returnMessage = new JSONObject();
		
		try
		{
			pbc = new ProductBatchController();
			uc = new UserController();
			rcc = new RecipeComponentController();
			cbc = new CommodityBatchController();
			cc = new CommodityController();
			pbcc = new ProductBatchComponentController();
			iwc = new WeightTranslation(chooseWeightPort);
			wc = new WeightController(pbc, uc, rcc, cbc, cc, pbcc, iwc);
			wc.weightFlow();
			returnMessage.put("message", "Forbindelse blev oprettet korrekt!");
			return returnMessage.toString();
		} 
		catch (DALException | IOException e) 
		{
			returnMessage.put("message", e.getMessage());
			return returnMessage.toString();
		}
		catch (WeightException e)
		{
			returnMessage.put("message", e.getMessage());
			return returnMessage.toString();
		}
	}


}
