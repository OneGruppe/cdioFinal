package data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.ISupplierDAO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class SupplierDAO implements ISupplierDAO {

	private Connector con;

	/**
	 * Constructor that uses Constant-class to connect
	 * @throws DALException
	 */
	public SupplierDAO() throws DALException
	{
		try 
		{
			con = new Connector();
		} 
		catch (DALException e) 
		{
			System.out.println("SupplierDAO error: " + e.getMessage());
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
	public SupplierDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		try 
		{
			con = new Connector(server, port, database, username, password);
		} 
		catch (DALException e) 
		{
			System.out.println("SupplierDAO error: " + e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#createSupplier(data.dto.SupplierDTO)
	 */
	@Override
	public void createSupplier(SupplierDTO supplier) throws DALException
	{
		try 
		{
			con.doUpdate("INSERT INTO supplier VALUES ("
					+ supplier.getId() + ", "
					+ "'" + supplier.getName() + "')");

		} 
		catch (DALException e) 
		{
			System.out.println("SupplierDAO error: " + e.getMessage());
			throw new DALException("Fejl i oprettelse af leverandør");
		}
	}

	/* 
	 * (non-Javadoc) 
	 * @see data.dao_interface.ISupplierDAO#updateSupplier(data.dto.SupplierDTO) 
	 */ 
	@Override 
	public void updateSupplier(SupplierDTO supplier) throws DALException  
	{ 
		con.doUpdate("UPDATE supplier SET " 
				+ "name='" + supplier.getName() + "' " 
				+ "WHERE id=" + supplier.getId()); 
	} 

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#showSupplier(int)
	 */
	@Override
	public SupplierDTO getSupplier(int supplierID) throws DALException 
	{
		try
		{
			ResultSet rs = con.doQuery("SELECT * FROM supplier WHERE id= " + supplierID);

			if (!rs.first())
			{
				throw new DALException("Supplier med ID " + supplierID + " findes ikke");
			}
			else
			{
				return new SupplierDTO(supplierID, rs.getString("name"));
			}
		} 
		catch (SQLException | DALException e)
		{
			System.out.println("SupplierDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af leverandør");
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

		try
		{
			ResultSet rs = con.doQuery("SELECT * FROM supplier");

			while(rs.next())
			{
				SupplierDTO supdto = new SupplierDTO(rs.getInt("id"), rs.getString("name"));
				suppList.add(supdto);
			}
			if(suppList.isEmpty()) 
			{
				throw new DALException("LeverandÃ¸r listen er tom...\nTilfÃ¸j nogle vÃ¦rdier og prÃ¸v igen");
			}
			return suppList;
		} 
		catch (SQLException | DALException e)
		{
			System.out.println("SupplierDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af leverandør-listen");
		}
	}


}
