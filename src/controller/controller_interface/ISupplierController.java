package controller.controller_interface;

import java.util.List;

import data.dto.SupplierDTO;
import exceptions.DALException;

public interface ISupplierController {

	/**
	 * Creates a supplier
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
	 * Get a single supplier from the system
	 * @param id
	 * @return a single SupplierDTO object
	 * @throws DALException
	 */
	public SupplierDTO getSupplier(int id) throws DALException;

	/**
	 * Get all suppliers in the system
	 * @return a list of SupplierDTO objects
	 * @throws DALException
	 */
	public List<SupplierDTO> getAllSuppliers() throws DALException;


}
