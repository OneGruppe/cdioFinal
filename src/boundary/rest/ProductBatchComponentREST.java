package boundary.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import boundary.rest_interface.IProductBatchComponentREST;
import controller.controller.ProductBatchComponentController;
import controller.controller_interface.IProductbatchComponentController;
import data.dto.ProductBatchComponentDTO;
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
	public void createProductBatchComponent(@FormParam("commodityBatchID") int commodityBatchID, @FormParam("prodBatchID") int productBatchID, @FormParam("userID") int userID, @FormParam("tara") double tara, @FormParam("netto") double netto) 
	{
		try 
		{
			prodBatchCompController.createProductBatchComponent(productBatchID, commodityBatchID, userID, tara, netto);
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
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getSingleProductBatchComponent")
	public String getSingleProductBatchComponent(int id) 
	{
		System.out.println("Første");
		String message;

		JSONObject componentJSON = new JSONObject();
		ProductBatchComponentDTO component;

		try 
		{
			if(id != 0)
			{
				component = prodBatchCompController.getSingleProductBatchComponent(id);
				componentJSON.put("id", component.getId());
				componentJSON.put("commodityBatchID", component.getCommodityBatchID());
				componentJSON.put("productBatchID", component.getProductbatchID());
				componentJSON.put("userID", component.getUserID());
				componentJSON.put("tara", component.getTara());
				componentJSON.put("netto", component.getNetto());

				message = "Komponenten med id" + component.getId() + " blev fundet";
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

		return componentJSON.toString();
	}

	@Override
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Path("getProductBatchComponent")
	public String getProductBatchComponent(@FormParam("id") int id) 
	{
		System.out.println("TJEK");
		JSONArray prodComJSON = new JSONArray();

		try
		{
			prodComJSON.put(prodBatchCompController.getProductBatchComponent(id));
		}
		catch(DALException e)
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println(prodComJSON.toString());
		
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
