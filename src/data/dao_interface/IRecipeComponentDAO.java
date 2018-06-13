package data.dao_interface;

import java.util.List;

import data.dto.RecipeComponentDTO;
import exceptions.DALException;

public interface IRecipeComponentDAO {
	
	/**
	 * Creates a Recipe component and saves it to the database
	 * IF recipeComponentID=0, the id will be auto-generated.
	 * @param component
	 * @throws DALException
	 */
	public void createRecipeComponent(RecipeComponentDTO component) throws DALException;

	/**
	 * Returns a list of recipecomponents with recsingle Recipe component
	 * @param recipeComponentID
	 * @return A specific Recipe component in form of RecipeComponentDTO
	 * @throws DALException
	 */
	public List<RecipeComponentDTO> getRecipeComponent(int recipeComponentID) throws DALException;

	/**
	 * Returns a list of all Recipe components
	 * @return List of all Recipe components in form of RecipeComponentDTO
	 * @throws DALException
	 */
	public List<RecipeComponentDTO> getAllRecipeComponents() throws DALException;


}
