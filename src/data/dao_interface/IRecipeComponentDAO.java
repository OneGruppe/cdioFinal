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
	 * Updates the information of the given Recipe component 
	 * @param component
	 * @throws DALException
	 */
	public void updateRecipeComponent(RecipeComponentDTO component) throws DALException;
	
	/**
	 * Deletes a Recipe component with the given ID
	 * @param componentID
	 * @throws DALException
	 */
	public void deleteRecipeComponent(int componentID) throws DALException;
	
	/**
	 * Returns a single Recipe component
	 * @param componentID
	 * @return A specific Recipe component in form of RecipeComponentDTO
	 * @throws DALException
	 */
	public RecipeComponentDTO getRecipeComponent(int componentID) throws DALException;
	
	/**
	 * Returns a list of all Recipe components
	 * @return List of all Recipe components in form of RecipeComponentDTO
	 * @throws DALException
	 */
	public List<RecipeComponentDTO> getAllRecipeComponents() throws DALException;
}
