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

import boundary.rest_interface.IRecipeComponentREST;
import controller.controller.RecipeComponentController;
import controller.controller_interface.IRecipeComponentController;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("recipeComponent")
public class RecipeComponentREST implements IRecipeComponentREST {
	private IRecipeComponentController rcc;

	public RecipeComponentREST() 
	{
		try
		{
			rcc = new RecipeComponentController();
		}
		catch (DALException e)
		{
			System.out.println(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IRecipeComponentREST#createRecipeComponent(int, int, int, double, double)
	 */
	@Override
	@POST
	@Path("createRecipeComponent")
	public String createRecipeComponent(@FormParam("id")int id,@FormParam("recipeID") int recipeID,@FormParam("commodityID") int commodityID,@FormParam("nonNetto") double nonNetto,@FormParam("tolerance") double tolerance) throws DALException
	{
		JSONObject returnMessage = new JSONObject();
		
		try 
		{
			rcc.createRecipeComponent(id, recipeID, commodityID, nonNetto, tolerance);
			returnMessage.put("message", "Recepten komponenten blev oprettet");
			return returnMessage.toString();
		} 
		catch (DALException e) 
		{
			returnMessage.put("message", "Recepten komponenten blev ikke oprettet pga. " + e.getMessage());
			return returnMessage.toString();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IRecipeComponentREST#getRecipeComponent(int)
	 */
	@Override
	@POST
	@Path("getRecipeComponent")
	public String getRecipeComponent(@FormParam("recipeID")int recipeID) throws DALException 
	{
		JSONArray recComList = new JSONArray();

		try
		{
			recComList.put(rcc.getRecipeComponent(recipeID));
			return recComList.toString();
		}
		catch(DALException e)
		{
			return e.getMessage();
		}		
	}

	/*
	 * (non-Javadoc)
	 * @see boundary.rest_interface.IRecipeComponentREST#getAllRecipeComponents()
	 */
	@Override
	@GET
	@Path("getAllRecipeComponents")
	public String getAllRecipeComponents() throws DALException
	{
		JSONArray recList = new JSONArray();
		try
		{
			recList.put(rcc.getAllRecipeComponent());
			return recList.toString();
		}
		catch(DALException e)
		{
			return e.getMessage();
		}
	}

}
