package boundary.rest_interface;

import exceptions.DALException;

public interface IProductBatchREST {
	
	/**
	 * <h1> <i>createProductBatch</i> </h1> <br>
	 * Creates a ProductBatch
	 * @param it
	 * @param recipeID
	 * @param status
	 * @throws DALException
	 */
	public String createProductBatch(int id, int recipeID, int status);

	/**
	 * <h1> <i>getProductBatch</i> </h1> <br>
	 * Get a ProductBatch
	 * @param id
	 * @return a single ProductBatch
	 * @throws DALException
	 */
	public String getProductBatch(int id);

	/**
	 * <h1> <i>getAllProductBatches</i> </h1> <br>
	 * Get a list of all ProductBatches
	 * @return a list of ProductBatchDTO objects
	 * @throws DALException
	 */
	public String getAllProductBatches();


}
