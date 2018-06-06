package boundary.rest_interface;

import java.util.List;

import data.dto.ProductBatchDTO;
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
	public void createProductBatch(int pbID, int status, int recipeID, int userID, int comBatID, double tara, double netto) throws DALException;
	
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
	public void updateProductBatch(int pbID, int status, int recipeID, int userID, int comBatID, double tara, double netto) throws DALException;
	
	/**
	 * <h1> <i>deleteProductBatch</i> </h1> <br>
	 * Deletes a productbatch
	 * @param pbID
	 * @throws DALException
	 */
	public void deleteProductBatch(int pbID) throws DALException;
	
	/**
	 * <h1> <i>getProductBatch</i> </h1> <br>
	 * Get a productbatch
	 * @param pbID
	 * @return a single productbatch
	 * @throws DALException
	 */
	public ProductBatchDTO getProductBatch(int pbID) throws DALException;
	
	/**
	 * <h1> <i>getAllProductBatches</i> </h1> <br>
	 * Get a list of all productbatches
	 * @return a list of ProductBatchDTO objects
	 * @throws DALException
	 */
	public List<ProductBatchDTO> getAllProductBatches() throws DALException;

}
