package boundary.rest_implementation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import boundary.rest_interface.ISupplierREST;
import controller.controller_implementation.SupplierController;
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

	@Override
	@PUT
	@Path("createSupplier")
	public String createSupplier(@FormParam("id") int id, @FormParam("name") String name) 
	{
		String message;

		try 
		{
			if(id < 0 || id == 0 || name.equals("")) 
			{
				message = "Fejl i inputtet!";
			}
			else 
			{
				sc.createSupplier(id, name);
				message = "Leverandøren, " + name + ", med ID " + id + " er oprettet.";
			}
		}
		catch(DALException e) 
		{
			message = e.getMessage();
		}
		System.out.println(message);
		return message;
	}

	@Override
	@POST
	@Path("updateSupplier")
	public String updateSupplier(@FormParam("id") int id, @FormParam("name") String name) 
	{ 
		String message = null;

		try 
		{
			if(id < 0 || id == 0 || name.equals("") ) 
			{
				if(id < 0 || id == 0) 
				{
					message = "Fejl, ID skal være større end 0";
				}
				else if(name.equals("")) 
				{
					message = "Fejl, ugyldigt navn";
				}
			}
			else 
			{
				String oldName = sc.getSupplier(id).getName();
				sc.createSupplier(id, name);
				message = "Leverandøren " + oldName + " er opdateret til " + name + " - " + id;
			}
		}
		catch(DALException e) 
		{
			message = e.getMessage();
		}
		System.out.println(message);
		return message;
	}

	@Override
	@DELETE
	@Path("deleteSupplier")
	public String deleteSupplier(@FormParam("id") int id) 
	{
		String message;

		try 
		{
			if(id < 1) 
			{
				message = "Fejl, ugyldigt input!";
			}
			else 
			{
				String oldName = sc.getSupplier(id).getName();
				sc.deleteSupplier(id);
				message = "Levenrandøren " + oldName + " er blevet fjernet";
			}
		}
		catch(DALException e) 
		{
			message = e.getMessage();
		}
		return message;
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getSupplier")
	public String getSupplier(@FormParam("id") int id) 
	{	
		String message;

		JSONObject supplierJSON = new JSONObject();
		SupplierDTO supplier;

		try 
		{
			if(id > 0) 
			{
				supplier = sc.getSupplier(id);
				supplierJSON.put("id", supplier.getId());
				supplierJSON.put("name", supplier.getName());

				message = "Leverandøren " + supplier.getName() + " blev fundet";
			}
			else 
			{
				message = "Fejl, der eksiterer ingen leverandøre med dette ID";
			}
		}
		catch(DALException e) 
		{
			message = e.getMessage();
		}
		System.out.println(message);
		return supplierJSON.toString();
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllSuppliers")
	public String getAllSupplier() 
	{
		String message;

		JSONArray suppliers = new JSONArray();

		try 
		{
			suppliers.put(sc.getAllSuppliers());
			message = "Leverandørene blev fundet"; 
		}
		catch(DALException e) 
		{
			message = e.getMessage();
		}
		System.out.println(message);
		return suppliers.toString();
	}


}
