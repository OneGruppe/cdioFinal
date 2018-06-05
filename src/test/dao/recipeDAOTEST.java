package test.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.RecipeDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class recipeDAOTEST
{
	
	@After
	public void teardown(int id)
	{
		try {
			Connector con = new Connector();
			con.doUpdate("DELETE FROM recipe WHERE ID =" + id);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException | DALException e)
		{
			System.out.println("ERROR IN: " + e.getMessage());
		}
	}

	@Test
	public void testCreateRecipe() throws DALException
	{
		RecipeDAO recipe = new RecipeDAO();
		
		List<Integer> commodityIDList = new ArrayList<Integer>();
		commodityIDList.add(1);
		commodityIDList.add(3);
		commodityIDList.add(5);
		RecipeDTO expected = new RecipeDTO(1, "Pensilin", commodityIDList, 10.5, 0.1);
		
		recipe.createRecipe(expected);
		
		RecipeDTO actual = recipe.getRecipe(1);
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void testUpdateRecipe() throws DALException
	{
		RecipeDAO recipe = new RecipeDAO();
		
		List<Integer> commodityIDList = new ArrayList<Integer>();
		commodityIDList.add(1);
		commodityIDList.add(3);
		commodityIDList.add(5);
		RecipeDTO expected = new RecipeDTO(1, "Pensilin", commodityIDList, 10.5, 0.1);
		commodityIDList.add(7);
		RecipeDTO actual = new RecipeDTO(1, "Pensilin", commodityIDList, 10.6, 0.15);
		
		recipe.updateRecipe(actual);
		
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	public void testDeleteRecipe() throws DALException
	{
		RecipeDAO recipe = new RecipeDAO();
		
		List<Integer> commodityIDList = new ArrayList<Integer>();
		commodityIDList.add(1);
		commodityIDList.add(3);
		commodityIDList.add(5);
		RecipeDTO expected = new RecipeDTO(1, "Pensilin", commodityIDList, 10.5, 0.1);
		
		recipe.deleteRecipe(1);
		
		System.out.println(expected.toString());
		assertEquals(expected.toString(), null);
	}

	@Test
	public void testGetRecipe() throws DALException {
		RecipeDAO recipe = new RecipeDAO();
		
		List<Integer> commodityIDList = new ArrayList<Integer>();
		commodityIDList.add(1);
		commodityIDList.add(3);
		commodityIDList.add(5);
		RecipeDTO expected = new RecipeDTO(1, "Pensilin", commodityIDList, 10.5, 0.1);
		
		System.out.println(recipe.getRecipe(1));
	}

	@Test
	public void testGetAllRecipes() throws DALException
	{
		RecipeDAO recipe = new RecipeDAO();
		
		List<Integer> commodityIDList = new ArrayList<Integer>();
		commodityIDList.add(1);
		commodityIDList.add(3);
		commodityIDList.add(5);
		RecipeDTO expected = new RecipeDTO(1, "Pensilin", commodityIDList, 10.5, 0.1);
		RecipeDTO expected2 = new RecipeDTO(2, "Panodil", commodityIDList, 11, 0.2);
		System.out.println(recipe.getAllRecipes());
		
	}

}
