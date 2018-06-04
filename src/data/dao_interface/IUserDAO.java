package data.dao_interface;

import java.util.List;
import data.dto.UserDTO;
import exceptions.DALException;

public interface IUserDAO {
	/**
	 * Creates an user object and save it to the database.
	 * @param user
	 * @throws DALException
	 */
	public void createUser(UserDTO user) throws DALException;
	
	/**
	 * Updates the information of a given user.
	 * @param user
	 * @throws DALException
	 */
	public void updateUser(UserDTO user) throws DALException;
	
	/**
	 * Changes the users status to inactive.
	 * @param user
	 * @throws DALException
	 */
	public void deactivateUser(int userID) throws DALException;
	
	/**
	 * Sets the users status to active.
	 * @param user
	 * @throws DALException
	 */
	public void activateUser(int userID) throws DALException;
	
	/**
	 * Returns a single user
	 * @param userID the id of the user
	 * @return user with id userID in form of UserDTO
	 * @throws DALException
	 */
	public UserDTO showUser(int userID) throws DALException;
	
	/**
	 * Returns a list of all users
	 * @return List of all users in form of UserDTO
	 * @throws DALException
	 */
	public List<UserDTO> showAllUsers() throws DALException;
}
