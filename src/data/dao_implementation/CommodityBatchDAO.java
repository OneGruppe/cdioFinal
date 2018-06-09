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
				+ commodityBatch.getCommodityBatchID() + ", "
				+ commodityBatch.getCommodityID() + ", "
				+ commodityBatch.getSupplierID() + ", "
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
				+ "supplierID=" + commodityBatch.getSupplierID() + ", "
				+ "amount=" + commodityBatch.getAmount() + " "
				+ "WHERE commodityBatchID=" + commodityBatch.getCommodityBatchID());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#deleteCommodityBatch(int)
	 */
	@Override
	public void deleteCommodityBatch(int combatchID) throws DALException 
	{
		con.doUpdate("DELETE FROM commodityBatch WHERE commodityBatchID=" + combatchID);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ICommodityBatchDAO#showCommodityBatch(int)
	 */
	@Override
	public CommodityBatchDTO getCommodityBatch(int combatchID) throws DALException 
	{
		ResultSet rs = con.doQuery("SELECT * FROM commodityBatch "
				+ "WHERE commodityBatchID=" + combatchID);

		try
		{
			if (!rs.first())
			{
				throw new DALException("CommodityBatch med ID " + combatchID + " findes ikke");
			}
			else
			{
				return new CommodityBatchDTO(combatchID, rs.getInt("commodityID"), rs.getInt("supplierID"), rs.getDouble("amount"));
			}
		} 
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
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
				CommodityBatchDTO combatdto = new CommodityBatchDTO(rs.getInt("commodityBatchID"), rs.getInt("commodityID"), rs.getInt("supplierID"), rs.getDouble("amount"));
				comBatchList.add(combatdto);

				if (combatdto.getCommodityBatchID() == 0) 
				{
					throw new DALException("R�varebatchlisten er tom");
				}
			}
			return comBatchList;
		}
		catch (SQLException e)
		{
			throw new DALException(e.getMessage());
		}
	}


}
