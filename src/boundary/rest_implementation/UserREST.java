package boundary.rest_implementation;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import boundary.rest_interface.IUserREST;
import controller.controller_implementation.UserController;
import data.dto.UserDTO;
import exceptions.DALException;

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
	@PUT
	@Path("createUser")
	public String createUser(@FormParam("name") String name, @FormParam("ini") String ini, @FormParam("active")int active) throws DALException 
	{
		String returnMessage = "Fail";
		uc.createUser(name, ini, active);
		returnMessage = "User succesfully created";
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
	public UserDTO getUser(@FormParam("id") int id) throws DALException
	{
		UserDTO user;
		user = uc.getUser(id);
		return user;
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllUsers")
	public List<UserDTO> getAllUsers() throws DALException 
	{
		List<UserDTO> users;
		users = uc.getAllUsers();
		return users;
	}

}
