package boundary.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import boundary.rest_interface.ISupplierREST;
import controller.controller.SupplierController;
import controller.controller_interface.ISupplierController;
import data.dto.SupplierDTO;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("supplier")
public class SupplierREST implements ISupplierREST {

	private ISupplierController sc;

	public SupplierREST()
	{
		try 
		{
			sc = new SupplierController();

		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ISupplierREST#createSupplier(int, java.lang.String)
	 */
	@Override
	@POST
	@Path("createSupplier")
	public String createSupplier(@FormParam("id") int id, @FormParam("name") String name) 
	{
		try 
		{
			if(id < 0 || id == 0 || name.equals("")) 
			{
				return "Fejl i inputtet!";
			}
			else 
			{
				sc.createSupplier(id, name);
				return "Leverand�ren, " + name + ", med ID " + id + " er oprettet.";
			}
		}
		catch(DALException e) 
		{
			return e.getMessage();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ISupplierREST#updateSupplier(int, java.lang.String)
	 */
	@Override
	@POST
	@Path("updateSupplier")
	public String updateSupplier(@FormParam("id") int id, @FormParam("name") String name) 
	{ 
		try 
		{
			if(id < 0 || id == 0) 
			{
				return "Fejl, ID skal v�re st�rre end 0";
			}
			else if(name.equals("")) 
			{
				return "Fejl, ugyldigt navn";
			}
			else 
			{
				String oldName = sc.getSupplier(id).getName();
				sc.createSupplier(id, name);
				return "Leverand�ren " + oldName + " er opdateret til " + name + " - " + id;
			}
		}
		catch(DALException e) 
		{
			return e.getMessage();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ISupplierREST#getSupplier(int)
	 */
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getSupplier")
	public String getSupplier(@FormParam("id") int id) 
	{	
		JSONObject supplierJSON = new JSONObject();
		SupplierDTO supplier;

		try
		{
			if(id > 0) 
			{
				supplier = sc.getSupplier(id);
				supplierJSON.put("id", supplier.getId());
				supplierJSON.put("name", supplier.getName());

				return supplierJSON.toString();
			}
			else 
			{
				return "Fejl, der eksiterer ingen leverand�re med dette ID";
			}
		}
		catch(DALException e) 
		{
			return e.getMessage();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.ISupplierREST#getAllSupplier()
	 */
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllSuppliers")
	public String getAllSupplier() 
	{
		JSONArray suppliers = new JSONArray();

		try 
		{
			suppliers.put(sc.getAllSuppliers());
			return suppliers.toString();
		}
		catch(DALException e) 
		{
			return e.getMessage();
		}
	}


}
