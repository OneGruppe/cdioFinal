package data.dao;

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
		try 
		{
			con = new Connector();
		} 
		catch (DALException e) 
		{
			System.out.println("ProductBatchDAO error: " + e.getMessage());
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
	public ProductBatchDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		try 
		{
			con = new Connector(server, port, database, username, password);
		} 
		catch (DALException e) 
		{
			System.out.println("ProductBatchDAO error: " + e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#createProductBatchComponent(data.dto.ProductBatchComponentDTO)
	 */
	@Override
	public void createProductBatch(ProductBatchDTO productBatch) throws DALException
	{
		try 
		{
			con.doUpdate("INSERT INTO productBatch VALUES ("
					+ productBatch.getId() + ", "
					+ productBatch.getRecipeID() + ", "
					+ productBatch.getStatus() + ")" );
		} 
		catch (DALException e) 
		{
			System.out.println("ProductBatchDAO error: " + e.getMessage());
			throw new DALException("Fejl i oprettelse af produktBatch");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#getProductBatchComponent(int)
	 */
	@Override
	public ProductBatchDTO getProductBatch(int id) throws DALException 
	{
		try 
		{
			ResultSet rs = con.doQuery("SELECT * FROM productBatch WHERE id= " + id);
			
			if(!rs.first()) 
			{
				throw new DALException("Produkt batch med productBatchID'et " + id + " findes ikke");
			} 
			else 
			{
				return new ProductBatchDTO(rs.getInt("id"), rs.getInt("recipeID"), rs.getInt("status"));
			}
		}
		catch(SQLException | DALException e) 
		{
			System.out.println("ProductBatchDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af produktBatch");
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

		try 
		{
			ResultSet rs = con.doQuery("SELECT * FROM productBatch");
			
			while(rs.next()) 
			{
				ProductBatchDTO dto = new ProductBatchDTO(rs.getInt("id"), rs.getInt("recipeID"), rs.getInt("status"));
				productBatchList.add(dto);
			}
			if(productBatchList.isEmpty()) 
			{
				throw new DALException("ProduktBatch listen er tom...\nTilføj nogle værdier og prøv igen");
			}
			return productBatchList;
		}
		catch(SQLException | DALException e) 
		{
			System.out.println("ProductBatchDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentning af produktBatch-listen");
		}
	}


}
