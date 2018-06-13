package data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IRecipeComponentDAO;
import data.dto.RecipeComponentDTO;
import exceptions.DALException;

public class RecipeComponentDAO implements IRecipeComponentDAO {

	private Connector con;

	/**
	 * Constructor that uses Constant-class to connect
	 * @throws DALException
	 */
	public RecipeComponentDAO() throws DALException
	{
		try 
		{
			con = new Connector();
		} 
		catch (DALException e) 
		{
			System.out.println("RecipeComponentDAO error: " + e.getMessage());
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
	public RecipeComponentDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		try 
		{
			con = new Connector(server, port, database, username, password);
		} 
		catch (DALException e) 
		{
			System.out.println("RecipeComponentDAO error: " + e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#createRecipeComponent(data.dto.RecipeComponentDTO)
	 */
	@Override
	public void createRecipeComponent(RecipeComponentDTO recipecomponent) throws DALException
	{
		try {
			con.doUpdate("INSERT INTO recipeComponent (id, recipeID, commodityID, non_netto, tolerance) VALUES ("
					+ recipecomponent.getId() + ", "
					+ recipecomponent.getRecipeID() + ", "
					+ recipecomponent.getCommodityID() + ", "
					+ recipecomponent.getNonNetto() + ", "
					+ recipecomponent.getTolerance() + ")" );
		} catch (DALException e) 
		{
			System.out.println("RecipeComponentDAO error: " + e.getMessage());
			throw new DALException("Fejl i oprettelse til receptkomponent");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#getRecipeComponent(int)
	 */
	@Override
	public List<RecipeComponentDTO> getRecipeComponent(int recipeID) throws DALException
	{
		List<RecipeComponentDTO> recipeComponentList = new ArrayList<RecipeComponentDTO>();

		try 
		{
			ResultSet rs = con.doQuery("SELECT * FROM recipeComponent WHERE recipeID= " + recipeID);

			while(rs.next())
			{
				recipeComponentList.add(new RecipeComponentDTO(rs.getInt("id"), rs.getInt("recipeID"), rs.getInt("commodityID"), rs.getDouble("non_netto"), rs.getDouble("tolerance")));
			}
			if(recipeComponentList.isEmpty())
			{
				throw new DALException("Recept komponent listen er tom...\nTilføj nogle værdier og prøv igen");
			}

			return recipeComponentList;
		}
		catch (SQLException | DALException e) 
		{
			System.out.println("RecipeComponentDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af receptkomponent-listen");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#getAllRecipeComponents()
	 */
	@Override
	public List<RecipeComponentDTO> getAllRecipeComponents() throws DALException
	{
		List<RecipeComponentDTO> recipeComponentList = new ArrayList<RecipeComponentDTO>();

		try 
		{
			ResultSet rs = con.doQuery("SELECT * FROM recipeComponent");

			if(!rs.first()) 
			{
				throw new DALException("there is no recipecomponents");
			}
			else
			{
				while(rs.next())
				{
					recipeComponentList.add(new RecipeComponentDTO(rs.getInt("id"), rs.getInt("recipeID"), rs.getInt("commodityID"), rs.getDouble("non_netto"), rs.getDouble("tolerance")));
				}
				if(recipeComponentList.isEmpty()) 
				{
					throw new DALException("Recept komponent listen er tom...\nTilføj nogle værdier og prøv igen");
				}
			}
			return recipeComponentList;
		}
		catch (SQLException | DALException e) 
		{
			System.out.println("RecipeComponentDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af receptkomponent-listen");
		}
	}


}
