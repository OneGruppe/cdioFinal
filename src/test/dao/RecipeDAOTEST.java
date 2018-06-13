package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao.RecipeDAO;
import data.dao_interface.IRecipeDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeDAOTEST {

	private IRecipeDAO dao;
	private int testID1 = 50;
	private int testID2 = 51;

	@Before
	public void setUp() 
	{
		try 
		{
			dao = new RecipeDAO();
		}
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

	@After
	public void teardown() 
	{
		try 
		{
			Connector con = new Connector();
			con.doUpdate("DELETE FROM recipe WHERE id= " + testID1);
			con.doUpdate("DELETE FROM recipe WHERE id= " + testID2);
		} 
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
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
			System.out.println(e.getMessage());
			fail(e.getMessage());
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
				if (dto.getId() == testID2) 
				{
					actualList.add(dto);
				}
				else if (dto.getId() == testID1) 
				{
					actualList.add(dto);
				}
			}
			assertEquals(expectedList.toString(), actualList.toString());
		}
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}
}