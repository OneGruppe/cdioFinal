package data.dao_interface;

import java.util.List;

import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

public interface IProductBatchComponentDAO {
	
	/**
	 * Creates a ProductBatch component
	 * @param component
	 * @throws DALException
	 */
	public void createProductBatchComponent(ProductBatchComponentDTO component) throws DALException;
	
	/**
	 * Updates a given ProductBatch component DTO
	 * @param component
	 * @throws DALException
	 */
	public void updateProductBatchComponent(ProductBatchComponentDTO component) throws DALException;
	
	/**
	 * Deletes a given ProductBatch component DTO
	 * @param component
	 * @throws DALException
	 */
	public void deleteProductBatchComponent(ProductBatchComponentDTO component) throws DALException;
	
	/**
	 * Retrieves a given ProductBatch component based on its ID
	 * @param componentID
	 * @return a ProductBatchComponentDTO
	 * @throws DALException
	 */
	public List<ProductBatchComponentDTO> getProductBatchComponent(int productBatchID) throws DALException;
	
	
	/**
	 * Retrieves a list of all ProductBatch components 
	 * @return a list of all ProductBatchComponentDTOs
	 * @throws DALException
	 */
	public List<ProductBatchComponentDTO> getAllProductBatchComponenter() throws DALException;

}
