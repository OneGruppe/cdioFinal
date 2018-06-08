package boundary.rest_implementation;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import boundary.rest_interface.IUserREST;
import controller.controller_implementation.UserController;
import controller.controller_interface.IUserController;
import data.dto.UserDTO;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("user")
public class UserREST implements IUserREST {

	private IUserController uc;

	public UserREST() 
	{
		try {
			uc = new UserController();
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	@POST
	@Path("createUser")
	public String createUser(@FormParam("name") String name, @FormParam("ini") String ini, @FormParam("active")int active) 
	{
		String message;

		try 
		{
			if(name.equals("") || ini.equals("") || active < 0 && active > 1)
			{
				message = "Fejl i inputtet!";
			}
			else
			{
				uc.createUser(name, ini, active);
				message = "Brugeren " + name + " er oprettet.";
			}
		} 
		catch (DALException e) 
		{
			message = e.getMessage();		
		}
		System.out.println(message);
		return message;
	}

	@Override
	@POST
	@Path("updateUser")
	public String updateUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("ini") String ini) 
	{
		String message;

		try 
		{
			if(name.equals("") || ini.equals(""))
			{
				message = "Fejl i inputtet!";
			}
			else
			{
				uc.updateUser(id, name, ini);
				message = "Brugeren " + name + " er opdateret!";
			}
		} 
		catch (DALException e) 
		{
			message = e.getMessage();
		}
		System.out.println(message);
		return message;
	}

	@Override
	@POST
	@Path("setUserState")
	public String setUserState(@FormParam("id") int id, @FormParam("state") int state) 
	{
		String message;

		try 
		{
			if(state == 0 || state == 1)
			{
				uc.setUserState(id, state);
				message = "Brugerens aktivitetsstatus er ændret til " + state;
			}
			else
			{
				message = "Brugerens aktivitetsstatus kan kun være 0 eller 1.";
			}
		} 
		catch (DALException e) 
		{
			message = e.getMessage();
		}

		System.out.println(message);
		return message;
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getUser")
	public String getUser(@FormParam("id") int id)
	{
		String message;

		JSONObject userJSON = new JSONObject();
		UserDTO user;

		try 
		{
			if(id != 0)
			{
				user = uc.getUser(id);
				userJSON.put("ID", user.getId());
				userJSON.put("name", user.getName());
				userJSON.put("ini", user.getIni());
				userJSON.put("active", user.getActive());

				message = "Brugeren " + user.getName() + " blev fundet";
			}
			else
			{
				message = "Ugyldigt ID blev indtastet\nPrøv igen";
			}
		} 
		catch (DALException e) 
		{
			message = e.getMessage();
		}

		System.out.println(message);

		return userJSON.toString();
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllUsers")
	public String getAllUsers() 
	{
		String message;

		JSONArray users = new JSONArray();

		try 
		{
			users.put(uc.getAllUsers());
			message = "Alle brugeren er fundet!";
		} 
		catch (DALException e) 
		{
			message = e.getMessage();
		}

		System.out.println(message);
		return users.toString();
	}

}
