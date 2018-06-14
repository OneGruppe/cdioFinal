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
	 * @return 
	 */
	public String createProductBatchComponent(int productBatchID, int commodityBatchID, int userID, double tara, double netto);

	/**
	 * <blockquote><h1> <i>getSingleProductBatchComponent</i></h1> <blockquote>({@code int} id)</blockquote></blockquote>
	 * Returns a single productbatch component
	 * @param id
	 * @return a single ProductBatchComponentDTO object as JSON object
	 */
	public String getSingleProductBatchComponent(int id);

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
