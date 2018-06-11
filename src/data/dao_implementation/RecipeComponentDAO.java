package data.dao_implementation;

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
	public RecipeComponentDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		con = new Connector(server, port, database, username, password);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#createRecipeComponent(data.dto.RecipeComponentDTO)
	 */
	@Override
	public void createRecipeComponent(RecipeComponentDTO recipecomponent) throws DALException 
	{
		con.doUpdate("INSERT INTO recipeComponent (id, recipeID, commodityID, non_netto, tolerance) VALUES ("
				+ recipecomponent.getId() + ", "
				+ recipecomponent.getRecipeID() + ", "
				+ recipecomponent.getCommodityID() + ", "
				+ recipecomponent.getNonNetto() + ", "
				+ recipecomponent.getTolerance() + ")" );
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#updateRecipeComponent(data.dto.RecipeComponentDTO)
	 */
	@Override
	public void updateRecipeComponent(RecipeComponentDTO recipecomponent) throws DALException 
	{
		con.doUpdate("UPDATE recipeComponent SET "
				+ "recipeID=" + recipecomponent.getRecipeID() + ", "
				+ "commodityID=" + recipecomponent.getCommodityID() + ", "
				+ "non_netto=" + recipecomponent.getNonNetto() + ", "
				+ "tolerance=" + recipecomponent.getTolerance()
				+ "WHERE id=" + recipecomponent.getId());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#deleteRecipeComponent(int)
	 */
	@Override
	public void deleteRecipeComponent(int recipeComponentID) throws DALException 
	{
		con.doUpdate("DELETE FROM recipeComponent "
				+ "WHERE id=" + recipeComponentID);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#getRecipeComponent(int)
	 */
	@Override
	public List<RecipeComponentDTO> getRecipeComponent(int recipeID) throws DALException
	{
		List<RecipeComponentDTO> recipeComponentList = new ArrayList<RecipeComponentDTO>();
		ResultSet rs = con.doQuery("SELECT * FROM recipeComponent WHERE recipeID= " + recipeID);

		try {
			if(!rs.first()) 
			{
				throw new DALException("" + recipeID);
			}
			else
			{
				while(rs.next())
				{
					recipeComponentList.add(new RecipeComponentDTO(rs.getInt("id"), rs.getInt("recipeID"), rs.getInt("commodityID"), rs.getDouble("non_netto"), rs.getDouble("tolerance")));
				}
			}
			return recipeComponentList;
		}
		catch (SQLException e) 
		{
			throw new DALException("" + e.getMessage());
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
		ResultSet rs = con.doQuery("SELECT * FROM recipeComponent");

		try {
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
			}
			return recipeComponentList;
		}
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}


}
