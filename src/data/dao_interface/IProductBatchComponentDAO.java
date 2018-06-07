package data.dao_interface;

import java.util.List;

import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

public interface IProductBatchComponentDAO {
	/**
	 * Creates a Product batch component and saves it to the database.
	 * @param productBatchComponent
	 * @throws DALException
	 */
	public void createProductBatchComponent(ProductBatchComponentDTO productBatchComponent) throws DALException;
	
	/**
	 * Update the information of the given Prroduct batch component.
	 * @param productBatchComponent
	 * @throws DALException
	 */
	public void updateProductBatchComponent(ProductBatchComponentDTO productBatchComponent) throws DALException;
	
	/**
	 * Returns a single Product batch component.
	 * @param ProductBatchComponent
	 * @return a given Product batch component as a ProductBatchComponentDTO object.
	 * @throws DALException
	 */
	public List<ProductBatchComponentDTO> getProductBatchComponent(int ProductBatchComponent) throws DALException;
	
	/**
	 * Returns a list of all Product batch components.
	 * @return a list of all Product batch components as objects of ProductBatchComponentDTO.
	 * @throws DALException
	 */
	public List<ProductBatchComponentDTO> getAllProductBatchComponents() throws DALException;
	
	

}
