package data.dao_implementation;

import data.connector.Connector;
import data.dao_interface.IRecipeDAO;
import data.dto.RecipeDTO;

import exceptions.DALException;
import java.sql.SQLException;
import java.util.List;

public class RecipeDAO implements IRecipeDAO {
	Connector connector;
	
	public RecipeDAO() {
		try {
			connector = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createRecipe(RecipeDTO recipe) throws DALException 
	{
		String RecipeQuery = "INSERT INTO recipe (recipeID, recipeName, commodityID, nomNetto, tolerance) "  
							 + "VALUES(" +recipe.getRecipeID() +", '" +recipe.getRecipeName() +"', ";
		connector.doQuery(RecipeQuery);
	}

	@Override
	public void updateRecipe(RecipeDTO recipe) throws DALException 
	{
		connector.doUpdate("UPDATE recipe SET recipeName= '" +recipe.getRecipeName() +"' commodityID, nomNetto, tolerance)";
		connector.doQuery(RecipeQuery);
	}

	@Override
	public void deleteRecipe(int recipeID) throws DALException 
	{
		String RecipeQuery = "DELETE FROM recipe WHERE" +recipeID;
		connector.doQuery(RecipeQuery);
	}

	@Override
	public RecipeDTO showRecipe(int recipeID) throws DALException {
		return null;
	}

	@Override
	public List<RecipeDTO> showAllRecipes() throws DALException {
		return null;
	}

}
