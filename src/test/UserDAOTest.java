package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.UserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class UserDAOTest 
{

	@Test
	public void createAndUpdateUser() throws DALException 
	{
		UserDTO exUser = new UserDTO(5, "Test User", "TU", 0);
		UserDTO expected = new UserDTO(5, "Test User Profile", "TUP", 1);
		UserDAO userdao = new UserDAO();

		userdao.createUser(exUser);
		userdao.updateUser(expected);
		UserDTO actual = userdao.getUser(5);
		assertEquals(expected.toString(), actual.toString());
	}
	
	@After
	public void teardown()
	{
			Connector con;
			try {
				con = new Connector();
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con.doQuery("DELETE FROM users WHERE userID=" + 5);
		
	}

}
