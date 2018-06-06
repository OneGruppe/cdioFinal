package test.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.UserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class UserDAOTest 
{
	UserDAO userdao;

	@Before
	public void connect()
	{
		try
		{
			userdao = new UserDAO();
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void teardown()
	{
		try
		{
			Connector con = new Connector();
			con.doUpdate("DELETE FROM users WHERE userID = 5");
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createAndGetUser() 
	{
		UserDTO expected = new UserDTO(5, "Test User", "TU", 0);

		try
		{
			userdao.createUser(expected);
			UserDTO actual = userdao.getUser(5);
			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void updateAndGetUser() 
	{
		UserDTO exUser = new UserDTO(5, "Test User True", "TUT", 0);
		UserDTO updUser = new UserDTO(5, "Test User Profile", "TUP", 1);

		try
		{
			userdao.createUser(exUser);
			UserDTO before = userdao.getUser(5);
			assertEquals(exUser.toString(), before.toString());

			// Update user
			userdao.updateUser(updUser);
			UserDTO after = userdao.getUser(5);
			assertNotEquals(updUser.toString(), after.toString());
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void getALLUser() 
	{
		UserDTO userOne = new UserDTO(5, "Test User Wang", "TUW", 0);

		try
		{
			userdao.createUser(userOne);
			for (UserDTO usr : userdao.getAllUsers())
			{
				if (usr.getId() == 5)
				{
					assertEquals(userOne.toString(), usr.toString());
					break;
				}
			}
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

}
