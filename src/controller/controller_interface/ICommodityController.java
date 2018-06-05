package controller.controller_interface;

import java.util.List;

import data.dto.CommodityDTO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public interface ICommodityController {
	
	/**
	 * Creates a commodity
	 * @param id
	 * @param name
	 * @param suppliers
	 * @throws DALException
	 */
	public void createCommodity(int id, String name, List<SupplierDTO> suppliers) throws DALException;
	
	/**
	 * Updates a commodity
	 * @param id
	 * @param name
	 * @param suppliers
	 * @throws DALException
	 */
	public void updateCommodity(int id, String name, List<SupplierDTO> suppliers) throws DALException;
	
	/**
	 * Deletes a commodity
	 * @param id
	 * @throws DALException
	 */
	public void deleteCommodity(int id) throws DALException;
	
	/**
	 * Get a commodity
	 * @param id
	 * @return a single commodity from database
	 * @throws DALException
	 */
	public CommodityDTO getCommodity(int id) throws DALException;
	
	/**
	 * Get all commodities
	 * @return a list of all commodities in database
	 * @throws DALException
	 */
	public List<CommodityDTO> getAllCommodities() throws DALException;

}
