package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.dao_implementation.RecipeDAO;
import data.dao_interface.IRecipeDAO;
import data.dto.CommodityBatchDTO;
import data.dto.RecipeComponentDTO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeDAOTest {

	private IRecipeDAO dao;
	private int testID1 = 50;
	private int testID2 = 51;

	@Before
	public void setUp() 
	{
		try 
		{
			dao = new RecipeDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void teardown() 
	{
		try 
		{
			dao.deleteRecipe(testID1);
			dao.deleteRecipe(testID2);
		} 
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createRecipeTEST() 
	{
		RecipeDTO expected = new RecipeDTO(testID1, "Pensilin");

		try 
		{
			dao.createRecipe(expected);

			RecipeDTO actual = dao.getRecipe(testID1);

			assertEquals(expected.toString(), actual.toString());
		} 
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void updateRecipeTEST() 
	{
		RecipeDTO expected = new RecipeDTO(testID1, "Pensilin");
		RecipeDTO updated = new RecipeDTO(testID1, "Not Pensilin");

		try 
		{
			dao.createRecipe(expected);
			dao.updateRecipe(updated);

			RecipeDTO actual = dao.getRecipe(testID1);

			assertEquals(updated.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void getAllRecipesTEST() 
	{
		RecipeDTO expected1 = new RecipeDTO(testID1, "Pensilin");
		RecipeDTO expected2 = new RecipeDTO(testID2, "Panodil");

		List<RecipeDTO> expectedList = new ArrayList<RecipeDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try 
		{
			dao.createRecipe(expected1);
			dao.createRecipe(expected2);

			List<RecipeDTO> actualList = new ArrayList<RecipeDTO>();
			
			for (RecipeDTO dto : dao.getAllRecipes())
			{
				if (dto.getRecipeID() == testID1) 
				{
					actualList.add(dto);
				}
				else if (dto.getRecipeID() == testID2) 
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