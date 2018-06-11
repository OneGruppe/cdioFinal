package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IRecipeComponentDAO;
import data.dto.RecipeComponentCommodityDTO;
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
	public void createRecipeComponent(RecipeComponentDTO component) throws DALException 
	{
		for(RecipeComponentCommodityDTO recepcom : component.getComponentCommodityList())
		{
			con.doUpdate("INSERT INTO recipeComponent (recipeID, commodityID, non_netto, tolerance) VALUES ("
					+ component.getRecipeID() + ", "
					+ recepcom.getCommodityID() + ", "
					+ recepcom.getNon_netto() + ", "
					+ recepcom.getTolerance() + ")" );
		}

	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#updateRecipeComponent(data.dto.RecipeComponentDTO)
	 */
	@Override
	public void updateRecipeComponent(RecipeComponentDTO component) throws DALException 
	{
		con.doQuery("DELETE FROM recipeComponent WHERE recipeID=" + component.getRecipeID());

		for(RecipeComponentCommodityDTO recepcom : component.getComponentCommodityList())
		{
			con.doUpdate("INSERT INTO recipeComponent (recipeID, commodityID, non_netto, tolerance) VALUES ("
					+ component.getRecipeID() + ", "
					+ recepcom.getCommodityID() + ", "
					+ recepcom.getNon_netto() + ", "
					+ recepcom.getTolerance() + ")" );
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#deleteRecipeComponent(int)
	 */
	@Override
	public void deleteRecipeComponent(int recipeID) throws DALException 
	{
		con.doUpdate("DELETE FROM recipeComponent "
				+ "WHERE recipeID= " + recipeID);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#getRecipeComponent(int)
	 */
	@Override
	public RecipeComponentDTO getRecipeComponent(int recipeID) throws DALException
	{
		ResultSet rs = con.doQuery("SELECT * FROM recipeComponent WHERE recipeID= " + recipeID);
		List<RecipeComponentCommodityDTO> componentCommodityList = new ArrayList<RecipeComponentCommodityDTO>();

		try {
			if(!rs.first()) 
			{
				throw new DALException("" + recipeID);
			}
			else
			{
				while(rs.next())
				{
					componentCommodityList.add(new RecipeComponentCommodityDTO(rs.getInt("commodityID"), rs.getDouble("non_netto"), rs.getDouble("tolerance")));
				}
			}
			return new RecipeComponentDTO(recipeID, componentCommodityList);
		}
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
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
		List<RecipeComponentCommodityDTO> emptyList = new ArrayList<RecipeComponentCommodityDTO>();

		ResultSet rsRecipe = con.doQuery("SELECT * FROM recipe");

		try {
			while(rsRecipe.next())
			{
				RecipeComponentDTO recipeDTO = new RecipeComponentDTO(rsRecipe.getInt("recipeID"), emptyList);
				recipeComponentList.add(recipeDTO);
			}
			if(recipeComponentList.isEmpty())
			{
				throw new DALException("Recipe component-list is empty: ");
			}

			ResultSet rsRecipeCom = con.doQuery("SELECT * FROM recipeComponent");

			while (rsRecipeCom.next())
			{
				for (RecipeComponentDTO receptcom : recipeComponentList)
				{
					if (receptcom.getRecipeID() == rsRecipeCom.getInt("recipeID"))
					{
						List<RecipeComponentCommodityDTO> comList = receptcom.getComponentCommodityList();
						comList.add(new RecipeComponentCommodityDTO(rsRecipeCom.getInt("recipeID"), rsRecipeCom.getDouble("non_netto"), rsRecipeCom.getDouble("tolerance")))
						;
					}
				}
				
			}


			return recipeComponentList;
		}
		catch(SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}


}
