package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.IUserController;
import data.dao_implementation.UserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class UserController implements IUserController{
	
	private UserDAO userdao;
	
	public UserController() throws DALException
	{
		userdao = new UserDAO();
	}

	@Override
	public void createUser(String name, String ini, int active) throws DALException 
	{
		UserDTO user = new UserDTO(0, name, ini, active);
		
		userdao.createUser(user);
	}

	@Override
	public void updateUser(int id, String name, String ini) throws DALException 
	{
		UserDTO user = new UserDTO(id, name, ini, 0);
		
		userdao.updateUser(user);
	}

	@Override
	public void setUserState(int id, int state) throws DALException 
	{
		userdao.setUserState(id, state);
	}

	@Override
	public UserDTO getUser(int id) throws DALException
	{
		UserDTO user;
		user = userdao.getUser(id);
		return user;
	}

	@Override
	public List<UserDTO> getAllUsers() throws DALException 
	{
		List<UserDTO> userList;
		userList = userdao.getAllUsers();
		return userList;
	}

}
