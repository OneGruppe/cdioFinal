package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.IRecipeController;
import data.dao_implementation.RecipeDAO;
import data.dao_interface.IRecipeDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeController implements IRecipeController
{

	private IRecipeDAO recipedao;

	public RecipeController() throws DALException 
	{
		recipedao = new RecipeDAO();
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeController#createRecipe(int, java.lang.String)
	 */
	@Override
	public void createRecipe(int recipeID, String recipeName) throws DALException 
	{		
		RecipeDTO recipe = new RecipeDTO(recipeID, recipeName);

		recipedao.createRecipe(recipe);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeController#updateRecipe(int, java.lang.String)
	 */
	@Override
	public void updateRecipe(int recipeID, String recipeName) throws DALException 
	{
		RecipeDTO recipe = new RecipeDTO(recipeID, recipeName);

		recipedao.updateRecipe(recipe);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeController#deleteRecipe(int)
	 */
	@Override
	public void deleteRecipe(int recipeID) throws DALException 
	{
		recipedao.deleteRecipe(recipeID);

	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeController#getRecipe(int)
	 */
	@Override
	public RecipeDTO getRecipe(int recipeID) throws DALException 
	{
		RecipeDTO recipe;
		recipe = recipedao.getRecipe(recipeID);
		return recipe;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeController#getAllRecipes()
	 */
	@Override
	public List<RecipeDTO> getAllRecipes() throws DALException 
	{
		List<RecipeDTO> recipeList;
		recipeList = recipedao.getAllRecipes();
		return recipeList;
	}


}
