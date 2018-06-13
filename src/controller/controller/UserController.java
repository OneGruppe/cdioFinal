package controller.controller;

import java.util.List;

import controller.controller_interface.IUserController;
import data.dao.UserDAO;
import data.dao_interface.IUserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class UserController implements IUserController {

	private IUserDAO userdao;

	public UserController() throws DALException
	{
		userdao = new UserDAO();
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IUserController#createUser(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void createUser(String name, String ini, int active) throws DALException 
	{
		try 
		{
			UserDTO user = new UserDTO(0, name, ini, active);
			userdao.createUser(user);
		}
		catch(Exception e) 
		{
			throw new DALException();
		}

	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IUserController#updateUser(int, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateUser(int id, String name, String ini) throws DALException 
	{
		UserDTO user = new UserDTO(id, name, ini, 0);
		userdao.updateUser(user);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IUserController#setUserState(int, int)
	 */
	@Override
	public void setUserState(int id, int state) throws DALException 
	{
		userdao.setUserState(id, state);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IUserController#getUser(int)
	 */
	@Override
	public UserDTO getUser(int id) throws DALException
	{
		UserDTO user;
		user = userdao.getUser(id);
		return user;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IUserController#getAllUsers()
	 */
	@Override
	public List<UserDTO> getAllUsers() throws DALException 
	{
		List<UserDTO> userList;
		userList = userdao.getAllUsers();
		return userList;
	}


}
