package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IUserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class UserDAO implements IUserDAO {

	private Connector con;

	public UserDAO() throws DALException 
	{
		con = new Connector();
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#createUser(data.dto.UserDTO)
	 */
	@Override
	public void createUser(UserDTO user) throws DALException 
	{
		con.doUpdate("INSERT INTO users(userID, name, initial, active) VALUES(" + user.getId() + ", '" + user.getName() + "', '" + user.getIni() + "',"  + user.getActive() + ")");
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#updateUser(data.dto.UserDTO)
	 */
	@Override
	public void updateUser(UserDTO user) throws DALException 
	{
		con.doUpdate("UPDATE users SET name = '" + user.getName() + "', initial = '" + user.getIni() + "' WHERE userID = " + user.getId());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#setUserState(int, int)
	 */
	@Override
	public void setUserState(int userID, int state) throws DALException 
	{
		con.doUpdate("UPDATE users SET active = " + state + " WHERE userID = " + userID);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#showUser(int)
	 */
	@Override
	public UserDTO getUser(int userID) throws DALException 
	{
		ResultSet rs = con.doQuery("SELECT * FROM users WHERE userID = " + userID);

		try 
		{
			if(!rs.first()) 
			{
				throw new DALException("Brugeren med ID " + userID + " findes ikke");
			}
			else 
			{
				return new UserDTO(rs.getInt("userID"), rs.getString("name"), rs.getString("initial"), rs.getInt("active"));
			}
		} 
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#showAllUsers()
	 */
	@Override
	public List<UserDTO> getAllUsers() throws DALException 
	{
		List<UserDTO> users = new ArrayList<UserDTO>();

		ResultSet rs = con.doQuery("SELECT * FROM users");

		try
		{
			while(rs.next()) 
			{
				UserDTO userdto = new UserDTO(rs.getInt("userID"), rs.getString("name"), rs.getString("initial"), rs.getInt("active"));
				users.add(userdto);
				if (userdto.getId() == 0) {throw new DALException("User-listen er tom");}
				
			}
			return users;
		}
		catch(SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}


}
