package boundary.rest_implementation;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

import boundary.rest_interface.IProductBatchComponentREST;
import controller.controller_implementation.ProductBatchComponentController;
import controller.controller_interface.IProductbatchComponentController;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Path("prodBatchComponent")
public class ProductBatchComponentREST implements IProductBatchComponentREST {
	
	private IProductbatchComponentController prodBatchCompController;
	
	public ProductBatchComponentREST() 
	{
		try 
		{
			prodBatchCompController = new ProductBatchComponentController();
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	@POST
	@Path("createProductBatchComponent")
	public void createProductBatchComponent(@FormParam("id") int id, @FormParam("commodityBatchID") int commodityBatchID, @FormParam("prodBatchID") int productBatchID, @FormParam("userID") int userID, @FormParam("tara") double tara, @FormParam("netto") double netto) 
	{
		try 
		{
			prodBatchCompController.createProductBatchComponent(id, productBatchID, commodityBatchID, userID, tara, netto);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	@POST
	@Path("updateProductBatchComponent")
	public void updateProductBatchComponent(@FormParam("id") int id, @FormParam("prodBatchID")int productBatchID, @FormParam("commodityBatchID") int commodityBatchID, @FormParam("userID") int userID, @FormParam("tara") double tara, @FormParam("netto") double netto)
	{
		try 
		{
			prodBatchCompController.updateProductBatchComponent(id, productBatchID, commodityBatchID, userID, tara, netto);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("getProductBatchComponent")
	public String getProductBatchComponent(@FormParam("id") int id) 
	{
		JSONArray prodComJSON = new JSONArray();

		try
		{
			prodComJSON.put(prodBatchCompController.getProductBatchComponent(id));
		}
		catch(DALException e)
		{
			System.out.println(e.getMessage());
		}
		return prodComJSON.toString();
	}

	@Override
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Path("getAllProductBatchComponents")
	public String getAllProductBatchComponents() 
	{
		JSONArray prodComJSON = new JSONArray();
		
		try 
		{
			prodComJSON.put(prodBatchCompController.getAllProductBatchComponents());
		}
		catch(DALException e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}

}
