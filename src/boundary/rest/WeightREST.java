package boundary.rest;

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import boundary.rest_interface.IWeightREST;
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

@Path("Weight")
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
	public String doConnection(@FormParam("chooseWeightPort") String chooseWeightPort)
	{
		int weightPort = 0;

		if(chooseWeightPort.equals("Vægt 1"))
		{
			weightPort = Constant.weightPortOne;
		}
		else if (chooseWeightPort.equals("Vægt 2"))
		{
			weightPort = Constant.weightPortTwo;
		}
		else
		{
			return "Der findes ikke en port til '" + chooseWeightPort + "'";
		}

		try 
		{
			pbc = new ProductBatchController();
			uc = new UserController();
			rcc = new RecipeComponentController();
			cbc = new CommodityBatchController();
			cc = new CommodityController();
			pbcc = new ProductBatchComponentController();
			iwc = new WeightTranslation(weightPort);
			wc = new WeightController(pbc, uc, rcc, cbc, cc, pbcc, iwc);
			wc.weightFlow();
			return "Forbindelse blev oprettet korrekt";
		} 
		catch (DALException | IOException | WeightException e) 
		{
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}


}
