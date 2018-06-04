package data.dao;

public interface IUserDAO {
	/**
	 * Creates an user object and save it to the database.
	 * @param user
	 * @throws DALException
	 */
	public void createUser(UserDTO user) throws DALException {
		
	}
	
	/**
	 * Updates the users information with the given ID.
	 * @param user
	 * @throws DALException
	 */
	public void updateUser(UserDTO user) throws DALException {
		
	}
	
	/**
	 * Changes the user with the given ID's status to inactive.
	 * @param user
	 * @throws DALException
	 */
	public void deactivateUser(UserDTO user) throws DALException {
		
	}
	
	/**
	 * Sets the user with the given ID's status to active.
	 * @param user
	 * @throws DALException
	 */
	public void activateUser(UserDTO user) throws DALException {
		
	}
}
