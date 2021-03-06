package controller.controller;

import java.util.List;

import controller.controller_interface.IRecipeComponentController;
import data.dao.RecipeComponentDAO;
import data.dao_interface.IRecipeComponentDAO;
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
	public void createRecipeComponent(int id, int recipeID, int commodityID, double non_netto, double tolerance) throws DALException 
	{
		RecipeComponentDTO component = new RecipeComponentDTO(id, recipeID, commodityID, non_netto, tolerance);
		dao.createRecipeComponent(component);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IRecipeComponentController#getRecipeComponent(int)
	 */
	@Override
	public List<RecipeComponentDTO> getRecipeComponent(int recipeID) throws DALException 
	{
		return dao.getRecipeComponent(recipeID);
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
