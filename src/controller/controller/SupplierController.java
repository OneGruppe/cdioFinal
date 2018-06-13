package controller.controller;

import java.util.List;

import controller.controller_interface.ISupplierController;
import data.dao.SupplierDAO;
import data.dao_interface.ISupplierDAO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class SupplierController implements ISupplierController {

	private ISupplierDAO supdao;

	public SupplierController() throws DALException
	{
		supdao = new SupplierDAO();
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ISupplierController#createSupplier(int, java.lang.String)
	 */
	@Override
	public void createSupplier(int id, String name) throws DALException 
	{	
		SupplierDTO supplier = new SupplierDTO(id, name);

		supdao.createSupplier(supplier);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ISupplierController#updateSupplier(int, java.lang.String)
	 */
	@Override
	public void updateSupplier(int id, String name) throws DALException 
	{
		SupplierDTO supplier = new SupplierDTO(id, name);

		supdao.updateSupplier(supplier);

	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ISupplierController#getSupplier(int)
	 */
	@Override
	public SupplierDTO getSupplier(int id) throws DALException 
	{
		SupplierDTO supplier;
		supplier = supdao.getSupplier(id);
		return supplier;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.ISupplierController#getAllSuppliers()
	 */
	@Override
	public List<SupplierDTO> getAllSuppliers() throws DALException 
	{
		List<SupplierDTO> suppliers;
		suppliers = supdao.getAllSuppliers();
		return suppliers;
	}


}
