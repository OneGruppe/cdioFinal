package boundary.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import boundary.rest_interface.ICommodityREST;
import controller.controller.CommodityController;
import controller.controller_interface.ICommodityController;
import data.dto.CommodityDTO;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Path("commodity")
public class CommodityREST implements ICommodityREST {

	private ICommodityController cc;

	public CommodityREST() 
	{
		try 
		{
			cc = new CommodityController();
		}
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ICommodityREST#createCommodity(int, java.lang.String, int)
	 */
	@Override
	@POST
	@Path("createCommodity")
	public void createCommodity(@FormParam("id") int id, @FormParam("name") String name, @FormParam("supplierID") int supplier)
	{
		//TODO
		String message = null;
		try 
		{
			if(id < 1 || name.equals("")) 
			{
				if(id < 1) 
				{
					message = "Fejl, ugyldigt ID!";
				}
				else if(name.equals("")) 
				{
					message = "Fejl, ugyldigt navn!";
				}
			}
			else 
			{
				cc.createCommodity(id, name, supplier);
				message = "Råvaren er blevet oprettet";
			}
		}
		catch(DALException e) 
		{
			message = e.getMessage();
		}
		
		System.out.println(message);
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ICommodityREST#updateCommodity(int, java.lang.String, int)
	 */
	@Override
	@POST
	@Path("updateCommodity")
	public void updateCommodity(@FormParam("id") int id, @FormParam("name") String name, @FormParam("supplier") int supplier)
	{
		//TODO
		String message;
		try
		{
			if(id < 1 || name.equals("")) 
			{
				if(id < 1) 
				{
					message = "Fejl, ugyldigt ID!";
				}
				else if(name.equals("")) 
				{
					message = "Fejl, ugyldigt navn!";
				}
			}
			else 
			{
				String oldName = cc.getCommodity(id).getName();

				cc.updateCommodity(id, oldName, supplier);
				message = "Råvaren " + oldName + " er blevet opdateret til " + name + " - " + id;
			}
		}
		catch(DALException e) 
		{
			message = e.getMessage();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ICommodityREST#getCommodity(int)
	 */
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCommodity")
	public String getCommodity(@FormParam("id") int id) 
	{
		String message;
		JSONObject commodityJSON = new JSONObject();
		CommodityDTO commodity;

		try 
		{
			if(id != 0) 
			{
				commodity = cc.getCommodity(id);
				commodityJSON.put("id", commodity.getId());
				commodityJSON.put("name", commodity.getName());
				commodityJSON.put("supplierID",commodity.getSupplierID());
				message = "Råvaren " + commodity.getName() + " blev fundet";
			}
			else 
			{
				message = "Fejl, der eksiterer ingen råvare med dette ID";
			}
		}
		catch(DALException e) 
		{
			message = e.getMessage();
		}
		System.out.println(message);
		return commodityJSON.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ICommodityREST#getAllCommodities()
	 */
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllCommodities")
	public String getAllCommodities() 
	{
		String message;
		JSONArray commodities = new JSONArray();

		try 
		{
			commodities.put(cc.getAllCommodities());
			message = "Råvarene blev fundet";
		}
		catch(DALException e) 
		{
			message = e.getMessage();
		}
		System.out.println(message);
		return commodities.toString();
	}


}
