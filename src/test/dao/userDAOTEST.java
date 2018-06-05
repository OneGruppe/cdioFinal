package test.dao;
import java.sql.SQLException;

import data.dao_implementation.UserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class userDAOTEST 
{
	static data.connector.Connector con;

	userDAOTEST(){
		try {
			con = new data.connector.Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}


	public static void main(String[] args) 
	{
		UserDAO userdao = null;
		UserDTO userdto = new UserDTO(5, "Sebastian Den Lille", "SDL", 1);
		UserDTO userdtochange = new UserDTO(5, "Sebastian Den Store", "SDS", 0);

		try 
		{	
			userdao = new UserDAO();
			// Create
			System.out.println("Creating user: " + userdto.toString());
			userdao.createUser(userdto);
			
			// Show user 5
			System.out.println("User found: " + userdao.showUser(5));
			
			
			// Update
			System.out.println("Update user to: " + userdtochange.toString());
			userdao.updateUser(userdtochange);
			
			// Show user 5
			System.out.println("User found: " + userdao.showUser(5));
			
			
			// Deletion of user (not implemented, but testdata is deleted)
			con.doUpdate("DELETE from users WHERE userID = '5'");
			System.out.println(userdao.showUser(5));
			
			
			// Show all users
			System.out.println("Showing all users");
			for(UserDTO user : userdao.showAllUsers())
			{
				System.out.println(user.toString());
			}
		} 
		catch (DALException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}
