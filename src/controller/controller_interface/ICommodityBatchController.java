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
	public void createCommodityBatch(int id, int commodityID, double amount) throws DALException;

	/**
	 * Updates a commoditybatch
	 * @param cbID
	 * @param commodityID
	 * @param amount
	 * @throws DALException
	 */
	public void updateCommodityBatch(int id, int commodityID, double amount) throws DALException;

	/**
	 * Deletes a commoditybatch
	 * @param combatchID
	 * @throws DALException
	 */
	public void deleteCommodityBatch(int id) throws DALException;

	/**
	 * Get a single commoditybatch
	 * @param combatchID
	 * @return a signle CommodityBatchDTO object
	 * @throws DALException
	 */
	public List<CommodityBatchDTO> getCommodityBatch(int id) throws DALException;

	/**
	 * Get a list of all commoditybatches
	 * @return a lsit of CommodityBatchDTO objects
	 * @throws DALException
	 */
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException;


}
