package test.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.RecipeDAO;
import data.dao_implementation.UserDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeDAOTest
{
	RecipeDAO dao;
	int tempID; //Used to get multiple ID's
	
	@Before
	public void setUp()
	{
		tempID = 0;
		
		try
		{
			dao = new RecipeDAO();
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}
	
	@After
	public void teardown()
	{
		try {
			Connector con = new Connector();
			
			for (int i = 1; i <= tempID; i++) {
				con.doUpdate("DELETE FROM recipe WHERE recipeID = " + i);
				
			}
		} 
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void testCreateRecipe() throws DALException
	{
		RecipeDTO expected = new RecipeDTO(1, "Pensilin");
		tempID++;

		try {
		dao.createRecipe(expected);

		RecipeDTO actual = dao.getRecipe(1);
		assertEquals(expected.toString(), actual.toString());
		} 
		catch(DALException e) {
		fail("Error " + e.getMessage());
		}
	}

	@Test
	public void testUpdateRecipe() throws DALException
	{
		RecipeDTO dto = new RecipeDTO(1, "Pensilin");
		RecipeDTO updateExpected = new RecipeDTO(1, "Not Pensilin");
		tempID++;

		try {
			dao.createRecipe(dto);
			dao.updateRecipe(updateExpected);
	
			RecipeDTO actual = dao.getRecipe(1);
	
			assertEquals(updateExpected.toString(), actual.toString());
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void testDeleteRecipe() throws DALException
	{
		RecipeDTO dto = new RecipeDTO(1, "Pensilin");
		tempID++;

		try {
			dao.createRecipe(dto);
			dao.deleteRecipe(1);
	
			assertTrue(dao.getRecipe(1).toString() == null);
			fail("Error in testDeleteRecipe");
		}
		catch(DALException e) {
			// Success
		}
	}

	@Test
	public void testGetRecipe() throws DALException {
		RecipeDTO expected = new RecipeDTO(1, "Pensilin");
		tempID++;
		
		try {
			dao.createRecipe(expected);
			RecipeDTO actual = dao.getRecipe(1);
	
			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void testGetAllRecipes() throws DALException
	{
		RecipeDTO expected1 = new RecipeDTO(1, "Pensilin");
		tempID++;
		RecipeDTO expected2 = new RecipeDTO(2, "Panodil");
		tempID++;
		
		List<RecipeDTO> expectedList = new ArrayList<RecipeDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);
		
		try {
			dao.createRecipe(expected1);
			dao.createRecipe(expected2);

			List<RecipeDTO> actualList = dao.getAllRecipes();
	
			assertEquals(expectedList.toString(), actualList.toString());
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}
}