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

import boundary.rest_interface.ICommodityBatchREST;
import controller.controller.CommodityBatchController;
import controller.controller_interface.ICommodityBatchController;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("comBatch")
public class CommodityBatchREST implements ICommodityBatchREST {

	private ICommodityBatchController cbc;

	public CommodityBatchREST() 
	{
		try 
		{
			cbc = new CommodityBatchController();
		} catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ICommodityBatchREST#createCommodityBatch(int, int, double)
	 */
	@Override
	@POST
	@Path("createCommodityBatch")
	public void createCommodityBatch(@FormParam("id") int id, @FormParam("commodityID") int commodityID, @FormParam("amount") double amount) 
	{
		try 
		{
			cbc.createCommodityBatch(id, commodityID, amount);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}		
	}
	
	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ICommodityBatchREST#getCommodityBatchSingle(int)
	 */
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getSingleCommodity")
	public String getCommodityBatchSingle(@FormParam("id") int id) 
	{
		String message;

		JSONObject combatchJSON = new JSONObject();
		CommodityBatchDTO commodityBatch;

		try 
		{
			if(id != 0)
			{
				commodityBatch = cbc.getCommodityBatchSingle(id);
				combatchJSON.put("id", commodityBatch.getId());
				combatchJSON.put("commodityID", commodityBatch.getCommodityID());
				combatchJSON.put("amount", commodityBatch.getAmount());

				message = "Råvarebatchet med id " + id + " blev fundet";
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

		return combatchJSON.toString(); 
	}
	
	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ICommodityBatchREST#getCommodityBatch(int)
	 */
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCommodityBatch")
	public String getCommodityBatch(@FormParam("commodityID") int commodityID) 
	{
		
		JSONArray comJSON = new JSONArray();

		try
		{
			comJSON.put(cbc.getCommodityBatch(commodityID));
		}
		catch(DALException e)
		{
			System.out.println(e.getMessage());
		}
		return comJSON.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ICommodityBatchREST#getAllCommodityBatches()
	 */
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllCommodityBatches")
	public String getAllCommodityBatches() 
	{
		JSONArray combatches = new JSONArray();

		try 
		{
			combatches.put(cbc.getAllCommodityBatches());
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
		return combatches.toString();
	}
}
