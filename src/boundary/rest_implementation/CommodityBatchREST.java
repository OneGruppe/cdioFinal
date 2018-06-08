package boundary.rest_implementation;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import boundary.rest_interface.ICommodityBatchREST;
import controller.controller_implementation.CommodityBatchController;
import controller.controller_interface.ICommodityBatchController;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public class CommodityBatchREST implements ICommodityBatchREST {

	private ICommodityBatchController cbc;

	public CommodityBatchREST() 
	{
		try {
			cbc = new CommodityBatchController();
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	@PUT
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
	public void updateCommodityBatch(@FormParam("commodityBatchID") int commodityBatchID, @FormParam("commodityID") int commodityID, @FormParam("supplierID") int supplierID, @FormParam("amount") double amount) throws DALException 
	{
		cbc.updateCommodityBatch(commodityBatchID, commodityID, supplierID, amount);	
	}

	@Override
	@DELETE
	@Path("deleteCommodityBatch")
	public void deleteCommodityBatch(@FormParam("commodityBatchID") int combatchID) throws DALException 
	{
		cbc.deleteCommodityBatch(combatchID);

	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCommodityBatch")
	public CommodityBatchDTO getCommodityBatch(@FormParam("commodityBatchID") int combatchID) throws DALException 
	{
		CommodityBatchDTO commoditybatch;
		commoditybatch = cbc.getCommodityBatch(combatchID);
		return commoditybatch;
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllCommodityBatches")
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException 
	{
		List<CommodityBatchDTO> combatchList;
		combatchList = cbc.getAllCommodityBatches();
		return combatchList;
	}

}
