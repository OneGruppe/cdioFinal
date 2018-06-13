package data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.ICommodityBatchDAO;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public class CommodityBatchDAO implements ICommodityBatchDAO {

	private Connector con;

	/**
	 * Constructor that uses Constant-class to connect
	 * @throws DALException
	 */
	public CommodityBatchDAO() throws DALException
	{
		try 
		{
			con = new Connector();
		} 
		catch (DALException e) 
		{
			System.out.println("CommodityBatchDAO error: " + e.getMessage());
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
	public CommodityBatchDAO(String server, int port, String database, String username, String password) throws DALException
	{
		try 
		{
			con = new Connector(server, port, database, username, password);
		} 		
		catch (DALException e) 
		{
			System.out.println("CommodityBatchDAO error: " + e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#createCommodityBatch(data.dto.CommodityBatchDTO)
	 */
	@Override
	public void createCommodityBatch(CommodityBatchDTO commodityBatch) throws DALException
	{
		try 
		{
			con.doUpdate("INSERT INTO commodityBatch VALUES ("
					+ commodityBatch.getId() + ", "
					+ commodityBatch.getCommodityID() + ", "
					+ commodityBatch.getAmount() + ")" );
		} 
		catch (DALException e) 
		{
			System.out.println("CommodityBatchDAO error: " + e.getMessage());
			throw new DALException("Fejl i oprettelse af råvare");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#showCommodityBatch(int)
	 */
	@Override
	public CommodityBatchDTO getCommodityBatchSingle(int id) throws DALException
	{
		try 
		{
			ResultSet rs = con.doQuery("SELECT * FROM commodityBatch WHERE id = " + id);

			if(!rs.first()) 
			{
				throw new DALException("Råvarebatch med id '" + id + "' findes ikke");
			}
			else 
			{
				return new CommodityBatchDTO(rs.getInt("id"), rs.getInt("commodityID"), rs.getDouble("amount"));
			}
		}
		catch (SQLException | DALException e) 
		{
			System.out.println("CommodityBatchDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentningen af råvarebatch med id = '" + id + "'");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#getCommodityBatch(int)
	 */
	@Override
	public List<CommodityBatchDTO> getCommodityBatch(int commodityID) throws DALException
	{
		List<CommodityBatchDTO> commodityBatchList = new ArrayList<CommodityBatchDTO>();

		try
		{
			ResultSet rs = con.doQuery("SELECT * FROM commodityBatch WHERE commodityID= " + commodityID);

			while(rs.next()) 
			{
				commodityBatchList.add(new CommodityBatchDTO(rs.getInt("id"), rs.getInt("commodityID"), rs.getDouble("amount")));
			}
			if(commodityBatchList.isEmpty()) 
			{
				throw new DALException("Råvarebatch-listen listen er tom...\nTilføj nogle værdier og prøv igen");
			}
			return commodityBatchList;	
		} 
		catch(SQLException | DALException e) 
		{
			System.out.println("CommodityBatchDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af råvarebatch-listen");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#showAllCommodityBatches()
	 */
	@Override
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException
	{
		List<CommodityBatchDTO> commodityBatchList = new ArrayList<CommodityBatchDTO>();

		try 
		{
			ResultSet rs = con.doQuery("SELECT * FROM commodityBatch");

			while(rs.next()) 
			{
				CommodityBatchDTO combatdto = new CommodityBatchDTO(rs.getInt("id"), rs.getInt("commodityID"), rs.getDouble("amount"));
				commodityBatchList.add(combatdto);
			}
			if(commodityBatchList.isEmpty()) 
			{
				throw new DALException("Råvarebatch-listen listen er tom...\nTilføj nogle værdier og prøv igen");
			}
			return commodityBatchList;
		}
		catch (SQLException | DALException e)
		{
			System.out.println("CommodityBatchDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af råvarebatch-listen");
		}
	}


}
