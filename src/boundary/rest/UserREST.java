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

import boundary.rest_interface.IUserREST;
import controller.controller.UserController;
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
		try 
		{
			uc = new UserController();
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IUserREST#createUser(java.lang.String, java.lang.String, int)
	 */
	@Override
	@POST
	@Path("createUser")
	public String createUser(@FormParam("name") String name, @FormParam("ini") String ini, @FormParam("active")int active) 
	{
		JSONObject returnMessage = new JSONObject();
		
		try 
		{
			if(name.equals("") || ini.equals("") || active < 0 && active > 1)
			{
				returnMessage.put("message", "Fejl i inputtet!");
				return returnMessage.toString();
			}
			else
			{
				uc.createUser(name, ini, active);
				returnMessage.put("message", "Brugeren " + name + " er oprettet.");
				return returnMessage.toString();
			}
		} 
		catch (DALException e) 
		{
			returnMessage.put("message", e.getMessage());
			return returnMessage.toString();		
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IUserREST#updateUser(int, java.lang.String, java.lang.String)
	 */
	@Override
	@POST
	@Path("updateUser")
	public String updateUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("ini") String ini) 
	{
		JSONObject returnMessage = new JSONObject();
		
		try 
		{
			if(name.equals("") || ini.equals(""))
			{
				returnMessage.put("message", "Fejl i inputtet!");
				return returnMessage.toString();
			}
			else
			{
				uc.updateUser(id, name, ini);
				returnMessage.put("message", "Brugeren er opdateret.");
				return returnMessage.toString();
			}
		} 
		catch (DALException e) 
		{
			returnMessage.put("message", e.getMessage());
			return returnMessage.toString();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IUserREST#setUserState(int, int)
	 */
	@Override
	@POST
	@Path("setUserState")
	public String setUserState(@FormParam("id") int id, @FormParam("state") int state) 
	{
		JSONObject returnMessage = new JSONObject();
		
		try 
		{
			if(state == 0 || state == 1)
			{
				uc.setUserState(id, state);
				returnMessage.put("message", "Brugerens aktivitetsstatus er ændret til " + state);
				return returnMessage.toString();
			}
			else
			{
				returnMessage.put("message", "Brugerens aktivitetsstatus kan kun være 0 eller 1.");
				return returnMessage.toString();
			}
		} 
		catch (DALException e) 
		{
			returnMessage.put("message", e.getMessage());
			return returnMessage.toString();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IUserREST#getUser(int)
	 */
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getUser")
	public String getUser(@FormParam("id") int id)
	{
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

				return userJSON.toString();
			}
			else
			{
				return "Ugyldigt ID blev indtastet\nPr�v igen";
			}
		} 
		catch (DALException e) 
		{
			return e.getMessage();
		}


	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IUserREST#getAllUsers()
	 */
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllUsers")
	public String getAllUsers() 
	{
		JSONArray users = new JSONArray();
		try 
		{
			users.put(uc.getAllUsers());
			return users.toString();
		} 
		catch (DALException e) 
		{
			return e.getMessage();
		}
	}


}
