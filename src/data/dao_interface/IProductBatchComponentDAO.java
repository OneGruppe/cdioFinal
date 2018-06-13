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
	 * Return a single productbatch component
	 * @param productBatchComponentID
	 * @return a single ProductBatchComponentDTO object
	 * @throws DALException
	 */
	public ProductBatchComponentDTO getSingleProductBatchComponent(int productBatchComponentID) throws DALException;
	
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
	public List<ProductBatchComponentDTO> getAllProductBatchComponents() throws DALException;

}
