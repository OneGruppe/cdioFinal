package data.dao_interface;

import java.util.List;
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
	 * @param recipeID
	 * @throws DALException
	 */
	public void deleteRecipe(int recipeID) throws DALException;
	
	/**
	 * Returns a single recipe
	 * @param recipeID the id of the recipe
	 * @return user with id recipeID in form of RecipeDTO
	 * @throws DALException
	 */
	public RecipeDTO showRecipe(int recipeID) throws DALException;
	
	/**
	 * Returns a list of all recipes
	 * @return List of all recipes in form of RecipeDTO
	 * @throws DALException
	 */
	public List<RecipeDTO> showAllRecipes() throws DALException;
}
