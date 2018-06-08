package data.dao_implementation;

import data.connector.Connector;
import data.dao_interface.ISupplierDAO;
import data.dto.SupplierDTO;
import exceptions.DALException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO implements ISupplierDAO
{
	private Connector con;
	
	/**
	 * Constructor that uses Constant-class 
	 * @throws DALException
	 */
	public SupplierDAO()throws DALException
	{
		con = new Connector();
	}

	/**
	 * Constructor that uses the parameters from 
	 * @param server
	 * @param port
	 * @param database
	 * @param username
	 * @param password
	 * @throws DALException
	 */
	public SupplierDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		con = new Connector(server, port, database, username, password);
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#createSupplier(data.dto.SupplierDTO)
	 */
	@Override
	public void createSupplier(SupplierDTO supplier) throws DALException
	{
		con.doUpdate("INSERT INTO supplier VALUES (" + supplier.getSupplierID() + ", '" + supplier.getSupplierName() + "')");
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#updateSupplier(data.dto.SupplierDTO)
	 */
	@Override
	public void updateSupplier(SupplierDTO supplier) throws DALException 
	{
		con.doUpdate("UPDATE supplier SET supplierName = '" + supplier.getSupplierName() + "' WHERE supplierID = " + supplier.getSupplierID());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#deleteSupplier(int)
	 */
	@Override
	public void deleteSupplier(int supplierID) throws DALException 
	{
		con.doUpdate("DELETE supplier WHERE supplierID= " + supplierID);		
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#showSupplier(int)
	 */
	@Override
	public SupplierDTO getSupplier(int supplierID) throws DALException 
	{
		SupplierDTO supplier = null;

		ResultSet rs = con.doQuery("SELECT * FROM supplier WHERE supplierID= " + supplierID);

		try
		{
			if (!rs.first())
			{
				throw new DALException("Supplier med ID " + supplierID + " findes ikke");
			}
			else
			{
				supplier = new SupplierDTO(supplierID, rs.getString("supplierName"));
			}
			return supplier;
		} 
		catch (SQLException e)
		{
			throw new DALException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#showAllSuppliers()
	 */
	@Override
	public List<SupplierDTO> getAllSuppliers() throws DALException 
	{
		List<SupplierDTO> suppList = new ArrayList<SupplierDTO>();

		ResultSet rs = con.doQuery("SELECT * FROM supplier");

		try
		{
			while(rs.next())
			{
				SupplierDTO supdto = new SupplierDTO(rs.getInt("supplierID"), rs.getString("supplierName"));
				suppList.add(supdto);
				
				if (supdto.getSupplierID() == 0) {
					throw new DALException("Leverandorlisten er tom");
				}
			}
		} 
		catch (SQLException e)
		{
			throw new DALException(e.getMessage());
		}
		return suppList;
	}


}
