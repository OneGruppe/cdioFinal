package controller.controller_interface;

import java.util.List;

import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

public interface IProductbatchComponentController {

	/**
	 * Creates a Product batch Component
	 * @param pbID
	 * @param commodityBatchID
	 * @param userID
	 * @param tara
	 * @param netto
	 * @throws DALException
	 */
	public void createProductBatchComponent(int productBatchComponentID, int commodityBatchID, int productBatchID, int userID, double tara, double netto) throws DALException;

	/**
	 * Updates a Product batch component
	 * @param pbID
	 * @param commodityBatchID
	 * @param userID
	 * @param tara
	 * @param netto
	 * @throws DALException
	 */
	public void updateProductBatchComponent(int productBatchComponentID, int productBatchID, int commodityBatchID, int userID, double tara, double netto) throws DALException;

	/**
	 * Returns a single productbatch component
	 * @param id
	 * @return a single ProductBatchComponentDTO object
	 * @throws DALException
	 */
	public ProductBatchComponentDTO getSingleProductBatchComponent(int id) throws DALException;
	
	/**
	 * Returns a list of what a single productBatch has
	 * @param productBatchID
	 * @return
	 * @throws DALException
	 */
	public List<ProductBatchComponentDTO> getProductBatchComponent(int productBatchID) throws DALException;

	/**
	 * Returns a list of all Product batch components
	 * @param component
	 * @return a list of ProducBatchComponentDTO objects
	 * @throws DALException
	 */
	public List<ProductBatchComponentDTO> getAllProductBatchComponents() throws DALException;


}
