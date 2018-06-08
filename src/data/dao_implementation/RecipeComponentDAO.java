package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IRecipeComponentDAO;
import data.dto.CommodityDTO;
import data.dto.RecipeComponentDTO;
import exceptions.DALException;

public class RecipeComponentDAO implements IRecipeComponentDAO {
	private Connector con;

	/**
	 * Constructor that uses Constant-class 
	 * @throws DALException
	 */
	public RecipeComponentDAO() throws DALException{
		con = new Connector();
	}

	/**
	 * Constructor that uses the parameters from 
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
	public void createRecipeComponent(RecipeComponentDTO component) throws DALException {
		con.doQuery("INSERT INTO recipeComponent(recipeID, commodityID, non_netto, tolerance) VALUES ("
				+ component.getRecipeID() + ", " + component.getCommodityList() + ", "
				+ component.getNon_netto() + ", " + component.getTolerance() + ")" );
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#updateRecipeComponent(data.dto.RecipeComponentDTO)
	 */
	@Override
	public void updateRecipeComponent(RecipeComponentDTO component) throws DALException {
		con.doUpdate("UPDATE recipeComponent SET commodityID= " + component.getCommodityList() + ", " 
				+ "non_netto= " + component.getNon_netto() + ", "
				+ "tolerance= " + component.getTolerance()
				+ "WHERE recipeID= " + component.getRecipeID());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#deleteRecipeComponent(int)
	 */
	@Override
	public void deleteRecipeComponent(int componentID) throws DALException {
		con.doUpdate("DELETE FROM recipeComponent WHERE recipeID= " + componentID);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#getRecipeComponent(int)
	 */
	@Override
	public RecipeComponentDTO getRecipeComponent(int recipeComponentID) throws DALException
	{

		ResultSet rs = con.doQuery("SELECT * FROM recipeComponent WHERE recipeComponentID= " + recipeComponentID);

		List<CommodityDTO> rCompList = new ArrayList<CommodityDTO>();

		try {
			if(!rs.first()) {
				throw new DALException("" + recipeComponentID);
			}
			else
			{
				recipeID = rs.getInt("recipeID");
				non_netto = rs.getDouble("non_netto");
				tolerance = rs.getDouble("tolerance");
				
			}
				while(rs.next())
				{
					
				}
			return new RecipeComponentDTO(recipeID, rCompList, rs.getDouble("non_netto"), rs.getDouble("tolerance"));
		}
		catch (SQLException e) {
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

		ResultSet rs = con.doQuery("SELECT * FROM recipeComponent");

		try {
			while(rs.next())
			{
				RecipeComponentDTO dto = new RecipeComponentDTO(rs.getInt("recipeID"), rs.getInt("commodityID"), rs.getDouble("non_netto"), rs.getDouble("tolerace"));
				recipeComponentList.add(dto);

				if(dto.getRecipeID() == 0)
				{
					throw new DALException("Recipe komponent listen er tom");
				}
			}
		}
		catch(SQLException e) {
			throw new DALException(e.getMessage());
		}
		return recipeComponentList;
	}



}
