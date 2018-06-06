package boundary.rest_implementation;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import boundary.rest_interface.ICommodityBatchREST;
import controller.controller_implementation.CommodityBatchController;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public class CommodityBatchREST implements ICommodityBatchREST {
	
	private CommodityBatchController cbc;
	
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
	public void createCommodityBatch(@FormParam("cbID")int cbID, @FormParam("commodityID") int commodityID, @FormParam("amount") double amount) throws DALException 
	{
		cbc.createCommodityBatch(cbID, commodityID, amount);		
	}

	@Override
	@POST
	@Path("updateCommodityBatch")
	public void updateCommodityBatch(@FormParam("cbID")int cbID, @FormParam("commodityID") int commodityID, @FormParam("amount") double amount) throws DALException 
	{
		cbc.updateCommodityBatch(cbID, commodityID, amount);	
	}

	@Override
	@DELETE
	@Path("deleteCommodityBatch")
	public void deleteCommodityBatch(@FormParam("combatchID") int combatchID) throws DALException 
	{
		cbc.deleteCommodityBatch(combatchID);
		
	}

	@Override
	@POST
	@Path("getCommodityBatch")
	public CommodityBatchDTO getCommodityBatch(@FormParam("combatchID") int combatchID) throws DALException 
	{
		CommodityBatchDTO commoditybatch;
		commoditybatch = cbc.getCommodityBatch(combatchID);
		return commoditybatch;
	}

	@Override
	@GET
	@Path("getAllCommodityBatches")
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException 
	{
		List<CommodityBatchDTO> combatchList;
		combatchList = cbc.getAllCommodityBatches();
		return combatchList;
	}

}
