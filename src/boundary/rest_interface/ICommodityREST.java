package boundary.rest_interface;

import java.util.List;

import data.dto.CommodityDTO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public interface ICommodityREST {
	
	/**
	 * <h1> <i>createCommodity</i> </h1> <br>
	 * Creates a commodity
	 * @param id
	 * @param name
	 * @param suppliers
	 * @throws DALException
	 */
	public void createCommodity(int id, String name, List<SupplierDTO> suppliers) throws DALException;
	
	/**
	 * <h1> <i>updateCommodity</i> </h1> <br>
	 * Updates a commodity
	 * @param id
	 * @param name
	 * @param suppliers
	 * @throws DALException
	 */
	public void updateCommodity(int id, String name, List<SupplierDTO> suppliers) throws DALException;
	
	/**
	 * <h1> <i>deleteCommodity</i> </h1> <br>
	 * Deletes a commodity
	 * @param id
	 * @throws DALException
	 */
	public void deleteCommodity(int id) throws DALException;
	
	/**
	 * <h1> <i>getCommodity</i> </h1> <br>
	 * Get a commodity
	 * @param id
	 * @return a single commodity from database
	 * @throws DALException
	 */
	public CommodityDTO getCommodity(int id) throws DALException;
	
	/**
	 * <h1> <i>getAllCommodities</i> </h1> <br>
	 * Get all commodities
	 * @return a list of CommodityDTO objects
	 * @throws DALException
	 */
	public List<CommodityDTO> getAllCommodities() throws DALException;

}
