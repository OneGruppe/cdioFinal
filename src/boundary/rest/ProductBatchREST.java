package boundary.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import boundary.rest_interface.IProductBatchREST;
import controller.controller.ProductBatchController;
import controller.controller_interface.IProductBatchController;
import data.dto.ProductBatchDTO;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("prodBatch")
public class ProductBatchREST implements IProductBatchREST
{
	private IProductBatchController pbc;

	public ProductBatchREST() 
	{
		try 
		{
			pbc = new ProductBatchController();
		}
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IProductBatchREST#createProductBatch(int, int, int)
	 */
	@Override
	@POST
	@Path("createProductBatch")
	public String createProductBatch(@FormParam("id") int id, @FormParam("recipeID") int recipeID, @FormParam("status") int status) 
	{
		String message;

		try 
		{
			pbc.createProductBatch(id, recipeID, status);
			message = "Batchet blev oprettet";
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
			message = "Batchet blev ikke oprettet pga. " + e.getMessage();
		}

		return message;
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IProductBatchREST#getProductBatch(int)
	 */
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProductBatch")
	public String getProductBatch(@FormParam("id") int id)
	{
		String message;

		JSONObject prodJSON = new JSONObject();
		ProductBatchDTO prod;

		try 
		{
			if(id != 0)
			{
				prod = pbc.getProductBatch(id);
				prodJSON.put("id", prod.getId());
				prodJSON.put("recipeID", prod.getRecipeID());
				prodJSON.put("status", prod.getStatus());

				message = "Produktionsbatchet med id " + id + " blev fundet";
			}
			else
			{
				message = "Ugyldigt ID blev indtastet\nPrøv igen";
			}
		} 
		catch (DALException e) 
		{
			message = e.getMessage();
		}

		System.out.println(message);

		return prodJSON.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IProductBatchREST#getAllProductBatches()
	 */
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
