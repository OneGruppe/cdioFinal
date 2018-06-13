package data.dao_interface;

import java.util.List;

import data.dto.RecipeDTO;
import exceptions.DALException;

public interface IRecipeDAO
{
	/**
	 * Create a recipe and save it to database
	 * @param recipe
	 * @throws DALException
	 */
	public void createRecipe(RecipeDTO recipe) throws DALException;
	
	/**
	 * Updates the information of the given recipe
	 * @param recipe
	 * @throws DALException
	 */
	public void updateRecipe(RecipeDTO recipe) throws DALException;
	
	/**
	 * Returns a single recipe
	 * @param recipeID
	 * @return
	 * @throws DALException
	 */
	public RecipeDTO getRecipe(int recipeID) throws DALException;
	
	/**
	 * Returns a list of all recipes
	 * @return
	 * @throws DALException
	 */
	public List<RecipeDTO> getAllRecipes() throws DALException;
}
