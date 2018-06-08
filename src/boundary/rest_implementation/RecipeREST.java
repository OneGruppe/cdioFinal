package boundary.rest_implementation;

import java.util.List;

import boundary.rest_interface.IRecipeREST;
import controller.controller_implementation.RecipeController;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeREST implements IRecipeREST {
	
	private RecipeController rc;
	
	public RecipeREST() throws DALException {
		rc = new RecipeController();
	}

	@Override
	public void createRecipe(int id, String name) throws DALException 
	{
		rc.createRecipe(id, name);
	}

	@Override
	public void updateRecipe(int id, String name) throws DALException 
	{
		rc.updateRecipe(id, name);
	}

	@Override
	public void deleteRecipe(int id) throws DALException
	{
		rc.deleteRecipe(id);
	}

	@Override
	public RecipeDTO getRecipe(int id) throws DALException 
	{
		RecipeDTO rec;
		rec = rc.getRecipe(id);
		return rec;
	}

	@Override
	public List<RecipeDTO> getAllRecipe() throws DALException 
	{
		List<RecipeDTO> recs;
		recs = rc.getAllRecipes();
		return recs;
	}

}
