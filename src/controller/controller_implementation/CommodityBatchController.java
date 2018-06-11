package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.ICommodityBatchController;
import data.dao_implementation.CommodityBatchDAO;
import data.dao_interface.ICommodityBatchDAO;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public class CommodityBatchController implements ICommodityBatchController {

	private ICommodityBatchDAO comdao;

	public CommodityBatchController() throws DALException
	{
		comdao = new CommodityBatchDAO();  
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityBatchController#createCommodityBatch(int, int, int, double)
	 */
	@Override
	public void createCommodityBatch(int id, int commodityID, double amount) throws DALException 
	{
		CommodityBatchDTO combatch = new CommodityBatchDTO(id, commodityID, amount);
		comdao.createCommodityBatch(combatch);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityBatchController#updateCommodityBatch(int, int, int, double)
	 */
	@Override
	public void updateCommodityBatch(int id, int commodityID, double amount) throws DALException 
	{		
		CommodityBatchDTO combatch = new CommodityBatchDTO(id, commodityID, amount);
		comdao.updateCommodityBatch(combatch);			
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityBatchController#deleteCommodityBatch(int)
	 */
	@Override
	public void deleteCommodityBatch(int id) throws DALException 
	{
		comdao.deleteCommodityBatch(id);			
	}
	
	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityBatchController#getCommodityBatchSingle(int)
	 */
	
	@Override
	public CommodityBatchDTO getCommodityBatchSingle(int id) throws DALException 
	{
		CommodityBatchDTO commodityBatch;
		commodityBatch = comdao.getCommodityBatchSingle(id);
		return commodityBatch;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityBatchController#getCommodityBatch(int)
	 */
	@Override
	public List<CommodityBatchDTO> getCommodityBatch(int commodityID) throws DALException 
	{ 
		return comdao.getCommodityBatch(commodityID);			
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityBatchController#getAllCommodityBatches()
	 */
	@Override
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException 
	{
		List<CommodityBatchDTO> combatchList;
		combatchList = comdao.getAllCommodityBatches();
		return combatchList;			
	}

}
