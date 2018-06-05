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
	public void createRecipe(int recipeID, String recipeName, List<Integer> commodityID, double nomNetto,
			double recipeTolerance) throws DALException 
	{		
		RecipeDTO recipe = new RecipeDTO(recipeID, recipeName, commodityID, nomNetto, recipeTolerance);
		
		recipedao.createRecipe(recipe);
	}

	@Override
	public void updateRecipe(int recipeID, String recipeName, List<Integer> commodityID, double nomNetto,
			double recipeTolerance) throws DALException 
	{
		RecipeDTO recipe = new RecipeDTO(recipeID, recipeName, commodityID, nomNetto, recipeTolerance);
		
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
