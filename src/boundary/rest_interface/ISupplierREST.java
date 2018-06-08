package boundary.rest_interface;


import java.util.List;

import data.dto.SupplierDTO;
import exceptions.DALException;

public interface ISupplierREST {
	
	/**
	 * Creates a supplier.
	 * @param id
	 * @param name
	 * @throws DALException
	 */
	public String createSupplier(int id, String name) throws DALException;
	
	/**
	 * Updates a supplier
	 * @param id
	 * @param name
	 * @return 
	 * @throws DALException
	 */
	public String updateSupplier(int id, String name) throws DALException;
	
	/**
	 * Deletes a supplier
	 * @param id
	 * @return 
	 * @throws DALException
	 */
	public String deleteSupplier(int id) throws DALException;
	
	/**
	 * Gets a single supplier
	 * @return
	 * @throws DALException
	 */
	public String getSupplier(int id) throws DALException;
	
	/**
	 * Gets a list of all suppliers
	 * @return
	 * @throws DALException
	 */
	public String getAllSupplier() throws DALException;
}
