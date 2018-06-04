package data.dao_interface;

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
}
