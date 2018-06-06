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
		con.doUpdate("INSERT INTO recipe VALUES(" + recipe.getId() + ", " + recipe.getName() + ", " + recipe.getNonNetto() + ", " + recipe.getTolerance() + ")");

		for(int commodityID : recipe.getCommodityList())
		{
			con.doUpdate("INSERT INTO recipe_commodity VALUES(" + recipe.getId() + ", " + commodityID + ")");
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeDAO#updateRecipe(data.dto.RecipeDTO)
	 */
	@Override
	public void updateRecipe(RecipeDTO recipe) throws DALException 
	{
		con.doUpdate("DELETE FROM recipe_commodity WHERE recipeID = " + recipe.getId());
		con.doUpdate("UPDATE recipe SET recipeName = '" + recipe.getName() + "', nomNetto = " + recipe.getNonNetto() + ", tolerance = " + recipe.getTolerance() + "WHERE recipeID = " + recipe.getId());

		for(int commodityID : recipe.getCommodityList())
		{
			con.doUpdate("INSERT INTO recipe_commodity VALUES(" + recipe.getId() + ", " + commodityID + ")");
		}
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
		List<Integer> commodityList = new ArrayList<Integer>();
		double nomNetto = 0, tolerance = 0;
		String recipeName = null;

		ResultSet rs = con.doQuery("SELECT * FROM recipeView WHERE recipeID = " + recipeID);

		try
		{
			if (!rs.first())
			{
				throw new DALException("Recipe med ID " + recipeID + " findes ikke");
			}
			else
			{
				recipeName = rs.getString("recipeName");
				nomNetto = rs.getDouble("nomNetto");
				tolerance = rs.getDouble("tolerance");
				commodityList.add(rs.getInt("commodityID"));
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

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeDAO#getAllRecipes()
	 */
	@Override
	public List<RecipeDTO> getAllRecipes() throws DALException
	{
		List<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();

		ResultSet rsRecs = con.doQuery("SELECT * FROM recipe");
		ResultSet rsComs = con.doQuery("SELECT * FROM recipe_commodity");

		try
		{
			while(rsRecs.next())
			{
				RecipeDTO recipeDTO = new RecipeDTO(rsRecs.getInt("recipeID"), rsRecs.getString("recipeName"), null, rsRecs.getDouble("nomNetto"), rsRecs.getDouble("tolerance"));
				recipeList.add(recipeDTO);
				if (recipeDTO.getId() == 0) {throw new DALException("Receptlisten er tom");}
			}
			while (rsComs.next())
			{
				for (RecipeDTO recipeDTO : recipeList)
				{
					if (recipeDTO.getId() == rsComs.getInt("comodityID"))
					{
						if (recipeDTO.getCommodityList() == null)
						{
							List<Integer> exComList = new ArrayList<Integer>();
							int comList = rsComs.getInt("commodityID");
							exComList.add(comList);
							recipeDTO.setCommodityList(exComList);
						}
						else 
						{
							List<Integer> exComList = recipeDTO.getCommodityList();
							exComList.add(rsComs.getInt("commodityID"));
						}
					}
				}
			}
			return recipeList;

		} 
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}


}
