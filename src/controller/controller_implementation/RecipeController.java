package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.IRecipeController;
import data.dao_implementation.RecipeDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeController implements IRecipeController{
	
	RecipeDAO recipedao;
	
	public RecipeController() throws DALException 
	{
		recipedao = new RecipeDAO();
	}

	@Override
	public void createRecipe(int recipeID, String recipeName) throws DALException 
	{		
		RecipeDTO recipe = new RecipeDTO(recipeID, recipeName);
		
		recipedao.createRecipe(recipe);
	}

	@Override
	public void updateRecipe(int recipeID, String recipeName) throws DALException 
	{
		RecipeDTO recipe = new RecipeDTO(recipeID, recipeName);
		
		recipedao.updateRecipe(recipe);
	}

	@Override
	public void deleteRecipe(int recipeID) throws DALException 
	{
		recipedao.deleteRecipe(recipeID);
		
	}

	@Override
	public RecipeDTO getRecipe(int recipeID) throws DALException 
	{
		RecipeDTO recipe;
		recipe = recipedao.getRecipe(recipeID);
		return recipe;
	}

	@Override
	public List<RecipeDTO> getAllRecipes() throws DALException 
	{
		List<RecipeDTO> recipeList;
		recipeList = recipedao.getAllRecipes();
		return recipeList;
	}

}
