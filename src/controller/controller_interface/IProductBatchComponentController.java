package controller.controller_interface;

import java.util.List;

import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

public interface IProductBatchComponentController {

	/**
	 * Creates a Product batch Component
	 * @param pbID
	 * @param commodityBatchID
	 * @param userID
	 * @param tara
	 * @param netto
	 * @throws DALException
	 */
	public void createProductBatchComponent(int commodityBatchID, int productBatchID, int userID, double tara, double netto) throws DALException;

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
