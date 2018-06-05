package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.ICommodityDAO;
import data.dto.CommodityDTO;
import data.dto.RecipeDTO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class CommodityDAO implements ICommodityDAO 
{
	private Connector con;

	public CommodityDAO () throws DALException
	{
		try 
		{
			con = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#createCommodity(data.dto.CommodityDTO)
	 */
	@Override
	public void createCommodity(CommodityDTO commodity) throws DALException 
	{
		String commodityQuery = "CALL createCommodity (" + commodity.getCommodityID() + ", " + commodity.getCommodityName() + ", " + commodity.getSupplier() + ")";

		con.doUpdate(commodityQuery);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#updateCommodity(data.dto.CommodityDTO)
	 */
	@Override
	public void updateCommodity(CommodityDTO commodity) throws DALException 
	{
		String commodityQuery = "CALL updateCommodity(" + commodity.getCommodityID() + ", " + commodity.getCommodityName() + ", " + commodity.getSupplier() + ")";

		con.doUpdate(commodityQuery);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#deleteCommodity(int)
	 */
	@Override
	public void deleteCommodity(int commodityID) throws DALException 
	{
		String commodityQuery = "DELETE FROM commoity WHERE commodity ID = " + commodityID + "";

		con.doUpdate(commodityQuery);
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

		String commodityQuery = "SELECT * FROM commodityView WHERE commodityID = " + commodityID + "";

		ResultSet rs = con.doQuery(commodityQuery);

		try
		{
			if (!rs.first())
			{
				throw new DALException();
			}

			while(rs.next())
			{
				commodityName = rs.getString("commodityName");
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
		try
		{
			List<CommodityDTO> comList = new ArrayList<CommodityDTO>();
			ResultSet rsCom = con.doQuery("SELECT * FROM commodity");
			ResultSet rsSup = con.doQuery("SELECT * FROM commoditySupplier");

			if(!rsCom.first()) 
			{
				throw new DALException("Der findes ikke nogle råvare i systemet.");
			}
			while(rsCom.next()) 
			{
				comList.add(new CommodityDTO(rsCom.getInt("commodityID"),
						rsCom.getString("commodityName"), null));
			}
			while (rsCom.next())
			{
				for (CommodityDTO comDTO : comList)
				{
					if (comDTO.getCommodityID() == rsCom.getInt("comodityID"))
					{
						if (comDTO.getSupplier() == null)
						{
							List<SupplierDTO> exSupList = new ArrayList<SupplierDTO>();
							exSupList.add(new SupplierDTO(rsSup.getInt("supplierID"), rsSup.getString("supplierName")));
							comDTO.setSupplier(exSupList);
						}else 
						{
							List<SupplierDTO> exSupList = comDTO.getSupplier();
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

