package controller.controller_interface;

import java.util.List;

import data.dao_implementation.RecipeComponentDAO;
import data.dto.RecipeComponentCommodityDTO;
import data.dto.RecipeComponentDTO;
import exceptions.DALException;

public interface IRecipeComponentController {

	/**
	 * Creates Recipe component
	 * @param recipeID
	 * @param componentCommodityList
	 * @throws DALException
	 */
	public void createRecipeComponent(int recipeID, List<RecipeComponentCommodityDTO> componentCommodityList) throws DALException;

	/**
	 * Updates Recipe component
	 * @param recipeID
	 * @param componentCommodityList
	 * @throws DALException
	 */
	public void updateRecipeComponent(int recipeID, List<RecipeComponentCommodityDTO> componentCommodityList) throws DALException;

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
