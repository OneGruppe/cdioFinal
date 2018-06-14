package data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IRecipeDAO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class RecipeDAO implements IRecipeDAO {
	
	private Connector con;
	
	/**
	 * Constructor that uses Constant-class connect
	 * @throws DALException
	 */
	public RecipeDAO() throws DALException
	{
		try 
		{
			con = new Connector();
		} 
		catch (DALException e) 
		{
			System.out.println("RecipeDAO error: " + e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
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
		try 
		{
			con = new Connector(server, port, database, username, password);
		} 
		catch (DALException e) 
		{
			System.out.println("RecipeDAO error: " + e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeDAO#createRecipe(data.dto.RecipeDTO)
	 */
	@Override
	public void createRecipe(RecipeDTO recipe) throws DALException
	{
		try {
			con.doUpdate("INSERT INTO recipe VALUES ("
					+ recipe.getId() + ", "
					+ "'" + recipe.getName() + "')");
		} catch (DALException e) {
			System.out.println("RecipeDAO error: " + e.getMessage());
			throw new DALException("Fejl i oprettelse til recept");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeDAO#getRecipe(int)
	 */
	@Override
	public RecipeDTO getRecipe(int id) throws DALException
	{
		try
		{
			ResultSet rs = con.doQuery("SELECT * FROM recipe WHERE id = " + id);

			if(!rs.first())
				throw new DALException("Recipe med ID " + id + "findes ikke");
			else
				return new RecipeDTO(id, rs.getString("name"));
		}
		catch (SQLException | DALException e)
		{
			System.out.println("RecipeDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af recept-listen");
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

		try
		{
			ResultSet rs = con.doQuery("SELECT * FROM recipe");
			
			while(rs.next())
			{
				RecipeDTO repdto = new RecipeDTO(rs.getInt("id"), rs.getString("name"));
				recipeList.add(repdto);
			}
			if(recipeList.isEmpty()) {
				throw new DALException("Recept listen er tom...\nTilføj nogle værdier og prøv igen");
			}
			return recipeList;
		} 
		catch (SQLException | DALException e)
		{
			System.out.println("RecipeDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af recept-listen");
		}
	}
}
