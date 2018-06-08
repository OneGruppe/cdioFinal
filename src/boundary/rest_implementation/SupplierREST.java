package boundary.rest_implementation;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import controller.controller_implementation.SupplierController;
import data.dto.SupplierDTO;
import exceptions.DALException;

/*@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("commodity")*/
public class SupplierREST {

	private SupplierController sc;
	
	public SupplierREST() 
	{
		try {
			
			sc = new SupplierController();
			
		} catch (DALException e) {
			
			System.out.println(e.getMessage());
		}
	}

	@PUT
	@Path("createSupplier")
	public void createSupplier(@FormParam("id") int id, @FormParam("name") String name) throws DALException 
	{
		
		sc.createSupplier(id, name);
		
	}

	@POST
	@Path("updateSupplier")
	public void updateSupplier(@FormParam("id") int id, @FormParam("name") String name) throws DALException 
	{
		sc.updateSupplier(id, name);
	}

	@DELETE
	@Path("deleteSupplier")
	public void deleteSupplier(int id) throws DALException 
	{
		sc.deleteSupplier(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getSupplier")
	public SupplierDTO getSupplier(@FormParam("id") int id) throws DALException 
	{
		SupplierDTO Supplier;
		Supplier = sc.getSupplier(id);
		return Supplier;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllSuppliers")
	public List<SupplierDTO> getAllSuppliers() throws DALException 
	{
		List<SupplierDTO> Suppliers;
		Suppliers = sc.getAllSuppliers();
		return Suppliers;
	}
	
}
