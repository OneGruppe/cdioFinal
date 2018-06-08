package boundary.rest_implementation;

import java.util.List;

import boundary.rest_interface.ISupplierREST;
import controller.controller_implementation.SupplierController;
import data.dto.SupplierDTO;
import exceptions.DALException;


public class SupplierREST implements ISupplierREST{
	
	private SupplierController sc;
	
	public SupplierREST() throws DALException 
	{
		sc = new SupplierController();
	}

	@Override
	public void createSupplier(int id, String name) throws DALException 
	{
		sc.createSupplier(id, name);	
	}

	@Override
	public void updateSupplier(int id, String name) throws DALException 
	{
		sc.updateSupplier(id, name);
	}

	@Override
	public void deleteSupplier(int id) throws DALException 
	{
		sc.deleteSupplier(id);
	}

	@Override
	public SupplierDTO getSupplier(int id) throws DALException 
	{	
		SupplierDTO sup;
		sup = sc.getSupplier(id);
		return sup;
	}

	@Override
	public List<SupplierDTO> getAllSupplier() throws DALException 
	{
		List<SupplierDTO> sups;
		sups= sc.getAllSuppliers();
		return sups;
	}

}
