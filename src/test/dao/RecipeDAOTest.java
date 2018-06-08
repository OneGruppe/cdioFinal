package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.RecipeDAO;
import data.dao_interface.IRecipeDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeDAOTest
{
	private IRecipeDAO dao;
	private int tempID; //Used to get multiple ID's

	@Before
	public void setUp() 
	{
		tempID = 0;

		try 
		{
			dao = new RecipeDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
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

			for (int i = 1; i <= tempID; i++) 
			{
				con.doUpdate("DELETE FROM recipe WHERE recipeID = " + i);
			}
		} 
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}

	//TODO - skal tjekkes igennem
	@Test
	public void createRecipeTEST() 
	{
		RecipeDTO expected = new RecipeDTO(1, "Pensilin");

		try 
		{
			dao.createRecipe(expected);
			tempID++;

			RecipeDTO actual = dao.getRecipe(1);
			assertEquals(expected.toString(), actual.toString());
		} 
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}

	//TODO - skal tjekkes igennem
	@Test
	public void updateRecipeTEST() 
	{
		RecipeDTO dto = new RecipeDTO(1, "Pensilin");
		RecipeDTO updateExpected = new RecipeDTO(1, "Not Pensilin");

		try 
		{
			dao.createRecipe(dto);
			tempID++;

			dao.updateRecipe(updateExpected);

			RecipeDTO actual = dao.getRecipe(1);

			assertEquals(updateExpected.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void deleteRecipeTEST() 
	{
		RecipeDTO dto = new RecipeDTO(1, "Pensilin");

		try 
		{
			dao.createRecipe(dto);
			tempID++;

			dao.deleteRecipe(1);

			assertTrue(dao.getRecipe(1).toString() == null);
			fail("Error in testDeleteRecipe");
		}
		catch(DALException e) 
		{
			// Success
		}
	}

	//TODO - skal tjekkes igennem
	@Test
	public void getRecipeTEST() 
	{
		RecipeDTO expected = new RecipeDTO(1, "Pensilin");

		try 
		{
			dao.createRecipe(expected);
			tempID++;

			RecipeDTO actual = dao.getRecipe(1);

			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}

	//TODO - skal tjekkes igennem
	@Test
	public void getAllRecipesTEST() 
	{
		RecipeDTO expected1 = new RecipeDTO(1, "Pensilin");
		RecipeDTO expected2 = new RecipeDTO(2, "Panodil");

		List<RecipeDTO> expectedList = new ArrayList<RecipeDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try 
		{
			dao.createRecipe(expected1);
			tempID++;

			dao.createRecipe(expected2);
			tempID++;

			List<RecipeDTO> actualList = dao.getAllRecipes();

			assertEquals(expectedList.toString(), actualList.toString());
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}
}