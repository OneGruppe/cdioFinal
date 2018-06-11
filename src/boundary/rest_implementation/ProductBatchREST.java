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

import boundary.rest_interface.IProductBatchREST;
import controller.controller_implementation.ProductBatchController;
import controller.controller_interface.IProductBatchController;
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

	@Override
	@POST
	@Path("updateProductBatch")
	public void updateProductBatch(@FormParam("id") int id, @FormParam("recipeID") int recipeID, @FormParam("status") int status)
	{
		try 
		{
			pbc.updateProductBatch(id, recipeID, status);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}

	}

	@Override
	@DELETE
	@Path("deleteProductBatch")
	public void deleteProductBatch(@FormParam("id") int id)
	{
		try 
		{
			pbc.deleteProductBatch(id);
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
	public String getProductBatch(@FormParam("id") int id)
	{
		JSONArray pbJSON = new JSONArray();
		
		try 
		{
			pbJSON.put(pbc.getProductBatch(id));
		}
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
		}
		return pbJSON.toString();
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
