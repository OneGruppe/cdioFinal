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
import controller.controller_implementation.ProductBatchController;
import controller.controller_interface.IProductBatchController;
import data.dto.ProductBatchDTO;
import exceptions.DALException;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("prodBatch")
public class ProductBatchREST implements IProductBatchREST {

	private IProductBatchController pbc;

	public ProductBatchREST() 
	{
		try {
			pbc = new ProductBatchController();
		} catch (DALException e) {
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
	public String getProductBatch(@FormParam("pbID") int pbID)
	{

		JSONObject prodJSON = new JSONObject();
		ProductBatchDTO prodbatch;

		try 
		{

			if(pbID != 0)
			{
				prodbatch = pbc.getProductBatch(pbID);

				prodJSON.put("pbID", prodbatch.getId());
				prodJSON.put("recipeID", prodbatch.getRecipeID());
				prodJSON.put("status",  prodbatch.getStatus());

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
