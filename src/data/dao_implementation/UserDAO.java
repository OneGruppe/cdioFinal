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
	Connector connector;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDTO user) throws DALException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateUser(int userID) throws DALException 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activateUser(int userID) throws DALException 
	{
		// TODO Auto-generated method stub
		
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
			
			return new UserDTO(rs.getInt("userID"), rs.getString("name"), rs.getString("initial"));
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
			while(rs.next()) 
			{
				users.add(new UserDTO(rs.getInt("userID"), rs.getString("name"), rs.getString("initial")));
			}
			return users;
		}
		catch(SQLException e) {throw new DALException(e.getMessage());}
	}
	
}
