package controller.controller_interface;

import java.util.List;

import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public interface ICommodityBatchController {

	/**
	 * Creates a commoditybatch
	 * @param cbID
	 * @param commodityID
	 * @param amount
	 * @throws DALException
	 */
	public void createCommodityBatch(int cbID, int commodityID, int supplierID, double amount) throws DALException;
	
	/**
	 * Updates a commoditybatch
	 * @param cbID
	 * @param commodityID
	 * @param amount
	 * @throws DALException
	 */
	public void updateCommodityBatch(int cbID, int commodityID, int supplierID, double amount) throws DALException;
	
	/**
	 * Deletes a commoditybatch
	 * @param combatchID
	 * @throws DALException
	 */
	public void deleteCommodityBatch(int combatchID) throws DALException;
	
	/**
	 * Get a single commoditybatch
	 * @param combatchID
	 * @return a signle CommodityBatchDTO object
	 * @throws DALException
	 */
	public CommodityBatchDTO getCommodityBatch(int combatchID) throws DALException;
	
	/**
	 * Get a list of all commoditybatches
	 * @return a lsit of CommodityBatchDTO objects
	 * @throws DALException
	 */
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException;
}
