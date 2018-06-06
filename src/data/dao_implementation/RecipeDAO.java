package data.dao_implementation;

import data.connector.Connector;
import data.dao_interface.IRecipeDAO;
import data.dto.CommodityBatchDTO;
import data.dto.RecipeDTO;
import exceptions.DALException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO implements IRecipeDAO 
{
	private Connector con;
	
	public RecipeDAO() throws DALException 
	{
		con = new Connector();
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeDAO#createRecipe(data.dto.RecipeDTO)
	 */
	@Override
	public void createRecipe(RecipeDTO recipe) throws DALException 
	{
		con.doUpdate("INSERT INTO recipe(recipeID, recipeName) VALUES(" +recipe.getId() + ", " + recipe.getName() +")");
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeDAO#updateRecipe(data.dto.RecipeDTO)
	 */
	@Override
	public void updateRecipe(RecipeDTO recipe) throws DALException 
	{
		con.doUpdate("UPDATE recipe SET recipeName = '" + recipe.getName() + " WHERE recipeID= " + recipe.getId());
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeDAO#deleteRecipe(int)
	 */
	@Override
	public void deleteRecipe(int recipeID) throws DALException 
	{
		con.doUpdate("DELETE FROM recipe WHERE recipeID= " + recipeID);
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeDAO#getRecipe(int)
	 */
	@Override
	public RecipeDTO getRecipe(int recipeID) throws DALException 
	{
		RecipeDTO dto = null;

		ResultSet rs = con.doQuery("SELECT * FROM recipeView WHERE recipeID= " + recipeID);

		try
		{
			if (!rs.first())
			{
				throw new DALException("Recipe med ID " + recipeID + " findes ikke.");
			}
			else
			{
				dto = new RecipeDTO(recipeID, rs.getString("recipeName"));
			}
			return new RecipeDTO(recipeID, rs.getString("recipeName"));
		}
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeDAO#getAllRecipes()
	 */
	@Override
	public List<RecipeDTO> getAllRecipes() throws DALException
	{
		List<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();

		ResultSet rs = con.doQuery("SELECT * FROM recipe");

		try
		{
			while(rs.next())
			{
				RecipeDTO dto = new RecipeDTO(rs.getInt("recipeID"), rs.getString("recipeName"));
				recipeList.add(dto);
				
				if (dto.getId() == 0) {
					throw new DALException("Receptlisten er tom");
				}
			}
		}
		catch(SQLException e) {
			throw new DALException(e.getMessage());
		}
		return recipeList;
	}
}
