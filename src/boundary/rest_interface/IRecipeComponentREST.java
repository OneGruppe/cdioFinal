package boundary.rest_interface;

import exceptions.DALException;

public interface IRecipeComponentREST {

	/**
	 * Creates a RecipeComponent.
	 * @param id
	 * @param name
	 * @throws DALException
	 */
	public String createRecipeComponent(int id, int recipeID, int commodityID, double nonNetto, double tolerance) throws DALException;

	/**
	 * Updates a RecipeComponent
	 * @param id
	 * @param name
	 * @return 
	 * @throws DALException
	 */
	public void updateRecipeComponent(int id, int recipeID, int commodityID, double nonNetto, double tolerance) throws DALException;

	/**
	 * Deletes a RecipeComponent
	 * @param id
	 * @return 
	 * @throws DALException
	 */
	public void deleteRecipeComponent(int id) throws DALException;

	/**
	 * Gets a single RecipeComponent
	 * @return
	 * @throws DALException
	 */
	public String getRecipeComponent(int recipeID) throws DALException;

	/**
	 * Gets a list of all RecipeComponents
	 * @return
	 * @throws DALException
	 */
	public String getAllRecipeComponents() throws DALException;

}
