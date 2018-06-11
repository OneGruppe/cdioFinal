package boundary.rest_implementation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import boundary.rest_interface.IProductBatchREST;
import controller.controller_implementation.CommodityController;
import controller.controller_implementation.ProductBatchComponentController;
import controller.controller_implementation.ProductBatchController;
import controller.controller_implementation.RecipeComponentController;
import controller.controller_implementation.UserController;
import controller.controller_interface.ICommodityController;
import controller.controller_interface.IProductBatchController;
import controller.controller_interface.IProductbatchComponentController;
import controller.controller_interface.IRecipeComponentController;
import controller.controller_interface.IUserController;
import data.dto.CommodityDTO;
import data.dto.ProductBatchComponentDTO;
import data.dto.ProductBatchDTO;
import data.dto.RecipeComponentDTO;
import data.dto.UserDTO;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("prodBatch")
public class ProductBatchREST implements IProductBatchREST {

	private IProductBatchController pbc;
	private IProductbatchComponentController pbcc;
	private IUserController uc;
	private ICommodityController cc;
	private IRecipeComponentController rcc;

	public ProductBatchREST() 
	{
		try 
		{
			pbc = new ProductBatchController();
			pbcc = new ProductBatchComponentController();
			uc = new UserController();
			cc = new CommodityController();
			rcc = new RecipeComponentController();
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	@POST
	@Path("createProductBatch")
	public String createProductBatch(@FormParam("pbID") int pbID, @FormParam("recipeID") int recipeID, @FormParam("status") int status) 
	{
		String message;

		try 
		{
			pbc.createProductBatch(pbID, recipeID, status);
			message = "Batchet blev oprettet";
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
			message = "Batchet blev ikke oprettet pga. " + e.getMessage();
		}

		return message;
	}

	@Override
	@POST
	@Path("updateProductBatch")
	public void updateProductBatch(@FormParam("pbID") int pbID, @FormParam("recipeID") int recipeID, @FormParam("status") int status)
	{
		try 
		{
			pbc.updateProductBatch(pbID, recipeID, status);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}

	}

	@Override
	@DELETE
	@Path("deleteProductBatch")
	public void deleteProductBatch(@FormParam("pbID") int pbID)
	{
		try 
		{
			pbc.deleteProductBatch(pbID);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}

	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProductBatch")
	public String getProductBatch(@FormParam("componentID") int componentID)
	{
		JSONObject prodJSON = new JSONObject();
		ProductBatchDTO prodbatch;
		ProductBatchComponentDTO prodComp;
		UserDTO user;
		CommodityDTO commodity;
		RecipeComponentDTO rc;

		try 
		{
			if(componentID != 0)
			{
				prodComp = pbcc.getProductBatchComponent(componentID);
				prodbatch = pbc.getProductBatch(prodComp.getProductBatchID());
				rc = rcc.getRecipeComponent(prodbatch.getRecipeID());
				commodity = cc.getCommodity(rc.getCommodityID());
				user = uc.getUser(prodComp.getUserID());

				prodJSON.put("comName", commodity.getName());
				prodJSON.put("pbID", prodComp.getProductBatchID());
				prodJSON.put("recipeID", prodbatch.getRecipeID());
				prodJSON.put("status",  prodbatch.getStatus());
				prodJSON.put("pbcID", prodComp.getId());
				prodJSON.put("comBatchID", prodComp.getCommodityBatchID());
				prodJSON.put("userID", prodComp.getUserID());
				prodJSON.put("name", user.getName());
				prodJSON.put("tara", prodComp.getTara());
				prodJSON.put("netto", prodComp.getNetto());
			}
			else
			{
				System.out.println("FEJL i ID input");
			}
		}
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
		}
		return prodJSON.toString();
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllProductBatches")
	public String getAllProductBatches() 
	{
		JSONArray prodList = new JSONArray();

		try 
		{
			prodList.put(pbc.getAllProductBatches());
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
		return prodList.toString();
	}


}
