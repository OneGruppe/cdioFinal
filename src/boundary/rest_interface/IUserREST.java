package boundary.rest_interface;

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
	public String createUser(String name, String ini, int active);

	/**
	 * <h1> <i>updateUser</i> </h1> <br>
	 * Updates a user
	 * @param id
	 * @param name
	 * @param ini
	 * @throws DALException
	 */
	public String updateUser(int id, String name, String ini);

	/**
	 * <h1> <i>setUserState</i> </h1> <br>
	 * Set user state (active/inactive)
	 * @param id
	 * @param state
	 * @throws DALException
	 */
	public String setUserState(int id, int state);

	/**
	 * <h1> <i>getUser</i> </h1> <br>
	 * Get a single user
	 * @param id
	 * @return a single user from database
	 * @throws DALException
	 */
	public String getUser(int id);

	/**
	 * <h1> <i>getAllUser</i> </h1> <br>
	 * Get all users
	 * @return a list of UserDTO objects
	 * @throws DALException
	 */
	public String getAllUsers();


}
