package data.dao_implementation;

import data.connector.Connector;
import data.dao_interface.IRecipeDAO;
import data.dto.RecipeDTO;
import data.dto.UserDTO;
import exceptions.DALException;

import java.sql.ResultSet;
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
		String RecipeQuery = "CALL createRecipe (" + recipe.getRecipeID() + recipe.getRecipeName() + recipe.getCommodityID() + recipe.getNomNetto() + recipe.getNomNetto() + ")";
		connector.doQuery(RecipeQuery);
	}

	@Override
	public void updateRecipe(RecipeDTO recipe) throws DALException 
	{
		String recipeQuery = "CALL recipeUpdate (" + recipe.getRecipeID() + recipe.getRecipeName() + recipe.getCommodityID() + recipe.getNomNetto() + recipe.getNomNetto() + ")";
		connector.doUpdate(recipeQuery);
	}

	@Override
	public void deleteRecipe(int recipeID) throws DALException 
	{
		String RecipeQuery = "DELETE FROM recipe WHERE recipeID= " + recipeID;
		connector.doUpdate(RecipeQuery);
	}

	@Override
	public RecipeDTO showRecipe(int recipeID) throws DALException {
		ResultSet rs = connector.doQuery("SELECT * FROM recipe WHERE recipeID = " + recipeID);
		
		try 
		{
			if(!rs.first()) 
			{
				throw new DALException("Recepten med ID " +recipeID+ " findes ikke");
			}
			
			return new RecipeDTO(rs.getInt("recipeID"), rs.getString("recipeName"), rs.getInt("commodityID"), rs.getDouble("nomNetto"), rs.getDouble("tolerance"));
		} 
		catch (SQLException e) {throw new DALException(e.getMessage());}
	}

	@Override
	public List<RecipeDTO> showAllRecipes() throws DALException {
		return null;
	}

}
