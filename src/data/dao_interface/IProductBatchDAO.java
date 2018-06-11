package data.dao_interface;

import java.util.List;

import data.dto.ProductBatchDTO;
import exceptions.DALException;

public interface IProductBatchDAO {

	/**
	 * Creates a Product batch component and saves it to the database.
	 * @param productBatchComponent
	 * @throws DALException
	 */
	public void createProductBatchComponent(ProductBatchDTO productBatch) throws DALException;

	/**
	 * Update the information of the given Prroduct batch component.
	 * @param productBatchComponent
	 * @throws DALException
	 */
	public void updateProductBatchComponent(ProductBatchDTO productBatch) throws DALException;

	/**
	 * Returns a list of all Product batch components.
	 * @param prodbatcomID
	 * @throws DALException
	 */
	public void deleteProductBatchComponent(int productBatchID) throws DALException;


	/**
	 * Returns a single Product batch component.
	 * @param ProductBatchComponent
	 * @return a given Product batch component as a ProductBatchComponentDTO object.
	 * @throws DALException
	 */
	public ProductBatchDTO getProductBatchComponent(int ProductBatch) throws DALException;

	/**
	 * Returns a list of all Product batch components.
	 * @return a list of all Product batch components as objects of ProductBatchComponentDTO.
	 * @throws DALException
	 */
	public List<ProductBatchDTO> getAllProductBatchComponents() throws DALException;


}
