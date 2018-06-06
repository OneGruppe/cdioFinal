package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.ISupplierController;
import data.dao_implementation.SupplierDAO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class SupplierController implements ISupplierController {
	
	private SupplierDAO supdao;
	
	public SupplierController() throws DALException
	{
		supdao = new SupplierDAO();
	}
	

	@Override
	public void createSupplier(int id, String name) throws DALException 
	{	
		SupplierDTO supplier = new SupplierDTO(id, name);
		
		supdao.createSupplier(supplier);
	}

	@Override
	public void updateSupplier(int id, String name) throws DALException 
	{
		SupplierDTO supplier = new SupplierDTO(id, name);
		
		supdao.updateSupplier(supplier);
		
	}

	@Override
	public void deleteSupplier(int id) throws DALException 
	{
		supdao.deleteSupplier(id);		
	}

	@Override
	public SupplierDTO getSupplier(int id) throws DALException 
	{
		SupplierDTO supplier;
		supplier = supdao.getSupplier(id);
		return supplier;
	}

	@Override
	public List<SupplierDTO> getAllSuppliers() throws DALException 
	{
		List<SupplierDTO> suppliers;
		suppliers = supdao.getAllSuppliers();
		return suppliers;
	}

}
