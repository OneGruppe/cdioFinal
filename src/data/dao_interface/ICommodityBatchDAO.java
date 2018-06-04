package data.dao_interface;

import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public interface ICommodityBatchDAO {

	/**
	 * Creates a commodity batch and saves it to the database.
	 * @param commodityBatch
	 * @throws DALException
	 */
	public void createCommodityBatch(CommodityBatchDTO commodityBatch) throws DALException;
	
	/**
	 * Updates the information of the given commodity batch.
	 * @param commodityBatch
	 * @throws DALException
	 */
	public void updateCommodityBatch(CommodityBatchDTO commodityBatch) throws DALException;
	
	/**
	 * Deletes the commodity batch with the given ID. 
	 * @param commodityBatch
	 * @throws DALException
	 */
	public void deleteCommodityBatch(int cbID) throws DALException;
}
