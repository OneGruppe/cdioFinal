package data.dao;

public interface IProductBatchDAO {
	
	/**
	 * Creates a product batch and save it to the database.
	 * @param produktBatch
	 * @throws DALException
	 */
	public void createProductBatch(ProduktBatchDTO produktBatch) throws DALException {
		
	}
	
	/**
	 * Updates the information of the product batch with the given ID.
	 * @param produktBatch
	 * @throws DALException
	 */
	public void updateProductBatch(ProduktBatchDTO produktBatch) throws DALException {
		
	}
	
	/**
	 * Deletes the product batch with the given ID
	 * @param produktBatch
	 * @throws DALException
	 */
	public void deleteProductBatch(ProduktBatchDTO produktBatch) throws DALException{
		
	}
}
