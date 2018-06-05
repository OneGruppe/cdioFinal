package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.ICommodityController;
import data.dao_implementation.CommodityDAO;
import data.dto.CommodityDTO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class CommodityController implements ICommodityController{
	
	private CommodityDAO comdao;
	
	public CommodityController() throws DALException 
	{
		comdao = new CommodityDAO();
		
	}

	@Override
	public void createCommodity(int id, String name, List<SupplierDTO> suppliers) throws DALException 
	{
		CommodityDTO commodity = new CommodityDTO(id, name, suppliers);
		
		comdao.createCommodity(commodity);
		
	}

	@Override
	public void updateCommodity(int id, String name, List<SupplierDTO> suppliers) throws DALException 
	{
		CommodityDTO commodity = new CommodityDTO(id, name, suppliers);
		
		comdao.updateCommodity(commodity);
		
	}

	@Override
	public void deleteCommodity(int id) throws DALException 
	{
		comdao.deleteCommodity(id);
		
	}

	@Override
	public CommodityDTO getCommodity(int id) throws DALException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommodityDTO> getAllCommodities() throws DALException 
	{
		// TODO Auto-generated method stub
		return null;
	}

}
