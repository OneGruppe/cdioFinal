package data.dao_implementation;

import data.dao_interface.ICommodityDAO;
import data.dto.CommodityDTO;
import exceptions.DALException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.*;

public class CommodityDAO implements ICommodityDAO {
	private Connector con;

	public CommodityDAO () throws DALException
	{
		try {
			con = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			throw new DALException();
		}
	}


	@Override
	public void createCommodity(CommodityDTO commodity) throws DALException 
	{
		String commodityQuery = "CALL createCommodity (" + commodity.getCommodityID() + ", " + commodity.getCommodityName() + ", " + commodity.getSupplier() + ")";

		con.doUpdate(commodityQuery);
	}

	@Override
	public void updateCommodity(CommodityDTO commodity) throws DALException 
	{
		String commodityQuery = "CALL updateCommodity(" + commodity.getCommodityID() + ", " + commodity.getCommodityName() + ", " + commodity.getSupplier() + ")";

		con.doUpdate(commodityQuery);
	}

	@Override
	public void deleteCommodity(int commodityID) throws DALException 
	{
		String commodityQuery = "DELETE FROM commoity WHERE commodity ID = " + commodityID + "";

		con.doUpdate(commodityQuery);
	}

	@Override
	public CommodityDTO showCommodity(int commodityID) throws DALException
	{
		String commodityQuery = "SELECT * FROM commodityView WHERE commodityID = " + commodityID + "";

		int id = 0;
		String commodityName = null;
		String supplierName = null;

		ResultSet rs = con.doQuery(commodityQuery);
		try
		{
			while(rs.next())
			{
				id = rs.getInt("commodityID");
				commodityName = rs.getString("commodityName");
				supplierName = rs.getString("supplierName");
			}
			CommodityDTO commodity = new CommodityDTO(id, commodityName, supplierName);
			return commodity;
		} catch (SQLException e) {
			throw new DALException("SQLException in showCommodity(): " + e.getMessage());
		}
	}

	@Override
	public List<CommodityDTO> showAllCommodities() throws DALException
	{
		List<CommodityDTO> commodityList = new ArrayList<CommodityDTO>();

		String commodityQuery = "SELECT * FROM commodityView";

		int id = 0;
		String commodityName = null;
		String supplierName = null;

		ResultSet rs = con.doQuery(commodityQuery);

		try
		{
			while(rs.next())
			{
				id = rs.getInt("commodityID");
				commodityName = rs.getString("commodityName");
				supplierName = rs.getString("supplierName");

				CommodityDTO commodity = new CommodityDTO(id, commodityName, supplierName);
				commodityList.add(commodity);

			}
			return commodityList;
		} catch (SQLException e) {
			throw new DALException("SQLException in showAllCommodities(): " + e.getMessage());
		}

	}
}
