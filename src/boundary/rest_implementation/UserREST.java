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
import data.dto.UserDTO;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("user")
public class UserREST implements IUserREST {
	
	private UserController uc;
	
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
	public String createUser(@FormParam("name") String name, @FormParam("ini") String ini, @FormParam("active")int active) throws DALException 
	{
		String returnMessage;
		uc.createUser(name, ini, active);
		System.out.println(name + ini + active);
		returnMessage = "User succesfully created";
		System.out.println(returnMessage);
		return returnMessage;
	}

	@Override
	@POST
	@Path("updateUser")
	public void updateUser(@FormParam("id") int id, @FormParam("name") String name, @FormParam("ini") String ini) throws DALException 
	{
		uc.updateUser(id, name, ini);
	}

	@Override
	@POST
	@Path("setUserState")
	public void setUserState(@FormParam("id") int id, @FormParam("state") int state) throws DALException 
	{
		uc.setUserState(id, state);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getUser")
	public String getUser(@FormParam("id") int id) throws DALException
	{
		JSONObject userJSON = new JSONObject();
		UserDTO user;
		user = uc.getUser(id);
		userJSON.put("ID", user.getId());
		userJSON.put("name", user.getName());
		userJSON.put("ini", user.getIni());
		userJSON.put("active", user.getActive());
		return userJSON.toString();
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllUsers")
	public String getAllUsers() throws DALException 
	{
		JSONArray users = new JSONArray();
		users.put(uc.getAllUsers());
		System.out.println(users.toString());
		return users.toString();
	}

}
