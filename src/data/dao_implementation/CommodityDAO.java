package data.dao_implementation;

import data.dao_interface.ICommodityDAO;
import data.dto.CommodityDTO;
import exceptions.DALException;

import java.sql.ResultSet;
import java.sql.SQLException;

import data.connector.*;

public class CommodityDAO implements ICommodityDAO {
	Connector conn;
	
	public CommodityDAO ()
	{
		try {
			conn = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void createCommodity(CommodityDTO commodity) throws DALException 
	{
		String commodityQuery = "CALL createCommodity (" + commodity.getCommodityID() + ", " + commodity.getCommodityName() + ", " + commodity.getSupplier() + ")";
		
		conn.doUpdate(commodityQuery);
	}

	@Override
	public void updateCommodity(CommodityDTO commodity) throws DALException 
	{
		String commodityQuery = "CALL updateCommodity(" + commodity.getCommodityID() + ", " + commodity.getCommodityName() + ", " + commodity.getSupplier() + ")";
		
		conn.doUpdate(commodityQuery);
	}

	@Override
	public void deleteCommodity(int commodityID) throws DALException 
	{
		String commodityQuery = "DELETE FROM commoity WHERE commodity ID = " + commodityID + "";
		
		conn.doUpdate(commodityQuery);
	}

	@Override
	public CommodityDTO showCommodity(int commodityID) throws DALException
	{
		String commodityQuery = "SELECT * FROM commodityView WHERE commodityID = " + commodityID + "";
		
		ResultSet rsName = conn.doQuery(commodityQuery);
	}
	
	@Override
	public void showAllCommodities() throws DALException
	{
		
	}

}
