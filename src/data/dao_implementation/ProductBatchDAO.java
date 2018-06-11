package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IProductBatchDAO;
import data.dto.ProductBatchDTO;
import exceptions.DALException;

public class ProductBatchDAO implements IProductBatchDAO {

	private Connector con;

	/**
	 * Constructor that uses Constant-class to connect
	 * @throws DALException
	 */
	public ProductBatchDAO() throws DALException
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
	public ProductBatchDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		con = new Connector(server, port, database, username, password);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#createProductBatchComponent(data.dto.ProductBatchComponentDTO)
	 */
	@Override
	public void createProductBatchComponent(ProductBatchDTO productBatch) throws DALException 
	{
		con.doUpdate("INSERT INTO productBatch VALUES ("
				+ productBatch.getId() + ", "
				+ productBatch.getRecipeID() + ", "
				+ productBatch.getStatus() + ", "
				+ productBatch.getCommodityBatchID() + ", "
				+ productBatch.getUserID() + ", "
				+ productBatch.getTara() + ", "
				+ productBatch.getNonNetto() + ")" );
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#updateProductBatchComponent(data.dto.ProductBatchComponentDTO)
	 */
	@Override
	public void updateProductBatchComponent(ProductBatchDTO productBatch) throws DALException 
	{
		con.doUpdate("UPDATE productBatch SET "
				+ "recipeID= " + productBatch.getRecipeID() + ", "
				+ "status= " + productBatch.getStatus() + ", "
				+ "commodityBatchID=" + productBatch.getCommodityBatchID() + ", "
				+ "userID=" + productBatch.getUserID() + ", "
				+ "tara=" + productBatch.getTara() + ", "
				+ "netto=" + productBatch.getNonNetto() + " "
				+ "WHERE id=" + productBatch.getId() + " AND recipeID= " + productBatch.getRecipeID());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#updateProductBatchComponent(data.dto.ProductBatchComponentDTO)
	 */
	@Override
	public void deleteProductBatchComponent(int id) throws DALException 
	{
		con.doUpdate("DELETE FROM productBatch "
				+ "WHERE id=" + id);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#getProductBatchComponent(int)
	 */
	@Override
	public ProductBatchDTO getProductBatchComponent(int id) throws DALException 
	{
		ResultSet rs = con.doQuery("SELECT * FROM productBatch "
				+ "WHERE id= " + id);

		try {
			if(!rs.first()) 
			{
				throw new DALException("Produkt batch komponenten med productBatchID'et " + id + " findes ikke");
			} 
			else 
			{
				return new ProductBatchDTO(rs.getInt("id"), rs.getInt("recipeID"), rs.getInt("status"), rs.getInt("commodityBatchID"), rs.getInt("userID"), rs.getDouble("tara"), rs.getDouble("nonNetto"));
			}
		}
		catch(SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#getAllProductBatchComponents()
	 */
	@Override
	public List<ProductBatchDTO> getAllProductBatchComponents() throws DALException 
	{
		List<ProductBatchDTO> productBatchList = new ArrayList<ProductBatchDTO>();
		ResultSet rs = con.doQuery("SELECT * FROM productBatchComponent");

		try 
		{
			while(rs.next()) 
			{
				ProductBatchDTO dto = new ProductBatchDTO(rs.getInt("id"), rs.getInt("recipeID"), rs.getInt("status"), rs.getInt("commodityBatchID"), rs.getInt("userID"), rs.getDouble("tara"), rs.getDouble("nonNetto"));
				productBatchList.add(dto);

				if(dto.getId() == 0) 
				{
					throw new DALException("Produkt batch listen er tom");
				}
			}
			return productBatchList;
		}
		catch(SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}


}
