package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IRecipeComponentDAO;
import data.dto.RecipeComponentDTO;
import exceptions.DALException;

public class RecipeComponentDAO implements IRecipeComponentDAO {
	private Connector con;

	public RecipeComponentDAO() throws DALException{
		con = new Connector();
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#createRecipeComponent(data.dto.RecipeComponentDTO)
	 */
	@Override
	public void createRecipeComponent(RecipeComponentDTO component) throws DALException {
		con.doQuery("INSERT INTO recipeComponent(recipeID, commodityID, non_netto, tolerance) VALUES ("
				+ component.getRecipeID() + ", " + component.getCommodityID() + ", "
				+ component.getNon_netto() + ", " + component.getTolerance() + ")" );
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IRecipeComponentDAO#updateRecipeComponent(data.dto.RecipeComponentDTO)
	 */
	@Override
	public void updateRecipeComponent(RecipeComponentDTO component) throws DALException {
		con.doUpdate("UPDATE recipeComponent SET commodityID= " + component.getCommodityID() + ", " 
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
	public List<RecipeComponentDTO> getRecipeComponent(int recipeID) throws DALException
	{

		ResultSet rs = con.doQuery("SELECT * FROM recipeComponent WHERE recipeID= " + recipeID);

		List<RecipeComponentDTO> rCompList = null;

		try {
			if(!rs.first()) {
				throw new DALException("Recipe komponent med recipeID " + recipeID + " findes ikke.");
			}
			else
			{
				while(rs.next())
				{
					rCompList.add(new RecipeComponentDTO(recipeID, rs.getInt("commodityID"), rs.getDouble("non_netto"), rs.getDouble("tolerance")));					
				}
			}
			return rCompList;
		} catch (SQLException e) {
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
		List<RecipeComponentDTO> recipeComponentList = null;

		ResultSet rs = con.doQuery("SELECT * FROM recipeComponent");

		try {
			while(rs.next())
			{
				RecipeComponentDTO dto = new RecipeComponentDTO(rs.getInt("recipeID"), rs.getInt("commodityID"), rs.getDouble("non_netto"), rs.getDouble("tolerace"));
				recipeComponentList.add(dto);

				if(dto.getRecipeID() == 0)
				{
					throw new DALException("Recipe komponenten listen er tom");
				}
			}
		}
		catch(SQLException e) {
			throw new DALException(e.getMessage());
		}
		return recipeComponentList;
	}



}
