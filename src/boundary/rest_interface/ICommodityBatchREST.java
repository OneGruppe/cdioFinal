package boundary.rest_interface;

import java.util.List;

import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public interface ICommodityBatchREST {
	
	/**
	 * <h1> <i>createCommodityBatch</i> </h1> <br>
	 * Creates a commoditybatch
	 * @param cbID
	 * @param commodityID
	 * @param amount
	 * @throws DALException
	 */
	public void createCommodityBatch(int cbID, int commodityID, double amount) throws DALException;
	
	/**
	 * <h1> <i>updateCommodityBatch</i> </h1> <br>
	 * Updates a commoditybatch
	 * @param cbID
	 * @param commodityID
	 * @param amount
	 * @throws DALException
	 */
	public void updateCommodityBatch(int cbID, int commodityID, double amount) throws DALException;
	
	/**
	 * <h1> <i>deleteCommodityBatch</i> </h1> <br>
	 * Deletes a commoditybatch
	 * @param combatchID
	 * @throws DALException
	 */
	public void deleteCommodityBatch(int combatchID) throws DALException;
	
	/**
	 * <h1> <i>getCommodityBatch</i> </h1> <br>
	 * Get a single commoditybatch
	 * @param combatchID
	 * @return a signle CommodityBatchDTO object
	 * @throws DALException
	 */
	public CommodityBatchDTO getCommodityBatch(int combatchID) throws DALException;
	
	/**
	 * <h1> <i>getAllCommodityBatches</i> </h1> <br>
	 * Get a list of all commoditybatches
	 * @return a lsit of CommodityBatchDTO objects
	 * @throws DALException
	 */
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException;

}
