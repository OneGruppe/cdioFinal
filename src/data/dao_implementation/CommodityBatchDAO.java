package data.dao_implementation;

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
	public CommodityBatchDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		con = new Connector(server, port, database, username, password);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#createCommodityBatch(data.dto.CommodityBatchDTO)
	 */
	@Override
	public void createCommodityBatch(CommodityBatchDTO commodityBatch) throws DALException 
	{
		con.doUpdate("INSERT INTO commodityBatch VALUES ("
				+ commodityBatch.getId() + ", "
				+ commodityBatch.getCommodityID() + ", "
				+ commodityBatch.getAmount() + ")" );
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#updateCommodityBatch(data.dto.CommodityBatchDTO)
	 */
	@Override
	public void updateCommodityBatch(CommodityBatchDTO commodityBatch) throws DALException 
	{
		con.doUpdate("UPDATE commodityBatch SET "
				+ "commodityID=" + commodityBatch.getCommodityID() + ", "
				+ "amount=" + commodityBatch.getAmount() + " "
				+ "WHERE id=" + commodityBatch.getId());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#deleteCommodityBatch(int)
	 */
	@Override
	public void deleteCommodityBatch(int id) throws DALException 
	{
		con.doUpdate("DELETE FROM commodityBatch WHERE id=" + id);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#showCommodityBatch(int)
	 */
	
	@Override
	public CommodityBatchDTO getCommodityBatchSingle(int id) throws DALException 
	{
		ResultSet rs = con.doQuery("SELECT * FROM commodityBatch WHERE id = " + id);

		try 
		{
			if(!rs.first()) 
			{
				throw new DALException("" + id);
			}
			else 
			{
				return new CommodityBatchDTO(rs.getInt("id"), rs.getInt("commodityID"), rs.getDouble("amount"));
			}
		} 
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
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
		
		ResultSet rs = con.doQuery("SELECT * FROM commodityBatch WHERE commodityID= " + commodityID);
		
		try 
		{
			while(rs.next()) 
			{
				commodityBatchList.add(new CommodityBatchDTO(rs.getInt("id"), rs.getInt("commodityID"), rs.getDouble("amount")));
			}
			
		} 
		catch(SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
		
		return commodityBatchList;	
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#showAllCommodityBatches()
	 */
	@Override
	public List<CommodityBatchDTO> getAllCommodityBatches() throws DALException 
	{
		List<CommodityBatchDTO> comBatchList = new ArrayList<CommodityBatchDTO>();

		ResultSet rs = con.doQuery("SELECT * FROM commodityBatch");

		try 
		{
			while(rs.next()) 
			{
				CommodityBatchDTO combatdto = new CommodityBatchDTO(rs.getInt("id"), rs.getInt("commodityID"), rs.getDouble("amount"));
				comBatchList.add(combatdto);
			}
			if(comBatchList.isEmpty()) {
				throw new DALException("RåvareBatch listen er tom...\nTilføj nogle værdier og prøv igen");
			}
			return comBatchList;
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage());
		}
	}

}
