package data.dao_interface;

import java.util.List;

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
	 * Returns a single commoditybatch
	 * @param id
	 * @return a single CommodityBatchDTO obejct
	 * @throws DALException
	 */
	public CommodityBatchDTO getCommodityBatchSingle(int id) throws DALException;
	
	/**
	 * Returns a list of commoditybatches for with the specific commodity
	 * @param commodityID
	 * @return a list of CommodityBatchDTO objects
	 * @throws DALException
	 */
	public List<CommodityBatchDTO> getCommodityBatch(int commodityID) throws DALException;

	/**
	 * Returns a list of all commodity batches
	 * @return List of all commodity batches in form of CommodityBatchDTO
	 * @throws DALException
	 */
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException;


}
