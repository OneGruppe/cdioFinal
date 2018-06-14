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
import controller.controller_interface.IProductBatchComponentController;
import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Path("prodBatchComponent")
public class ProductBatchComponentREST implements IProductBatchComponentREST {

	private IProductBatchComponentController prodBatchCompController;

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

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IProductBatchComponentREST#createProductBatchComponent(int, int, int, double, double)
	 */
	@Override
	@POST
	@Path("createProductBatchComponent")
	public String createProductBatchComponent(@FormParam("commodityBatchID") int commodityBatchID, @FormParam("prodBatchID") int productBatchID, @FormParam("userID") int userID, @FormParam("tara") double tara, @FormParam("netto") double netto) 
	{
		JSONObject returnMessage = new JSONObject();

		try 
		{
			prodBatchCompController.createProductBatchComponent(productBatchID, commodityBatchID, userID, tara, netto);
			returnMessage.put("message", "Produktbatch komponent " + productBatchID + " oprettet");
			return returnMessage.toString();
		} 
		catch (DALException e) 
		{
			returnMessage.put("message", e.getMessage());
			return returnMessage.toString();
		}

	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IProductBatchComponentREST#getSingleProductBatchComponent(int)
	 */
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getSingleProductBatchComponent")
	public String getSingleProductBatchComponent(int id) 
	{
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
				return componentJSON.toString();
			}
			else
			{
				return "Ugyldigt ID blev indtastet\nPr�v igen";
			}
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IProductBatchComponentREST#getProductBatchComponent(int)
	 */
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
			return prodComJSON.toString();
		}
		catch(DALException e)
		{
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IProductBatchComponentREST#getAllProductBatchComponents()
	 */
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
			return prodComJSON.toString();
		}
		catch(DALException e)
		{
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}


}
