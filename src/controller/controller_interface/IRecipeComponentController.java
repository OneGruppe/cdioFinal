package controller.controller_interface;

import java.util.List;

import data.dao_implementation.RecipeComponentDAO;
import data.dto.RecipeComponentDTO;
import exceptions.DALException;

public interface IRecipeComponentController {
	/**
	 * Creates Recipe component
	 * @param recipeComponentID
	 * @param recipeID
	 * @param commodityID
	 * @param non_netto
	 * @param tolerance
	 * @throws DALException
	 */
	public void createRecipeComponent(int recipeComponentID, int recipeID, int commodityID, double non_netto, double tolerance) throws DALException;
	
	/**
	 * Updates Recipe component
	 * @param recipeComponentID
	 * @param recipeID
	 * @param commodityID
	 * @param non_netto
	 * @param tolerance
	 * @throws DALException
	 */
	public void updateRecipeComponent(int recipeComponentID, int recipeID, int commodityID, double non_netto, double tolerance) throws DALException;
	
	/**
	 * Returns a single Recipe component
	 * @param recipeID
	 * @return a single RecipeComponentDTO object
	 * @throws DALException
	 */
	public RecipeComponentDTO getRecipeComponent(int recipeID) throws DALException;
	
	/**
	 * Returns a list of all Recipe components
	 * @return a list fo RecipeComponentDTO objects
	 * @throws DALException
	 */
	public List<RecipeComponentDTO> getAllRecipeComponent() throws DALException;
}
