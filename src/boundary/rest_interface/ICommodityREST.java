package boundary.rest_interface;

import exceptions.DALException;

public interface ICommodityREST {

	/**
	 * <h1> <i>createCommodity</i> </h1> <br>
	 * Creates a commodity
	 * @param id
	 * @param name
	 * @param supplier
	 * @throws DALException
	 */
	public void createCommodity(int id, String name, int supplier) throws DALException;

	/**
	 * <h1> <i>updateCommodity</i> </h1> <br>
	 * Updates a commodity
	 * @param id
	 * @param name
	 * @param supplier
	 * @throws DALException
	 */
	public void updateCommodity(int id, String name, int supplier) throws DALException;

	/**
	 * <h1> <i>deleteCommodity</i> </h1> <br>
	 * Deletes a commodity
	 * @param id
	 * @return 
	 * @throws DALException
	 */
	public String deleteCommodity(int id) throws DALException;

	/**
	 * <h1> <i>getCommodity</i> </h1> <br>
	 * Get a commodity
	 * @param id
	 * @return a single commodity from database
	 * @throws DALException
	 */
	public String getCommodity(int id) throws DALException;

	/**
	 * <h1> <i>getAllCommodities</i> </h1> <br>
	 * Get all commodities
	 * @return a list of CommodityDTO objects
	 * @throws DALException
	 */
	public String getAllCommodities() throws DALException;


}
