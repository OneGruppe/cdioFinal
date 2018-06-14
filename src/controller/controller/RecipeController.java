package controller.controller;

import java.util.List;

import controller.controller_interface.IRecipeController;
import data.dao.RecipeDAO;
import data.dao_interface.IRecipeDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeController implements IRecipeController {

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
	public void createRecipe(int id, String name) throws DALException 
	{		
		RecipeDTO recipe = new RecipeDTO(id, name);

		recipedao.createRecipe(recipe);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeController#getRecipe(int)
	 */
	@Override
	public RecipeDTO getRecipe(int id) throws DALException 
	{
		RecipeDTO recipe;
		recipe = recipedao.getRecipe(id);
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
