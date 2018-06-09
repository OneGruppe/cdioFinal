package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.ICommodityDAO;
import data.dto.CommodityDTO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class CommodityDAO implements ICommodityDAO {

	private Connector con;

	/**
	 * Constructor that uses Constant-class to connect
	 * @throws DALException
	 */
	public CommodityDAO() throws DALException
	{
		con = new Connector();
	}

	/**
	 * Constructor that uses the parameters
	 * @param server
	 * @param port
	 * @param database
	 * @param username
	 * @param password
	 * @throws DALException
	 */
	public CommodityDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		con = new Connector(server, port, database, username, password);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#createCommodity(data.dto.CommodityDTO)
	 */
	@Override
	public void createCommodity(CommodityDTO commodity) throws DALException 
	{
		con.doUpdate("INSERT INTO commodity VALUES (" 
				+ commodity.getId() + ", "
				+ "'" + commodity.getName() + "')");

		for(SupplierDTO supplier : commodity.getSupplierList())
		{
			con.doUpdate("INSERT INTO commodity_supplier VALUES (" 
					+ commodity.getId() + ", " 
					+ supplier.getSupplierID()+ ")");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#updateCommodity(data.dto.CommodityDTO)
	 */
	@Override
	public void updateCommodity(CommodityDTO commodity) throws DALException 
	{
		con.doUpdate("DELETE FROM commodity_supplier "
				+ "WHERE commodityID=" + commodity.getId());

		con.doUpdate("UPDATE commodity SET "
				+ "name='" + commodity.getName() + "' "
				+ "WHERE commodityID=" + commodity.getId());

		for(SupplierDTO supplier : commodity.getSupplierList())
		{
			con.doUpdate("INSERT INTO commodity_supplier VALUES (" 
					+ commodity.getId() + ", " 
					+ supplier.getSupplierID() + ")");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#deleteCommodity(int)
	 */
	@Override
	public void deleteCommodity(int commodityID) throws DALException 
	{
		con.doUpdate("DELETE FROM commodity "
				+ "WHERE commodity ID = " + commodityID + "");
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#showCommodity(int)
	 */
	@Override
	public CommodityDTO getCommodity(int commodityID) throws DALException
	{
		List<SupplierDTO> supplierList = new ArrayList<SupplierDTO>();
		String commodityName = null;

		ResultSet rs = con.doQuery("SELECT * FROM CommodityView "
				+ "WHERE commodityID=" + commodityID);

		try
		{
			if (!rs.first())
			{
				throw new DALException("Commodity med ID " + commodityID + " findes ikke");
			}
			else 
			{
				commodityName = rs.getString("commodityName");
				supplierList.add(new SupplierDTO(rs.getInt("supplierID"), rs.getString("supplierName")));
			}
			while(rs.next())
			{
				supplierList.add(new SupplierDTO(rs.getInt("supplierID"), rs.getString("supplierName")));
			}
			return new CommodityDTO(commodityID, commodityName, supplierList);
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage());	
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#showAllCommodities()
	 */
	@Override
	public List<CommodityDTO> getAllCommodities() throws DALException
	{
		List<CommodityDTO> comList = new ArrayList<CommodityDTO>();
		ResultSet rsCom = con.doQuery("SELECT * FROM commodity");
		ResultSet rsSup = con.doQuery("SELECT * FROM commodity_supplier");

		try
		{
			while(rsCom.next()) 
			{
				CommodityDTO comdto = new CommodityDTO(rsCom.getInt("commodityID"), rsCom.getString("commodityName"), null);
				comList.add(comdto);

				if (comdto.getId() == 0) 
				{
					throw new DALException("Råvarelistenlisten er tom");
				}
			}
			while (rsSup.next())
			{
				for (CommodityDTO comDTO : comList)
				{
					if (comDTO.getId() == rsSup.getInt("comodityID"))
					{
						if (comDTO.getSupplierList() == null)
						{
							List<SupplierDTO> exSupList = new ArrayList<SupplierDTO>();
							exSupList.add(new SupplierDTO(rsSup.getInt("supplierID"), rsSup.getString("supplierName")));
							comDTO.setSupplierList(exSupList);
						}
						else
						{
							List<SupplierDTO> exSupList = comDTO.getSupplierList();
							exSupList.add(new SupplierDTO(rsSup.getInt("supplierID"), rsSup.getString("supplierName")));
						}
					}
				}
			}
			return comList;
		}
		catch(SQLException e)
		{
			throw new DALException(e.getMessage());	
		}
	}


}
