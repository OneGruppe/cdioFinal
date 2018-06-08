package boundary.rest_interface;

import java.util.List;

import data.dto.RecipeDTO;
import exceptions.DALException;

public interface IRecipeREST {

	/**
	 * Creates a Recipe.
	 * @param id
	 * @param name
	 * @throws DALException
	 */
	public void createRecipe(int id, String name) throws DALException;
	
	/**
	 * Updates a Recipe
	 * @param id
	 * @param name
	 * @throws DALException
	 */
	public void updateRecipe(int id, String name) throws DALException;
	
	/**
	 * Deletes a Recipe
	 * @param id
	 * @throws DALException
	 */
	public void deleteRecipe(int id) throws DALException;
	
	/**
	 * Gets a single Recipe
	 * @return
	 * @throws DALException
	 */
	public RecipeDTO getRecipe(int id) throws DALException;
	
	/**
	 * Gets a list of all Recipes
	 * @return
	 * @throws DALException
	 */
	public List<RecipeDTO> getAllRecipe() throws DALException;
}

