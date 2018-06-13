package boundary.rest_interface;

import exceptions.DALException;

public interface IRecipeREST {

	/**
	 * Creates a Recipe.
	 * @param id
	 * @param name
	 * @throws DALException
	 */
	public String createRecipe(int id, String name) throws DALException;

	/**
	 * Updates a Recipe
	 * @param id
	 * @param name
	 * @throws DALException
	 */
	public void updateRecipe(int id, String name) throws DALException;

	/**
	 * Gets a single Recipe
	 * @return
	 * @throws DALException
	 */
	public String getRecipe(int id) throws DALException;

	/**
	 * Gets a list of all Recipes
	 * @return
	 * @throws DALException
	 */
	public String getAllRecipe() throws DALException;


}
