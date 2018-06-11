package boundary.rest_interface;

import exceptions.DALException;

public interface IProductBatchREST {

	/**
	 * <h1> <i>createProductBatch</i> </h1> <br>
	 * Creates a productbatch
	 * @param pbID
	 * @param status
	 * @param recipeID
	 * @param userID
	 * @param comBatID
	 * @param tara
	 * @param netto
	 * @throws DALException
	 */
	public String createProductBatch(int pbID, int recipeID, int status);

	/**
	 * <h1> <i>updateProductBatch</i> </h1> <br>
	 * Updates a productbatch
	 * @param pbID
	 * @param status
	 * @param recipeID
	 * @param userID
	 * @param comBatID
	 * @param tara
	 * @param netto
	 * @throws DALException
	 */
	public void updateProductBatch(int pbID, int recipeID, int status);

	/**
	 * <h1> <i>deleteProductBatch</i> </h1> <br>
	 * Deletes a productbatch
	 * @param pbID
	 * @throws DALException
	 */
	public void deleteProductBatch(int pbID);

	/**
	 * <h1> <i>getProductBatch</i> </h1> <br>
	 * Get a productbatch
	 * @param pbID
	 * @return a single productbatch
	 * @throws DALException
	 */
	public String getProductBatch(int componentID);

	/**
	 * <h1> <i>getAllProductBatches</i> </h1> <br>
	 * Get a list of all productbatches
	 * @return a list of ProductBatchDTO objects
	 * @throws DALException
	 */
	public String getAllProductBatches();


}
