package boundary.rest_implementation;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import boundary.rest_interface.ISupplierREST;
import controller.controller_implementation.SupplierController;
import data.dto.SupplierDTO;
import exceptions.DALException;


public class SupplierREST implements ISupplierREST{
	
	private SupplierController sc;
	
	public SupplierREST()
	{
		try {
			
			sc = new SupplierController();
			
		} catch (DALException e) {
			
			System.out.println(e.getMessage());
		}
	}

	@Override
	@PUT
	@Path("createSupplier")
	public void createSupplier(int id, String name) throws DALException 
	{
		sc.createSupplier(id, name);	
	}

	@Override
	@POST
	@Path("updateSupplier")
	public void updateSupplier(int id, String name) throws DALException 
	{
		sc.updateSupplier(id, name);
	}

	@Override
	@DELETE
	@Path("deleteSupplier")
	public void deleteSupplier(int id) throws DALException 
	{
		sc.deleteSupplier(id);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getSupplier")
	public SupplierDTO getSupplier(int id) throws DALException 
	{	
		SupplierDTO sup;
		sup = sc.getSupplier(id);
		return sup;
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllSuppliers")
	public List<SupplierDTO> getAllSupplier() throws DALException 
	{
		List<SupplierDTO> sups;
		sups= sc.getAllSuppliers();
		return sups;
	}

}
