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
	public void deleteCommodityBatch(int combatchID) throws DALException;

	/**
	 * Returns a single commodity batch
	 * @param combatchID the id of the commodity batch
	 * @return user with id combatchID in form of CommodityBatchDTO
	 * @throws DALException
	 */
	public CommodityBatchDTO getCommodityBatch(int combatchID) throws DALException;
	
	/**
	 * Returns a list of commoditybatches for with the specific commodity
	 * @param commodityID
	 * @return a list of CommodityBatchDTO objects
	 * @throws DALException
	 */
	
	public List<CommodityBatchDTO> getCommodityBatchList(int commodityID) throws DALException;

	/**
	 * Returns a list of all commodity batches
	 * @return List of all commodity batches in form of CommodityBatchDTO
	 * @throws DALException
	 */
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException;


}
