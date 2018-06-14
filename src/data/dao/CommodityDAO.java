package data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.ICommodityDAO;
import data.dto.CommodityDTO;
import exceptions.DALException;

public class CommodityDAO implements ICommodityDAO {

	private Connector con;

	/**
	 * Constructor that uses Constant-class to connect
	 * @throws DALException
	 */
	public CommodityDAO() throws DALException
	{
		try 
		{
			con = new Connector();
		} 
		catch (DALException e) 
		{
			System.out.println("CommodityDAO error: " + e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
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
		try 
		{
			con = new Connector(server, port, database, username, password);
		} 
		catch (DALException e) 
		{
			System.out.println("CommodityDAO error: " + e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#createCommodity(data.dto.CommodityDTO)
	 */
	@Override
	public void createCommodity(CommodityDTO commodity) throws DALException
	{
		try 
		{
			con.doUpdate("INSERT INTO commodity VALUES (" 
					+ commodity.getId() + ", "
					+ "'" + commodity.getName() + "', " 
					+ commodity.getSupplierID() + ")");
		} 
		catch (DALException e) 
		{
			System.out.println("CommodityDAO error: " + e.getMessage());
			throw new DALException("Fejl i oprettelse af råvare");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#updateCommodity(data.dto.CommodityDTO)
	 */
	@Override
	public void updateCommodity(CommodityDTO commodity) throws DALException
	{
		try
		{
			con.doUpdate("UPDATE commodity SET "
					+ "name='" + commodity.getName() + "', "
					+ "supplierID=" +commodity.getSupplierID() + " "
					+ "WHERE id=" + commodity.getId());
		} 
		catch (DALException e) 
		{
			System.out.println("CommodityDAO error: " + e.getMessage());
			throw new DALException("Fejl i opdatering af råvare");
		}

	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#showCommodity(int)
	 */
	@Override
	public CommodityDTO getCommodity(int id) throws DALException
	{

		try 
		{
			ResultSet rs = con.doQuery("SELECT * FROM commodity WHERE id = " + id);

			if(!rs.first()) 
			{
				throw new DALException("Råvare med id '" + id + "' findes ikke");
			}
			else 
			{
				return new CommodityDTO(rs.getInt("id"), rs.getString("name"), rs.getInt("supplierID"));
			}
		} 
		catch (SQLException | DALException e)
		{
			System.out.println("CommodityDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af råvare");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityDAO#showAllCommodities()
	 */
	@Override
	public List<CommodityDTO> getAllCommodities() throws DALException
	{
		List<CommodityDTO> commodities = new ArrayList<CommodityDTO>();

		try
		{
			ResultSet rs = con.doQuery("SELECT * FROM commodity");

			while(rs.next()) 
			{
				CommodityDTO commoditydto = new CommodityDTO(rs.getInt("id"), rs.getString("name"), rs.getInt("supplierID"));
				commodities.add(commoditydto);
			}
			if(commodities.isEmpty()) 
			{
				throw new DALException("Råvare listen er tom...\nTilføj nogle værdier og prøv igen");
			}
			return commodities;
		}
		catch (SQLException | DALException e)
		{
			System.out.println("CommodityDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af råvare-listen");
		}
	}


}
