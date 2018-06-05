package controller.controller_interface;

import java.util.List;

import data.dto.ProductBatchDTO;
import exceptions.DALException;

public interface IProductBatchController {
	
	/**
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
	 * Deletes a productbatch
	 * @param pbID
	 * @throws DALException
	 */
	public void deleteProductBatch(int pbID) throws DALException;
	
	/**
	 * Get a productbatch
	 * @param pbID
	 * @return a single productbatch
	 * @throws DALException
	 */
	public ProductBatchDTO getProductBatch(int pbID) throws DALException;
	
	/**
	 * Get a list of all productbatches
	 * @return a list of ProductBatchDTO objects
	 * @throws DALException
	 */
	public List<ProductBatchDTO> getAllProductBatches() throws DALException;
}
