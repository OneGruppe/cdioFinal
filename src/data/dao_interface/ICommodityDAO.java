package data.dao_interface;

import data.dto.CommodityDTO;
import exceptions.DALException;

public interface ICommodityDAO {

	/**
	 * Creates a commodity and saves it to the database.
	 * @param commodity
	 * @throws DALException
	 */
	public void createCommodity(CommodityDTO commodity) throws DALException;
	
	/**
	 * Updates the information of the given commodity.
	 * @param commodity
	 * @throws DALException
	 */
	public void updateCommodity(CommodityDTO commodity) throws DALException;
	
	/**
	 * Deletes the commodity with the given ID.
	 * @param commodity
	 * @throws DALException
	 */
	public void deleteCommodity(int commodityID) throws DALException;
}
