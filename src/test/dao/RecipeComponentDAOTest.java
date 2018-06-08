package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import data.dao_implementation.RecipeComponentDAO;
import data.dao_interface.IRecipeComponentDAO;
import data.dto.RecipeComponentDTO;
import exceptions.DALException;

public class RecipeComponentDAOTest {

	IRecipeComponentDAO dao;

	@Before
	public void setUp() {

		try {
			dao = new RecipeComponentDAO();
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void teardown() {
		try {
			dao.deleteRecipeComponent(1);
			dao.deleteRecipeComponent(2);
		} 
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Ignore
	public void testCreateRecipe() {
		RecipeComponentDTO expected = new RecipeComponentDTO(1, 1, 1, 0.9, 0.1);

		try {
			dao.createRecipeComponent(expected);

			RecipeComponentDTO actual = dao.getRecipeComponent(1);
			assertEquals(expected.toString(), actual.toString());
		} 
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Ignore
	public void testUpdateRecipe() {
		RecipeComponentDTO dto = new RecipeComponentDTO(1, 1, 1, 0.9, 0.1);
		RecipeComponentDTO updateExpected = new RecipeComponentDTO(1, 2, 2, 1.9, 0.2);

		try {
			dao.createRecipeComponent(dto);

			dao.updateRecipeComponent(updateExpected);

			RecipeComponentDTO actual = dao.getRecipeComponent(1);

			assertEquals(updateExpected.toString(), actual.toString());
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void testDeleteRecipe() {
		RecipeComponentDTO dto = new RecipeComponentDTO(1, 1, 1, 0.9, 0.1);

		try {
			dao.createRecipeComponent(dto);
			dao.deleteRecipeComponent(dto.getRecipeComponentID());

			assertTrue(dao.getRecipeComponent(1).toString() == null);
			fail("Error in testDeleteRecipe");
		}
		catch(DALException e) {
			// Success
		}
	}

	@Ignore
	public void testGetRecipe() {
		RecipeComponentDTO expected = new RecipeComponentDTO(1, 1, 1, 0.9, 0.1);

		try {
			dao.createRecipeComponent(expected);

			RecipeComponentDTO actual = dao.getRecipeComponent(1);

			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Ignore
	public void testGetAllRecipes() {
		RecipeComponentDTO expected1 = new RecipeComponentDTO(1, 1, 1, 0.9, 0.1);
		RecipeComponentDTO expected2 = new RecipeComponentDTO(2, 2, 2, 1.9, 0.2);

		List<RecipeComponentDTO> expectedList = new ArrayList<RecipeComponentDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try {
			dao.createRecipeComponent(expected1);
			dao.createRecipeComponent(expected2);

			List<RecipeComponentDTO> actualList = dao.getAllRecipeComponents();

			assertEquals(expectedList.toString(), actualList.toString());
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}
}
