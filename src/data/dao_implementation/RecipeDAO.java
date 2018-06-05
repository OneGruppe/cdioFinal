package data.dao_implementation;

import data.connector.Connector;
import data.dao_interface.IRecipeDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO implements IRecipeDAO 
{
	Connector con;

	public RecipeDAO() throws DALException 
	{
			con = new Connector();
	}

	@Override
	public void createRecipe(RecipeDTO recipe) throws DALException 
	{
		String RecipeQuery = "INSERT INTO recipe(recipeID, recipeName, nomNetto, tolerance) VALUES(" +recipe.getId()+ ", " +recipe.getName()+ ", " +recipe.getNetto()+ ", " +recipe.getTolerance()+ ")";
		con.doUpdate(RecipeQuery);
		
		for(int commodityID : recipe.getCommodityID())
		{
			con.doUpdate("INSERT INTO recipe_commodity VALUES(" +recipe.getId()+ ", " +commodityID+")");
		}
	}

	@Override
	public void updateRecipe(RecipeDTO recipe) throws DALException 
	{
		con.doUpdate("DELETE FROM recipe_commodity WHERE recipeID = " +recipe.getId());
		
		String RecipeQuery = "UPDATE recipe SET recipeName = '" +recipe.getName()+ "', "
				           + "nomNetto = " +recipe.getNetto()+ ", tolerance = " +recipe.getTolerance()
				           + "WHERE recipeID = " +recipe.getId();
		con.doUpdate(RecipeQuery);
		
		for(int commodityID : recipe.getCommodityID())
		{
			con.doUpdate("INSERT INTO recipe_commodity VALUES(" +recipe.getId()+ ", " +commodityID+")");
		}
	}

	@Override
	public void deleteRecipe(int recipeID) throws DALException 
	{
		String RecipeQuery = "DELETE FROM recipe WHERE recipeID= " + recipeID;
		con.doUpdate(RecipeQuery);
	}

	@Override
	public RecipeDTO getRecipe(int recipeID) throws DALException 
	{
		List<Integer> commodityList = new ArrayList<Integer>();
		double nomNetto = 0, tolerance = 0;
		String recipeName = null;
		ResultSet rs = con.doQuery("SELECT * FROM recipeView WHERE recipeID = " + recipeID);

		try
		{
			if(!rs.first()) 
			{
				throw new DALException("Recepten med ID " + recipeID + " findes ikke");
			}

			while(rs.next()) 
			{
				recipeName = rs.getString("recipeName");
				nomNetto = rs.getDouble("nomNetto");
				tolerance = rs.getDouble("tolerance");
				commodityList.add(rs.getInt("commodityID"));
			}
			return new RecipeDTO(recipeID, recipeName, commodityList, nomNetto, tolerance);
		}
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}

	@Override
	public List<RecipeDTO> getAllRecipes() throws DALException
	{
		List<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();
		String showAllRecipiesRecs = "SELECT * FROM recipe";
		String showAllRecipiesComs = "SELECT * FROM recipe_commodity";

		int recipeID = 0;
		String recipeName = null;
		double nonNetto = 0.0;
		double tolerance = 0.0;

		ResultSet rsRecs = con.doQuery(showAllRecipiesRecs);
		ResultSet rsComs = con.doQuery(showAllRecipiesComs);
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
					if (recipeDTO.getId() == rsComs.getInt("comodityID"))
					{
						if (recipeDTO.getCommodityID() == null)
						{
							List<Integer> exComList = new ArrayList<Integer>();
							int comList = rsComs.getInt("commodityID");
							exComList.add(comList);
							recipeDTO.setCommodityID(exComList);
						}else 
						{
							List<Integer> exComList = recipeDTO.getCommodityID();
							exComList.add(rsComs.getInt("commodityID"));
						}
					}
				}
			}
			return recipeList;

		} catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}

	}

}
