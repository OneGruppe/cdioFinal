package boundary.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

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
	
	@Override
	@PUT
	@Path("createRecipeComponent")
	public String createRecipeComponent(@FormParam("id")int id,@FormParam("recipeID") int recipeID,@FormParam("commodityID") int commodityID,@FormParam("nonNetto") double nonNetto,@FormParam("tolerance") double tolerance) throws DALException
	{
		String message;

		try 
		{
			rcc.createRecipeComponent(id, recipeID, commodityID, nonNetto, tolerance);
			message = "Recepten komponenten blev oprettet";
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
			message = "Recepten komponenten blev ikke oprettet pga. " + e.getMessage();
		}
		return message;	
	}

	@Override
	@PUT
	@Path("updateRecipeComponent")
	public void updateRecipeComponent(@FormParam("id")int id,@FormParam("recipeID") int recipeID,@FormParam("commodityID") int commodityID,@FormParam("nonNetto") double nonNetto,@FormParam("tolerance") double tolerance) throws DALException
	{
		try 
		{
			rcc.updateRecipeComponent(id, recipeID, commodityID, nonNetto, tolerance);
		} 
		catch (DALException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	@PUT
	@Path("getRecipeComponent")
	public String getRecipeComponent(@FormParam("recipeID")int recipeID) throws DALException 
	{
		JSONArray recComList = new JSONArray();

		try 
		{
			if(recipeID != 0)
			{
				recComList.put(rcc.getRecipeComponent(recipeID));
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
		return recComList.toString();
	}

	@Override
	@PUT
	@Path("getAllRecipeComponents")
	public String getAllRecipeComponents() throws DALException
	{
		String message; 
		JSONArray recList = new JSONArray();
		try
		{
			recList.put(rcc.getAllRecipeComponent());
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
