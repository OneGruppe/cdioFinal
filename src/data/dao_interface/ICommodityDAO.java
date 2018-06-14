package data.dao_interface;

import java.util.List;
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
	 * Returns a single commodity
	 * @param commodityID the id of the Commodity
	 * @return user with id commodityID in form of CommodityDTO
	 * @throws DALException
	 */
	public CommodityDTO getCommodity(int commodityID) throws DALException;

	/**
	 * Returns a list of all commodities
	 * @return List of all commodities in form of CommodityDTO
	 * @throws DALException
	 */
	public List<CommodityDTO> getAllCommodities() throws DALException;


}
