package data.dao_implementation;

import data.connector.Connector;
import data.dao_interface.IRecipeDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		List<Integer> commodityList = new ArrayList<Integer>();
		double nomNetto = 0, tolerance = 0;
		String recipeName = null;
		ResultSet rs = connector.doQuery("SELECT * FROM recipeView WHERE recipeID = " + recipeID);

		try
		{
			if(!rs.first()) 
			{
				throw new DALException("Recepten med ID " + recipeID + " findes ikke");
			}

			while(rs.next()) {
				recipeName = rs.getString("recipeName");
				nomNetto = rs.getDouble("nomNetto");
				tolerance = rs.getDouble("tolerance");
				commodityList.add(rs.getInt("commodityID"));
			}
			return new RecipeDTO(recipeID, recipeName, commodityList, nomNetto, tolerance);
		}
		catch (SQLException e) {
			throw new DALException();
		}
	}

	@Override
	public List<RecipeDTO> showAllRecipes() throws DALException
	{
		List<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();
		String showAllRecipiesRecs = "SELECT * FROM recipe";
		String showAllRecipiesComs = "SELECT * FROM recipe_commodity";
		
		int recipeID = 0;
		String recipeName = null;
		double nonNetto = 0.0;
		double tolerance = 0.0;
		
		ResultSet rsRecs = connector.doQuery(showAllRecipiesRecs);
		ResultSet rsComs = connector.doQuery(showAllRecipiesComs);
		try
		{
			while(rsRecs.next())
			{
				recipeID = rsRecs.getInt("recipeID");
				recipeName = rsRecs.getString("recipeName");
				nonNetto = rsRecs.getDouble("nomNetto");
				tolerance = rsRecs.getDouble("tolerance");
				
				RecipeDTO recipeDTO = new RecipeDTO(recipeID, recipeName, null, nonNetto, tolerance);
				recipeList.add(recipeDTO);
			}
			while (rsComs.next())
			{
				for (RecipeDTO recipeDTO : recipeList)
				{
					if (recipeDTO.getRecipeID() == rsComs.getInt("comodityID"))
					{
						if (recipeDTO.getCommodityID() == null)
						{
							List<Integer> exComList = new ArrayList<Integer>();
							int comList = rsComs.getInt("commodityID");
							exComList.add(comList);
							recipeDTO.setCommodityID(exComList);
						}else {
							List<Integer> exComList = recipeDTO.getCommodityID();
							exComList.add(rsComs.getInt("commodityID"));
						}
					}
				}
			}
			return recipeList;
			
		} catch (SQLException e) {
			throw new DALException("SQLException in getUserList(): " + e.getMessage());
		}
		
		
	}

}
