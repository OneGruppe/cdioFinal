package boundary.rest_interface;

import data.dto.UserDTO;
import exceptions.DALException;

public interface IUserREST {

	/**
	 * <h1> <i>createUser</i> </h1> <br>
	 * Creates a user
	 * @param name
	 * @param ini initials of user
	 * @param active user state (active(1)/inactive(0))
	 * @throws DALException
	 */
	public String createUser(String name, String ini, int active) throws DALException;
	
	/**
	 * <h1> <i>updateUser</i> </h1> <br>
	 * Updates a user
	 * @param id
	 * @param name
	 * @param ini
	 * @throws DALException
	 */
	public void updateUser(int id, String name, String ini) throws DALException;
	
	/**
	 * <h1> <i>setUserState</i> </h1> <br>
	 * Set user state (active/inactive)
	 * @param id
	 * @param state
	 * @throws DALException
	 */
	public void setUserState(int id, int state) throws DALException;
	
	/**
	 * <h1> <i>getUser</i> </h1> <br>
	 * Get a single user
	 * @param id
	 * @return a single user from database
	 * @throws DALException
	 */
	public String getUser(int id) throws DALException;
	
	/**
	 * <h1> <i>getAllUser</i> </h1> <br>
	 * Get all users
	 * @return a list of UserDTO objects
	 * @throws DALException
	 */
	public String getAllUsers() throws DALException;
}
