package test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.UserDAO;
import data.dto.UserDTO;
import exceptions.DALException;

public class UserDAOTest 
{
	UserDAO dao;
	int tempID; //Used to get multiple ID's

	@Before
	public void setUp()
	{
		tempID = 0;
		
		try {
			dao = new UserDAO();
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void teardown()
	{
		try {
			Connector con = new Connector();
			
			for(int i = 1; i <= tempID; i++) {
			con.doUpdate("DELETE FROM users WHERE userID = " + i);
			}
		}
		catch(DALException e){
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createAndGetUser() 
	{
		UserDTO expected = new UserDTO(1, "Test", "T_T", 0);
		tempID++;

		try {
			dao.createUser(expected);
			UserDTO actual = dao.getUser(1);
			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void updateUser() 
	{
		UserDTO dto = new UserDTO(1, "Test", "T_T", 0);
		tempID++;
		UserDTO updateExpected = new UserDTO(1, "Not Test", "C:", 1);

		try {
			dao.createUser(dto);
			dao.updateUser(updateExpected);
			
			UserDTO actual = dao.getUser(1);

			assertEquals(updateExpected.toString(), actual.toString());
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void getALLUser() 
	{
		UserDTO user1 = new UserDTO(1, "Test1", "TTT", 0);
		tempID++;
		UserDTO user2 = new UserDTO(2, "Test2", "TTT", 0);
		tempID++;
		
		List<UserDTO> expectedList = new ArrayList<UserDTO>();
		expectedList.add(user1);
		expectedList.add(user2);
		
		try {
			dao.createUser(user1);
			dao.createUser(user2);
			
			List<UserDTO> actualList = dao.getAllUsers();
			
			assertEquals(expectedList.toString(), actualList.toString());
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

}
