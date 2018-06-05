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
	Connector con;
	
	public SupplierDAO()throws DALException
	{
			con = new Connector();
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#createSupplier(data.dto.SupplierDTO)
	 */
	@Override
	public void createSupplier(SupplierDTO supplier) throws DALException
	{
		con.doUpdate("INSERT INTO supplier VALUES (" + supplier.getId() + ", '" + supplier.getName() + "'");
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#updateSupplier(data.dto.SupplierDTO)
	 */
	@Override
	public void updateSupplier(SupplierDTO supplier) throws DALException {
		con.doUpdate("UPDATE supplier SET (supplierName = '" + supplier.getName() + "') WHERE supplierID = '" + supplier.getId() + "'");
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#deleteSupplier(int)
	 */
	@Override
	public void deleteSupplier(int supplierID) throws DALException {
		con.doUpdate("DELETE supplier WHERE 'supplierID' = '" + supplierID + "'");		
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#showSupplier(int)
	 */
	@Override
	public SupplierDTO getSupplier(int supplierID) throws DALException {
		String supplierName = null;
		
		ResultSet rs = con.doQuery("SELECT * FROM supplier WHERE 'supplierID' = '" + supplierID + "'");
		try
		{
			if(!rs.first())
				throw new DALException();
			while(rs.next())
			{
				supplierName = rs.getString("supplierName");
			}
		} catch (SQLException e)
		{
			throw new DALException(e.getMessage());
		}
		return new SupplierDTO(supplierID, supplierName);

	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.ISupplierDAO#showAllSuppliers()
	 */
	@Override
	public List<SupplierDTO> getAllSuppliers() throws DALException {
		int suppID = 0;
		String supplierName = null;
		
		List<SupplierDTO> suppList = null;
		ResultSet rs = con.doQuery("SELECT * FROM supplier");
		
		try
		{
			if(!rs.first())
			{
				throw new DALException();
			}
			while(rs.next())
			{
				suppID = rs.getInt("supplierID");
				supplierName = rs.getString("supplierName");
				
				suppList.add(new SupplierDTO(suppID, supplierName));
			}
		} catch (SQLException e)
		{
			throw new DALException(e.getMessage());
		}
		return suppList;
	}
}
