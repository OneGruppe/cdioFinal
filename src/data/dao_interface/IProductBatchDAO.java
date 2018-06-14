package data.dao_interface;

import java.util.List;

import data.dto.ProductBatchDTO;
import exceptions.DALException;

public interface IProductBatchDAO {

	/**
	 * Creates a Product batch and saves it to the database.
	 * @param productBatch
	 * @throws DALException
	 */
	public void createProductBatch(ProductBatchDTO productBatch) throws DALException;

	/** 
	 * Update the information of the given Product batch. 
	 * @param productBatch 
	 * @throws DALException 
	 */ 
	public void updateProductBatch(ProductBatchDTO productBatch) throws DALException; 

	/**
	 * Returns a single Product batch.
	 * @param ProductBatch
	 * @return a given Product batch as a ProductBatchDTO object.
	 * @throws DALException
	 */
	public ProductBatchDTO getProductBatch(int ProductBatch) throws DALException;

	/**
	 * Returns a list of all Product batch.
	 * @return a list of all Product batch as objects of ProductBatchDTO.
	 * @throws DALException
	 */
	public List<ProductBatchDTO> getAllProductBatches() throws DALException;


}
