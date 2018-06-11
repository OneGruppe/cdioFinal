package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.ICommodityController;
import data.dao_implementation.CommodityDAO;
import data.dao_interface.ICommodityDAO;
import data.dto.CommodityDTO;
import exceptions.DALException;

public class CommodityController implements ICommodityController {

	private ICommodityDAO comdao;

	public CommodityController() throws DALException 
	{
		comdao = new CommodityDAO();
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityController#createCommodity(int, java.lang.String, java.util.List)
	 */
	@Override
	public void createCommodity(int id, String name, int supplierID) throws DALException 
	{
		CommodityDTO commodity = new CommodityDTO(id, name, supplierID);
		comdao.createCommodity(commodity);

	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityController#updateCommodity(int, java.lang.String, java.util.List)
	 */
	@Override
	public void updateCommodity(int id, String name, int supplierID) throws DALException 
	{
		CommodityDTO commodity = new CommodityDTO(id, name, supplierID);
		comdao.updateCommodity(commodity);

	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityController#deleteCommodity(int)
	 */
	@Override
	public void deleteCommodity(int id) throws DALException 
	{
		comdao.deleteCommodity(id);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityController#getCommodity(int)
	 */
	@Override
	public CommodityDTO getCommodity(int id) throws DALException 
	{
		return comdao.getCommodity(id);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ICommodityController#getAllCommodities()
	 */
	@Override
	public List<CommodityDTO> getAllCommodities() throws DALException 
	{
		List<CommodityDTO> commodityList;
		commodityList = comdao.getAllCommodities();
		return commodityList;
	}


}
