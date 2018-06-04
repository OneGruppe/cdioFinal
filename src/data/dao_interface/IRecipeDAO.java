package data.dao_interface;

import data.dto.RecipeDTO;
import exceptions.DALException;

public interface IRecipeDAO {
	/**
	 * Creates a recipe and save it to the database.
	 * @param recipe
	 * @throws DALException
	 */
	public void createRecipe(RecipeDTO recipe) throws DALException;
	
	/**
	 * Updates the information of the given recipe.
	 * @param recipe
	 * @throws DALException
	 */
	public void updateRecipe(RecipeDTO recipe) throws DALException;
	
	/**
	 * Deletes the recipe with the given ID
	 * @param recipe
	 * @throws DALException
	 */
	public void deleteRecipe(int recipeID) throws DALException;
}
