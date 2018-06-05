package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.ICommodityBatchController;
import data.dao_implementation.CommodityBatchDAO;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public class CommodityBatchController implements ICommodityBatchController{
	
	CommodityBatchDAO comdao;
	
	public CommodityBatchController() throws DALException
	{
		comdao = new CommodityBatchDAO();  
	}

	@Override
	public void createCommodityBatch(int cbID, int commodityID, double amount) throws DALException 
	{
		CommodityBatchDTO combatch = new CommodityBatchDTO(cbID, commodityID, amount);
		
		comdao.createCommodityBatch(combatch);
		
	}

	@Override
	public void updateCommodityBatch(int cbID, int commodityID, double amount) throws DALException 
	{
		CommodityBatchDTO combatch = new CommodityBatchDTO(cbID, commodityID, amount);
		
		comdao.updateCommodityBatch(combatch);
	}

	@Override
	public void deleteCommodityBatch(int combatchID) throws DALException 
	{
		comdao.deleteCommodityBatch(combatchID);
	}

	@Override
	public CommodityBatchDTO getCommodityBatch(int combatchID) throws DALException 
	{
		CommodityBatchDTO combatch;
		combatch = comdao.getCommodityBatch(combatchID);
		return combatch;
	}

	@Override
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException 
	{
		List<CommodityBatchDTO> combatchList;
		combatchList = comdao.getAllCommodityBatches();
		return combatchList;
	}

}
