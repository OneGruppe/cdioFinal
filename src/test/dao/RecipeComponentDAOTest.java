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

import data.dao_implementation.CommodityDAO;
import data.dao_implementation.RecipeComponentDAO;
import data.dao_implementation.RecipeDAO;
import data.dao_implementation.SupplierDAO;
import data.dao_interface.ICommodityDAO;
import data.dao_interface.IRecipeComponentDAO;
import data.dao_interface.IRecipeDAO;
import data.dao_interface.ISupplierDAO;
import data.dto.CommodityDTO;
import data.dto.RecipeComponentDTO;
import data.dto.RecipeDTO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class RecipeComponentDAOTest {

	IRecipeComponentDAO reccomdao;

	@Before
	public void setUp() {
		try {
			reccomdao = new RecipeComponentDAO();
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void teardown() {
		try {
			// Delete all test-data in recipecomponent-table
			reccomdao.deleteRecipeComponent(50);
			reccomdao.deleteRecipeComponent(51);
		} 
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void testCreateRecipeComponentTest() {
		RecipeComponentDTO expected = new RecipeComponentDTO(50, 1, 1, 0.9, 0.1);

		try {
			reccomdao.createRecipeComponent(expected);

			RecipeComponentDTO actual = reccomdao.getRecipeComponent(expected.getRecipeComponentID());
			assertEquals(expected.toString(), actual.toString());
		} 
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void testUpdateRecipeComponentTest() {
		RecipeComponentDTO dto = new RecipeComponentDTO(50, 1, 1, 0.9, 0.1);
		RecipeComponentDTO updateExpected = new RecipeComponentDTO(50, 2, 2, 1.9, 0.2);

		try {
			reccomdao.createRecipeComponent(dto);

			reccomdao.updateRecipeComponent(updateExpected);

			RecipeComponentDTO actual = reccomdao.getRecipeComponent(dto.getRecipeComponentID());

			assertEquals(updateExpected.toString(), actual.toString());
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void testDeleteRecipeComponentTest() {
		RecipeComponentDTO dto = new RecipeComponentDTO(50, 1, 1, 0.9, 0.1);

		try {
			reccomdao.createRecipeComponent(dto);
			reccomdao.deleteRecipeComponent(dto.getRecipeComponentID());

			assertTrue(reccomdao.getRecipeComponent(dto.getRecipeComponentID()).toString() == null);
			fail("Error in testDeleteRecipe");
		}
		catch(DALException e) {
			// Success
		}
	}

	@Test
	public void testGetRecipeComponentTest() {
		RecipeComponentDTO expected = new RecipeComponentDTO(50, 1, 1, 0.9, 0.1);

		try {
			reccomdao.createRecipeComponent(expected);

			RecipeComponentDTO actual = reccomdao.getRecipeComponent(expected.getRecipeComponentID());

			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void testGetAllRecipeComponentsTest() {
		RecipeComponentDTO expected1 = new RecipeComponentDTO(50, 1, 1, 0.9, 0.1);
		RecipeComponentDTO expected2 = new RecipeComponentDTO(51, 2, 2, 1.9, 0.2);

		List<RecipeComponentDTO> expectedList = new ArrayList<RecipeComponentDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try {
			reccomdao.createRecipeComponent(expected1);
			reccomdao.createRecipeComponent(expected2);

			List<RecipeComponentDTO> actualList = new ArrayList<RecipeComponentDTO>();
			
			for (RecipeComponentDTO reccomdto : reccomdao.getAllRecipeComponents())
			{
				if (reccomdto.toString().equals(expected1.toString())) {
					actualList.add(reccomdto);
				}
				else if (reccomdto.toString().equals(expected2.toString())) {
					actualList.add(reccomdto);
				}
			}

			assertEquals(expectedList.toString(), actualList.toString());
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}
}
