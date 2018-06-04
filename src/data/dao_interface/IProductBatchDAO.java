package data.dao_interface;

import data.dto.ProductBatchDTO;
import exceptions.DALException;

public interface IProductBatchDAO {
	
	/**
	 * Creates a product batch and save it to the database.
	 * @param produktBatch
	 * @throws DALException
	 */
	public void createProductBatch(ProductBatchDTO productBatch) throws DALException;
	/**
	 * Updates the information of the product batch with the given ID.
	 * @param produktBatch
	 * @throws DALException
	 */
	public void updateProductBatch(ProductBatchDTO productBatch) throws DALException;
	
	/**
	 * Deletes the product batch with the given ID
	 * @param produktBatch
	 * @throws DALException
	 */
	public void deleteProductBatch(ProductBatchDTO productBatch) throws DALException;
}
