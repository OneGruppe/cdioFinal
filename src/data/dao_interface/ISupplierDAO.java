package data.dao_interface;

import java.util.List;

import data.dto.SupplierDTO;
import exceptions.DALException;

public interface ISupplierDAO {

	/**
	 * Create a supplier and save it to database.
	 * @param supplier
	 * @throws DALException
	 */
	public void createSupplier(SupplierDTO supplier) throws DALException;

	/** 
	 * Updates the information of the given supplier 
	 * @param supplier 
	 * @throws DALException 
	 */ 
	public void updateSupplier(SupplierDTO supplier) throws DALException; 

	/**
	 * Returns a single supplier
	 * @param supplierID
	 * @return
	 * @throws DALException
	 */
	public SupplierDTO getSupplier(int supplierID) throws DALException;

	/**
	 * Returns a list of all suppliers
	 * @return
	 * @throws DALException
	 */
	public List<SupplierDTO> getAllSuppliers() throws DALException;


}
