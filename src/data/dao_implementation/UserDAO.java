package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IUserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class UserDAO implements IUserDAO 
{

	private Connector con;

	/**
	 * Constructor that uses Constant-class 
	 * @throws DALException
	 */
	public UserDAO() throws DALException 
	{
		con = new Connector();
	}

	/**
	 * Constructor that uses the parameters from 
	 * @param server
	 * @param port
	 * @param database
	 * @param username
	 * @param password
	 * @throws DALException
	 */
	public UserDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		con = new Connector(server, port, database, username, password);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#createUser(data.dto.UserDTO)
	 */
	@Override
	public void createUser(UserDTO user) throws DALException 
	{
		con.doUpdate("INSERT INTO users(userID, name, initials, active) VALUES(" + user.getId() + ", '" + user.getName() + "', '" + user.getIni() + "',"  + user.getActive() + ")");
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#updateUser(data.dto.UserDTO)
	 */
	@Override
	public void updateUser(UserDTO user) throws DALException 
	{
		con.doUpdate("UPDATE users SET name = '" + user.getName() + "', initials = '" + user.getIni() + "', active= " + user.getActive() + " WHERE userID = " + user.getId());
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
				throw new DALException("" + userID);
			}
			else 
			{
				return new UserDTO(rs.getInt("userID"), rs.getString("name"), rs.getString("initials"), rs.getInt("active"));
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
				UserDTO userdto = new UserDTO(rs.getInt("userID"), rs.getString("name"), rs.getString("initials"), rs.getInt("active"));
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
