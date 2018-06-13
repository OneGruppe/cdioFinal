package controller.controller_interface;

import java.util.List;

import data.dto.ProductBatchDTO;
import exceptions.DALException;

public interface IProductBatchController
{

	/**
	 * Creates a ProductBatch
	 * @param id
	 * @param recipeID
	 * @param status
	 * @throws DALException
	 */
	public void createProductBatch(int id, int recipeID, int status) throws DALException;

	/**
	 * Updates a ProductBatch
	 * @param id
	 * @param recipeID
	 * @param status
	 * @throws DALException
	 */
	public void updateProductBatch(int id, int recipeID, int status) throws DALException;

	/**
	 * Get a ProductBatch
	 * @param id
	 * @return a single ProductBatch
	 * @throws DALException
	 */
	public ProductBatchDTO getProductBatch(int id) throws DALException;

	/**
	 * Get a list of all ProductBatches
	 * @return a list of ProductBatchDTO objects
	 * @throws DALException
	 */
	public List<ProductBatchDTO> getAllProductBatches() throws DALException;
}
