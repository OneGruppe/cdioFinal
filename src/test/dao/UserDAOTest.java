package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.UserDAO;
import data.dao_interface.IUserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class UserDAOTest 
{
	private IUserDAO dao;
	private int tempID; //Used to get multiple ID's

	@Before
	public void setUp() 
	{
		tempID = 0;

		try 
		{
			dao = new UserDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
		}
		catch(DALException e) 
		{
			System.out.println("Error connecting" + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void teardown() 
	{
		try 
		{
			Connector con = new Connector();

			for(int i = 1; i <= tempID; i++) 
			{
				con.doUpdate("DELETE FROM users WHERE userID = " + i);
			}
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}

	//TODO - virker ikke, måske DAO-problem
	@Test
	public void createAndGetUser() 
	{
		UserDTO expected = new UserDTO(1, "Test", "T_T", 0);

		try 
		{
			dao.createUser(expected);
			UserDTO actual = dao.getUser(1);
			tempID++;

			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}

	//TODO - virker ikke, måske DAO-problem
	@Test
	public void updateUser() 
	{
		UserDTO dto = new UserDTO(1, "Test", "T_T", 0);
		UserDTO updateExpected = new UserDTO(1, "Not Test", "C:", 1);

		try 
		{
			dao.createUser(dto);
			dao.updateUser(updateExpected);
			tempID++;

			UserDTO actual = dao.getUser(1);

			assertEquals(updateExpected.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}

	//TODO - virker ikke, måske DAO-problem
	@Test
	public void getALLUser() 
	{
		UserDTO user1 = new UserDTO(1, "Test1", "TTT", 0);
		UserDTO user2 = new UserDTO(2, "Test2", "TTT", 0);

		List<UserDTO> expectedList = new ArrayList<UserDTO>();
		expectedList.add(user1);
		expectedList.add(user2);

		try 
		{
			dao.createUser(user1);
			tempID++;

			dao.createUser(user2);
			tempID++;

			List<UserDTO> actualList = dao.getAllUsers();

			assertEquals(expectedList.toString(), actualList.toString());
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}

	
}
