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

import boundary.rest_interface.ICommodityBatchREST;
import controller.controller_implementation.CommodityBatchController;
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

	@Override
	@POST
	@Path("createCommodityBatch")
	public void createCommodityBatch(@FormParam("commodityBatchID") int commodityBatchID, @FormParam("commodityID") int commodityID, @FormParam("supplierID") int supplierID, @FormParam("amount") double amount) 
	{
		try 
		{
			cbc.createCommodityBatch(commodityBatchID, commodityID, supplierID, amount);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}		
	}

	@Override
	@POST
	@Path("updateCommodityBatch")
	public void updateCommodityBatch(@FormParam("commodityBatchID") int commodityBatchID, @FormParam("commodityID") int commodityID, @FormParam("supplierID") int supplierID, @FormParam("amount") double amount) 
	{
		try 
		{
			cbc.updateCommodityBatch(commodityBatchID, commodityID, supplierID, amount);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}	
	}

	@Override
	@DELETE
	@Path("deleteCommodityBatch")
	public void deleteCommodityBatch(@FormParam("commodityBatchID") int combatchID) 
	{
		try 
		{
			cbc.deleteCommodityBatch(combatchID);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCommodityBatch")
	public String getCommodityBatch(@FormParam("commodityBatchID") int combatchID) 
	{
		CommodityBatchDTO commoditybatch;
		JSONObject comJSON = new JSONObject();

		try
		{
			if(combatchID != 0)
			{
				commoditybatch = cbc.getCommodityBatch(combatchID);

				comJSON.put("cbID", commoditybatch.getId());
				comJSON.put("commodityID", commoditybatch.getCommodityID());
				comJSON.put("supplierID", commoditybatch.getSupplierID());
				comJSON.put("amount", commoditybatch.getAmount());
			} 
			else
			{
				System.out.println("Fejl");
			}
		}
		catch(DALException e)
		{
			System.out.println(e.getMessage());
		}
		return comJSON.toString();
	}

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
