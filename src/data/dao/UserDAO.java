package data.dao;

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

	/**
	 * Constructor that uses Constant-class to connect
	 * @throws DALException
	 */
	public UserDAO() throws DALException
	{
		try 
		{
			con = new Connector();
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
	}

	/**
	 * Constructor that uses the parameters
	 * @param server
	 * @param port
	 * @param database
	 * @param username
	 * @param password
	 * @throws DALException
	 */
	public UserDAO(String server, int port, String database, String username, String password) throws DALException
	{
		try {
			con = new Connector(server, port, database, username, password);
		} 		
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#createUser(data.dto.UserDTO)
	 */
	@Override
	public void createUser(UserDTO user) throws DALException
	{
		try 
		{
			con.doUpdate("INSERT INTO user VALUES ("
					+ user.getId() + ", "
					+ "'" + user.getName() + "', "
					+ "'" + user.getIni() + "', "
					+ user.getActive() + ")");
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
			throw new DALException("Fejl i oprettelse af bruger");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#updateUser(data.dto.UserDTO)
	 */
	@Override
	public void updateUser(UserDTO user) throws DALException
	{
		try {
			con.doUpdate("UPDATE user SET "
					+ "name='" + user.getName() + "', "
					+ "ini='" + user.getIni() + "', "
					+ "active=" + user.getActive() + " "
					+ "WHERE id=" + user.getId());
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
			throw new DALException("Fejl i opdatering af bruger");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#setUserState(int, int)
	 */
	@Override
	public void setUserState(int id, int state) throws DALException
	{
		try 
		{
			con.doUpdate("UPDATE user SET active=" + state + " WHERE id = " + id);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
			throw new DALException("Fejl i opdatering af brugerens status");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IUserDAO#showUser(int)
	 */
	@Override
	public UserDTO getUser(int id) throws DALException 
	{
		ResultSet rs = con.doQuery("SELECT * FROM user WHERE id = " + id);

		try 
		{
			if(!rs.first()) 
			{
				throw new DALException("Bruger med id '" + id + "' findes ikke");
			}
			else 
			{
				return new UserDTO(rs.getInt("id"), rs.getString("name"), rs.getString("ini"), rs.getInt("active"));
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			throw new DALException("Fejl i hentningen af bruger");
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
		ResultSet rs = con.doQuery("SELECT * FROM user");

		try
		{
			while(rs.next()) {
				UserDTO userdto = new UserDTO(rs.getInt("id"), rs.getString("name"), rs.getString("ini"), rs.getInt("active"));
				users.add(userdto);
			}
			if(users.isEmpty()) {
				throw new DALException("Bruger listen er tom...\nTilføj nogle værdier og prøv igen");
			}
			return users;
		}
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			throw new DALException("Fejl i hentningen af bruger-listen");
		}
	}


}
