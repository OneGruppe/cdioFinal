package boundary.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import boundary.rest_interface.IRecipeREST;
import controller.controller.RecipeController;
import controller.controller_interface.IRecipeController;
import data.dto.RecipeDTO;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("recipe")
public class RecipeREST implements IRecipeREST {

	private IRecipeController rc;

	public RecipeREST()  
	{	
		try 
		{
			rc = new RecipeController();
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IRecipeREST#createRecipe(int, java.lang.String)
	 */
	@Override
	@POST
	@Path("createRecipe")
	public String createRecipe(@FormParam("id")int id,@FormParam("name") String name) throws DALException 
	{
		String message;

		try 
		{
			rc.createRecipe(id, name);
			message = "Recepten blev oprettet";
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
			message = "Recepten blev ikke oprettet pga. " + e.getMessage();
		}
		return message;
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IRecipeREST#getRecipe(int)
	 */
	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getRecipe")
	public String getRecipe(@FormParam("id")int id) throws DALException
	{
		String message;

		JSONObject recipeJSON = new JSONObject();
		RecipeDTO recipe;

		try 
		{
			if(id > 0) 
			{
				recipe = rc.getRecipe(id);

				recipeJSON.put("id", recipe.getId());
				recipeJSON.put("name", recipe.getName());
				message = "Recepten " + recipe.getName() + " blev fundet";
			}
			else 
			{
				message = "Fejl, der eksiterer ingen recepter med dette ID";
			}
		}
		catch(DALException e) 
		{
			message = e.getMessage();
		}
		System.out.println(message);
		return recipeJSON.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IRecipeREST#getAllRecipe()
	 */
	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllRecipes")
	public String getAllRecipe() throws DALException 
	{
		String message; 
		System.out.println("so far so good");
		JSONArray recList = new JSONArray();
		System.out.println("JSON made");
		try
		{
			recList.put(rc.getAllRecipes());
			message = "Alle recepterne er fundet";
		}
		catch(DALException e)
		{
			message = e.getMessage();
		}

		System.out.println(message);
		return recList.toString();
	}


}
