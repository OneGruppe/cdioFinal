package data.dao_interface;

import java.util.List;
import data.dto.ProductBatchDTO;
import exceptions.DALException;

public interface IProductBatchDAO 
{
	
	/**
	 * Creates a product batch and save it to the database.
	 * @param productBatch
	 * @throws DALException
	 */
	public void createProductBatch(ProductBatchDTO productBatch) throws DALException;
	/**
	 * Updates the information of the given product batch.
	 * @param productBatch
	 * @throws DALException
	 */
	public void updateProductBatch(ProductBatchDTO productBatch) throws DALException;
	
	/**
	 * Deletes the product batch with the given ID
	 * @param productBatch
	 * @throws DALException
	 */
	public void deleteProductBatch(int productbatchID) throws DALException;
	
	/**
	 * Returns a single product batch
	 * @param productbatchID the id of the product batch
	 * @return user with id productbatchID in form of ProductBatchDTO
	 * @throws DALException
	 */
	public ProductBatchDTO getProductBatch(int productbatchID) throws DALException;
	
	/**
	 * Returns a list of all product batches
	 * @return List of all product batches in form of ProductBatchDTO
	 * @throws DALException
	 */
	public List<ProductBatchDTO> getProductBatch() throws DALException;
}
