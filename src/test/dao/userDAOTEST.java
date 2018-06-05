package test.dao;
import java.util.List;

import data.dao_implementation.UserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class userDAOTEST 
{

	public static void main(String[] args) 
	{
		UserDAO userdao = null;
		UserDTO userdto = new UserDTO(5, "Testdata Andersen", "TA", 1);
		UserDTO userdtochange = new UserDTO(5, "Testdata From Andersen", "TFA", 0);

		try 
		{	
			userdao = new UserDAO();
			
			/*
			// Create
			System.out.println("-- Create user --");
			System.out.println("Creating user: " + userdto.toString());
			userdao.createUser(userdto);

			// Show user 5
			System.out.println("-- Show created user --");
			System.out.println("User found: " + userdao.showUser(5));


			// Update
			System.out.println("-- Updating user --");
			System.out.println("Update user to: " + userdtochange.toString());
			userdao.updateUser(userdtochange);

			// Show user 5
			System.out.println("-- Show created user --");
			System.out.println("User found: " + userdao.showUser(5));
			*/

			// Show all users
			System.out.println("Showing all users");
			int i = 1;
			List<UserDTO> userlist = userdao.getAllUsers();
			for(UserDTO user : userlist)
			{
				System.out.println(i + ". " + user.toString());
				i++;
			}
			
		} 
		catch (DALException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		

	}
}
