package controller.controller_interface;

import java.util.List;

import data.dto.UserDTO;
import exceptions.DALException;

public interface IUserController {
	
	/**
	 * Creates a user
	 * @param name
	 * @param ini initials of user
	 * @param active user state (active(1)/inactive(0))
	 * @throws DALException
	 */
	public void createUser(String name, String ini, int active) throws DALException;
	
	/**
	 * Updates a user
	 * @param id
	 * @param name
	 * @param ini
	 * @throws DALException
	 */
	public void updateUser(int id, String name, String ini) throws DALException;
	
	/**
	 * Set user state (active/inactive)
	 * @param id
	 * @param state
	 * @throws DALException
	 */
	public void setUserState(int id, int state) throws DALException;
	
	/**
	 * Get a single user
	 * @param id
	 * @return a single user from database
	 * @throws DALException
	 */
	public UserDTO getUser(int id) throws DALException;
	
	/**
	 * Get all users
	 * @return a list of UserDTO objects
	 * @throws DALException
	 */
	public List<UserDTO> getAllUsers() throws DALException;

}
