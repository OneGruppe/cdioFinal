package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.IRecipeComponentController;
import data.dao_implementation.RecipeComponentDAO;
import data.dao_interface.IRecipeComponentDAO;
import data.dto.RecipeComponentCommodityDTO;
import data.dto.RecipeComponentDTO;
import exceptions.DALException;

public class RecipeComponentController implements IRecipeComponentController {

	private IRecipeComponentDAO dao;

	public RecipeComponentController() throws DALException 
	{
		dao = new RecipeComponentDAO();
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeComponentController#createRecipeComponent(int, int, double, double)
	 */
	@Override
	public void createRecipeComponent(int recipeID, List<RecipeComponentCommodityDTO> componentCommodityList) throws DALException 
	{
		RecipeComponentDTO component = new RecipeComponentDTO(recipeID, componentCommodityList);
		dao.createRecipeComponent(component);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeComponentController#updateRecipeComponent(int, int, double, double)
	 */
	@Override
	public void updateRecipeComponent(int recipeID, List<RecipeComponentCommodityDTO> componentCommodityList)	throws DALException 
	{
		RecipeComponentDTO component = new RecipeComponentDTO(recipeID, componentCommodityList);
		dao.updateRecipeComponent(component);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeComponentController#getRecipeComponent(int)
	 */
	@Override
	public RecipeComponentDTO getRecipeComponent(int recipeID) throws DALException 
	{
		RecipeComponentDTO component = dao.getRecipeComponent(recipeID);
		return component;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeComponentController#getAllRecipeComponent()
	 */
	@Override
	public List<RecipeComponentDTO> getAllRecipeComponent() throws DALException 
	{
		List<RecipeComponentDTO> componentList = dao.getAllRecipeComponents();
		return componentList;
	}


}
