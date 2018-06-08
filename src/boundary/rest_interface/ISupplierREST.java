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
	public void createSupplier(int id, String name) throws DALException;
	
	/**
	 * Updates a supplier
	 * @param id
	 * @param name
	 * @throws DALException
	 */
	public void updateSupplier(int id, String name) throws DALException;
	
	/**
	 * Deletes a supplier
	 * @param id
	 * @throws DALException
	 */
	public void deleteSupplier(int id) throws DALException;
	
	/**
	 * Gets a single supplier
	 * @return
	 * @throws DALException
	 */
	public SupplierDTO getSupplier(int id) throws DALException;
	
	/**
	 * Gets a list of all suppliers
	 * @return
	 * @throws DALException
	 */
	public List<SupplierDTO> getAllSupplier() throws DALException;
}
