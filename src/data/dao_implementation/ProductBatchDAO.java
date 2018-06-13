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
	public void createProductBatch(ProductBatchDTO productBatch) throws DALException 
	{
		con.doUpdate("INSERT INTO productBatch VALUES ("
				+ productBatch.getId() + ", "
				+ productBatch.getRecipeID() + ", "
				+ productBatch.getStatus() + ")" );
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#updateProductBatchComponent(data.dto.ProductBatchComponentDTO)
	 */
	@Override
	public void updateProductBatch(ProductBatchDTO productBatch) throws DALException 
	{
		con.doUpdate("UPDATE productBatch SET "
				+ "recipeID= " + productBatch.getRecipeID() + ", "
				+ "status= " + productBatch.getStatus() + " "
				+ "WHERE id=" + productBatch.getId());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#getProductBatchComponent(int)
	 */
	@Override
	public ProductBatchDTO getProductBatch(int id) throws DALException 
	{
		ResultSet rs = con.doQuery("SELECT * FROM productBatch "
				+ "WHERE id= " + id);

		try {
			if(!rs.first()) 
			{
				throw new DALException("Produkt batch med productBatchID'et " + id + " findes ikke");
			} 
			else 
			{
				return new ProductBatchDTO(rs.getInt("id"), rs.getInt("recipeID"), rs.getInt("status"));
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
	public List<ProductBatchDTO> getAllProductBatches() throws DALException 
	{
		List<ProductBatchDTO> productBatchList = new ArrayList<ProductBatchDTO>();
		ResultSet rs = con.doQuery("SELECT * FROM productBatch");

		try 
		{
			while(rs.next()) 
			{
				ProductBatchDTO dto = new ProductBatchDTO(rs.getInt("id"), rs.getInt("recipeID"), rs.getInt("status"));
				productBatchList.add(dto);
			}
			if(productBatchList.isEmpty()) {
				throw new DALException("ProduktBatch listen er tom...\nTilføj nogle værdier og prøv igen");
			}
			return productBatchList;
		}
		catch(SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}


}
