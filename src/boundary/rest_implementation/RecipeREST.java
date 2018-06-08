package boundary.rest_implementation;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import boundary.rest_interface.IRecipeREST;
import controller.controller_implementation.RecipeController;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeREST implements IRecipeREST {
	
	private RecipeController rc;
	
	public RecipeREST()  
	{	
		try {
			
			rc = new RecipeController();
			
		} catch (DALException e) {
			
			System.out.println(e.getMessage());
		}
	}

	@Override
	@PUT
	@Path("createRecipe")
	public void createRecipe(int id, String name) throws DALException 
	{
		rc.createRecipe(id, name);
	}

	@Override
	@POST
	@Path("updateRecipe")
	public void updateRecipe(int id, String name) throws DALException 
	{
		rc.updateRecipe(id, name);
	}

	@Override
	@DELETE
	@Path("deleteRecipe")
	public void deleteRecipe(int id) throws DALException
	{
		rc.deleteRecipe(id);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getRecipe")
	public RecipeDTO getRecipe(int id) throws DALException 
	{
		RecipeDTO rec;
		rec = rc.getRecipe(id);
		return rec;
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllRecipes")
	public List<RecipeDTO> getAllRecipe() throws DALException 
	{
		List<RecipeDTO> recs;
		recs = rc.getAllRecipes();
		return recs;
	}

}
