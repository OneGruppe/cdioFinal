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
	private Connector connector;
	
	public UserDAO() 
	{
		try {
			connector = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void createUser(UserDTO user) throws DALException 
	{
		connector.doUpdate("INSERT INTO users(userID, name, initial) "
						 + "VALUES(" +user.getUserID()+ ", '" +user.getUserName()+ "', '" +user.getUserIni()+ "',"  +user.getActive()+ ")");
		
	}

	@Override
	public void updateUser(UserDTO user) throws DALException 
	{
		connector.doUpdate("UPDATE users SET name = '" +user.getUserName()+ "', initial = '" +user.getUserIni()+ "'"
				         + " WHERE userID = " +user.getUserID());
		
	}

	@Override
	public void setUserState(int userID, int state) throws DALException 
	{
		connector.doUpdate("UPDATE users SET active = " +state+ " WHERE userID = " +userID);
		
	}

	@Override
	public UserDTO showUser(int userID) throws DALException 
	{
		ResultSet rs = connector.doQuery("SELECT * FROM users WHERE userID = " + userID);
		
		try 
		{
			if(!rs.first()) 
			{
				throw new DALException("Brugeren med ID " +userID+ " findes ikke");
			}
			
			return new UserDTO(rs.getInt("userID"), rs.getString("name"), rs.getString("initial"), rs.getInt("active"));
		} 
		catch (SQLException e) {throw new DALException(e.getMessage());}
	}

	@Override
	public List<UserDTO> showAllUsers() throws DALException 
	{
		List<UserDTO> users = new ArrayList<UserDTO>();
		ResultSet rs = connector.doQuery("SELECT * FROM users");
		try
		{
			if(!rs.first())
			{
				throw new DALException("Der findes ingen brugere i systemet");
			}
			while(rs.next()) 
			{
				users.add(new UserDTO(rs.getInt("userID"), rs.getString("name"), rs.getString("initial"), rs.getInt("active")));
			}
			return users;
		}
		catch(SQLException e) {throw new DALException(e.getMessage());}
	}
	
}
