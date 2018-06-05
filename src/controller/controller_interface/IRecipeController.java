package controller.controller_interface;

import java.util.List;

import data.dto.RecipeDTO;
import exceptions.DALException;

public interface IRecipeController {
	
	/**
	 * Creates a recipe
	 * @param recipeID
	 * @param recipeName
	 * @param commodityID
	 * @param nomNetto
	 * @param recipeTolerance
	 * @throws DALException
	 */
	public void createRecipe(int recipeID, String recipeName, List<Integer> commodityID, double nomNetto, double recipeTolerance) throws DALException;

	/**
	 * Updates a recipe
	 * @param recipeID
	 * @param recipeName
	 * @param commodityID
	 * @param nomNetto
	 * @param recipeTolerance
	 * @throws DALException
	 */
	public void updateRecipe(int recipeID, String recipeName, List<Integer> commodityID, double nomNetto, double recipeTolerance) throws DALException;
	
	/**
	 * Deletes a recipe
	 * @param recipeID
	 * @throws DALException
	 */
	public void deleteRecipe(int recipeID) throws DALException;
	
	/**
	 * Get a single recipe
	 * @param recipeID
	 * @return a single RecipeDTO object
	 * @throws DALException
	 */
	public RecipeDTO getRecipe(int recipeID) throws DALException;
	
	/**
	 * Get a list of all recipes
	 * @return a list of RecipeDTO obejcts
	 * @throws DALException
	 */
	public List<RecipeDTO> getAllRecipes() throws DALException;
}
