package boundary.rest_interface;

public interface IProductBatchComponentREST {
	
	/**
	 * <blockquote> <h1> <i>updateProductBatchComponent</i></h1> <blockquote>({@code int} id,<br> {@code int} productBatchID,<br> {@code int} commodityBatchID,<br>  {@code int} userID,<br>  {@code double} tara,<br>  {@code double} netto)</blockquote></blockquote>
	 * Creates a produktbatch component
	 * @param productBatchComponentID
	 * @param productBatchID
	 * @param commodityBatchID
	 * @param userID
	 * @param tara
	 * @param netto
	 */
	
	public void createProductBatchComponent(int id, int productBatchID, int commodityBatchID, int userID, double tara, double netto);
	
	/**
	 * <blockquote><h1> <i>updateProductBatchComponent</i></h1> <blockquote>({@code int} id,<br> {@code int} productBatchID,<br> {@code int} commodityBatchID,<br> {@code int} userID,<br> {@code double} tara,<br> {@code double} netto) </blockquote></blockquote>
	 * Updates a productbatch component
	 * @param id
	 * @param productBatchID
	 * @param commodityBatchID
	 * @param userID
	 * @param tara
	 * @param netto
	 */
	
	public void updateProductBatchComponent(int id, int productBatchID, int commodityBatchID, int userID, double tara, double netto);

	/**
	 * <blockquote><h1> <i>getProductBatchComponent</i></h1> <blockquote>({@code int} productBatchID)</blockquote></blockquote>
	 * Returns a list of productbatch components matching the productbatch	
	 * @param productBatchID
	 * @return a list of ProductBatchComponentDTO objects in JSON array
	 */
	
	public String getProductBatchComponent(int productBatchID);
	
	/**
	 * <blockquote><h1> <i>getAllProductBatchComponents</i>()</h1></blockquote>
	 * Returns a list of all productbatch components 
	 * @return a list of ProductBatchComponentDTO objects in JSON array
	 */
	
	public String getAllProductBatchComponents();
}
