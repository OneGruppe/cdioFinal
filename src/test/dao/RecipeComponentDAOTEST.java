package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao.RecipeComponentDAO;
import data.dao_interface.IRecipeComponentDAO;
import data.dto.RecipeComponentDTO;
import exceptions.DALException;

public class RecipeComponentDAOTEST {

	private IRecipeComponentDAO dao;
	private int testID1 = 50;
	private int testID2 = 51;

	@Before
	public void setUp() 
	{
		try 
		{
			dao = new RecipeComponentDAO();
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
			con.doUpdate("DELETE FROM recipeComponent WHERE id= " + testID1);
			con.doUpdate("DELETE FROM recipeComponent WHERE id= " + testID2);
		} 
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

	@Test
	public void createRecipeComponentTEST() 
	{
		RecipeComponentDTO expected = new RecipeComponentDTO(testID1, 1, 1, 0.9, 0.1);

		try 
		{
			dao.createRecipeComponent(expected);

			for(RecipeComponentDTO actual : dao.getRecipeComponent(1))
			{
				if(actual.getId() == testID1)
				{
					assertEquals(expected.toString(), actual.toString());
					break;
				}
			}
		} 
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

	@Test
	public void getAllRecipeComponentsTEST() 
	{
		RecipeComponentDTO expected1 = new RecipeComponentDTO(testID1, 3, 1, 1.0, 0.1);
		RecipeComponentDTO expected2 = new RecipeComponentDTO(testID2, 4, 2, 2.0, 0.2);

		List<RecipeComponentDTO> expectedList = new ArrayList<RecipeComponentDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try 
		{
			dao.createRecipeComponent(expected1);
			dao.createRecipeComponent(expected2);

			List<RecipeComponentDTO> actualList = new ArrayList<RecipeComponentDTO>();

			for (RecipeComponentDTO dto : dao.getAllRecipeComponents())
			{
				if (dto.getId() == testID1) 
				{
					actualList.add(dto);
				}
				else if (dto.getId() == testID2) 
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
