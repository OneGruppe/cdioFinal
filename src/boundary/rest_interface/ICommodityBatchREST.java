package boundary.rest_interface;

import exceptions.DALException;

public interface ICommodityBatchREST {

	/**
	 * <h1> <i>createCommodityBatch</i> </h1> <br>
	 * Creates a commoditybatch
	 * @param id
	 * @param commodityID
	 * @param amount
	 * @throws DALException
	 */
	public void createCommodityBatch(int id, int commodityID, double amount);
	/**
	 * <h1> <i>updateCommodityBatch</i> </h1> <br>
	 * Updates a commoditybatch
	 * @param id
	 * @param commodityID
	 * @param amount
	 * @throws DALException
	 */
	public void updateCommodityBatch(int id, int commodityID, double amount);

	/**
	 * <h1> <i>deleteCommodityBatch</i> </h1> <br>
	 * Deletes a commoditybatch
	 * @param id
	 * @throws DALException
	 */
	public void deleteCommodityBatch(int id);
	
	/**
	 * Returns a single commoditybatch
	 * @param id
	 * @return a single CommodityBatchDTO as JSON object in toString() format
	 */
	public String getCommodityBatchSingle(int id);

	/**
	 * <h1> <i>getCommodityBatch</i> </h1> <br>
	 * Get a single commoditybatch
	 * @param commodityID
	 * @return a signle CommodityBatchDTO object
	 * @throws DALException
	 */
	public String getCommodityBatch(int commodityID);

	/**
	 * <h1> <i>getAllCommodityBatches</i> </h1> <br>
	 * Get a list of all commoditybatches
	 * @return a lsit of CommodityBatchDTO objects
	 * @throws DALException
	 */
	public String getAllCommodityBatches();


}
