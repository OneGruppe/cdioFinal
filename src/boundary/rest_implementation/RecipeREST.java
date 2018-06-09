package boundary.rest_implementation;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import boundary.rest_interface.IRecipeREST;
import controller.controller_implementation.RecipeController;
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
		try {

			rc = new RecipeController();

		} catch (DALException e) {

			System.out.println(e.getMessage());
		}
	}

	@Override
	@PUT
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

	@Override
	@POST
	@Path("updateRecipe")
	public void updateRecipe(@FormParam("id")int id,@FormParam("name") String name) throws DALException 
	{
		System.out.println(id +" "+name);
		try 
		{
			rc.updateRecipe(id, name);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}

	}

	@Override
	@DELETE
	@Path("deleteRecipe")
	public void deleteRecipe(@FormParam("id")int id) throws DALException
	{
		try 
		{
			rc.deleteRecipe(id);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getRecipe")
	public String getRecipe(@FormParam("id")int id) throws DALException 
	{

		JSONObject recJSON = new JSONObject();
		RecipeDTO rec;

		try 
		{

			if(id != 0)
			{
				rec = rc.getRecipe(id);

				recJSON.put("recipeID", rec.getRecipeID());
				recJSON.put("recipeName", rec.getRecipeName());
			}
			else
			{
				System.out.println("FEJL i ID input");
			}
		}
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
		}

		return recJSON.toString();
	}

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
