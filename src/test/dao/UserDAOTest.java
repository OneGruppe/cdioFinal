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
import data.dto.RecipeComponentDTO;
import data.dto.UserDTO;
import exceptions.DALException;

public class UserDAOTest {

	private IUserDAO dao;
	private int testID1 = 50;
	private int testID2 = 51;

	@Before
	public void setUp() 
	{
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
			con.doUpdate("DELETE FROM users WHERE userID = " + testID1);
			con.doUpdate("DELETE FROM users WHERE userID = " + testID2);
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createUserTEST() 
	{
		UserDTO expected = new UserDTO(testID1, "Test", "T_T", 0);

		try 
		{
			dao.createUser(expected);

			UserDTO actual = dao.getUser(testID1);

			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void updateUserTEST() 
	{
		UserDTO expected = new UserDTO(testID1, "Test", "T_T", 0);
		UserDTO updated = new UserDTO(testID1, "Test Name", "C", 1);

		try 
		{
			dao.createUser(expected);
			dao.updateUser(updated);

			UserDTO actual = dao.getUser(testID1);

			assertEquals(updated.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void getALLUsersTEST() 
	{
		UserDTO expected1 = new UserDTO(testID1, "Test1", "TTT", 0);
		UserDTO expected2 = new UserDTO(testID2, "Test2", "TTT", 1);

		List<UserDTO> expectedList = new ArrayList<UserDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try 
		{
			dao.createUser(expected1);
			dao.createUser(expected2);

			List<UserDTO> actualList = new ArrayList<UserDTO>();

			for (UserDTO dto : dao.getAllUsers())
			{
				if (dto.toString().equals(testID1)) 
				{
					actualList.add(dto);
				}
				else if (dto.toString().equals(testID2)) 
				{
					actualList.add(dto);
				}
			}
			assertEquals(expectedList.toString(), actualList.toString());
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

}
