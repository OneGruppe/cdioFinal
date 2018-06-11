package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IRecipeDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeDAO implements IRecipeDAO
{
	private Connector con;
	/**
	 * Constructor that uses Constant-class connect
	 * @throws DALException
	 */
	public RecipeDAO() throws DALException
	{
		con = new Connector();
	}

	/**
	 * Constructor that uses the parameters
	 * @param server
	 * @param port
	 * @param database
	 * @param username
	 * @param password
	 * @throws DALException
	 */
	public RecipeDAO(String server, int port, String database, String username, String password) throws DALException
	{
		con = new Connector(server, port, database, username, password);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeDAO#createRecipe(data.dto.RecipeDTO)
	 */
	@Override
	public void createRecipe(RecipeDTO recipe) throws DALException
	{
		con.doUpdate("INSERT INTO recipe VALUES ("
				+ recipe.getId() + ", "
				+ "'" + recipe.getName() + "')");
	}

	@Override
	public void updateRecipe(RecipeDTO recipe) throws DALException
	{
		con.doUpdate("UPDATE recipe SET " 
				+ "name='" + recipe.getName() +"' "
				+ "WHERE id=" + recipe.getId());
	}

	@Override
	public void deleteRecipe(int id) throws DALException
	{
		con.doUpdate("DELETE FROM recipe "
				+ "WHERE id = " + id);
	}

	@Override
	public RecipeDTO getRecipe(int id) throws DALException
	{
		ResultSet rs = con.doQuery("SELECT * FROM recipe "
				+ "WHERE id = " + id);

		try
		{
			if(!rs.first())
				throw new DALException("Recipe med ID " + id + "findes ikke");
			else
				return new RecipeDTO(id, rs.getString("name"));
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
		ResultSet rs = con.doQuery("SELECT * FROM recipe");

		try
		{
			while(rs.next())
			{
				RecipeDTO repdto = new RecipeDTO(rs.getInt("id"), rs.getString("name"));
				recipeList.add(repdto);

				if (repdto.getId() == 0) 
				{
					throw new DALException("Leverandorlisten er tom");
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
