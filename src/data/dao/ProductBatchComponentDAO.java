package data.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IProductBatchComponentDAO;
import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

public class ProductBatchComponentDAO implements IProductBatchComponentDAO {

	private Connector con;

	public ProductBatchComponentDAO() throws DALException 
	{
		try 
		{
			con = new Connector();
		} 
		catch (DALException e) 
		{
			System.out.println("ProductBatchComponentDAO error: " + e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
	}

	public ProductBatchComponentDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		try 
		{
			con = new Connector(server, port, database, username, password);
		} 
		catch (DALException e) 
		{
			System.out.println("ProductBatchComponentDAO error: " + e.getMessage());
			throw new DALException("Fejl i forbindelse til database");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#createProductBatchComponent(data.dto.ProductBatchComponentDTO)
	 */
	@Override
	public void createProductBatchComponent(ProductBatchComponentDTO component) throws DALException
	{
		try 
		{
			con.doUpdate("INSERT INTO productBatchComponent VALUES (" 
					+ component.getId() + ", "
					+ component.getProductbatchID() + ", "
					+ component.getCommodityBatchID() + ", "
					+ component.getUserID() + ", "
					+ component.getTara() + ", "
					+ component.getNetto() + ")" );
		} 
		catch (DALException e) 
		{
			System.out.println("ProductBatchComponentDAO error: " + e.getMessage());
			throw new DALException("Fejl i oprettelse af produktbatch");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#getSingleProductBatchComponent(int)
	 */
	@Override
	public ProductBatchComponentDTO getSingleProductBatchComponent(int id) throws DALException 
	{
		try 
		{
			ResultSet rs = con.doQuery("SELECT * FROM productBatchComponent WHERE id = " + id);

			if(!rs.first()) 
			{
				throw new DALException("ProduktBatchet med ID'et " + id + " findes ikke!\nPrøv igen");
			}
			else 
			{
				return new ProductBatchComponentDTO(rs.getInt("id"), rs.getInt("commodityBatchID"), rs.getInt("productBatchID"), rs.getInt("userID"), rs.getDouble("tara"), rs.getDouble("netto"));
			}
		} 
		catch (SQLException e) 
		{
			System.out.println("ProductBatchComponentDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentningen af produktbatch");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#getProductBatchComponent(int)
	 */
	@Override
	public List<ProductBatchComponentDTO> getProductBatchComponent(int productBatchID) throws DALException 
	{
		List<ProductBatchComponentDTO> components = new ArrayList<ProductBatchComponentDTO>();

		try 
		{
			ResultSet rs = con.doQuery("SELECT * FROM productBatchComponent WHERE productBatchID=" + productBatchID);

			while(rs.next())
			{
				components.add(new ProductBatchComponentDTO(rs.getInt("id"), rs.getInt("productBatchID"), rs.getInt("commodityBatchID"), rs.getInt("userID"), rs.getDouble("tara"), rs.getDouble("netto")));
			}
			if(components.isEmpty())
			{
				throw new DALException("ProduktBatchet med ID'et " + productBatchID + " findes ikke!\nPrøv igen");
			}
			return components;
		}
		catch(SQLException | DALException e) 
		{
			System.out.println("ProductBatchComponentDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentningen af produktbatch-listen");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#getAllProductBatchComponents()
	 */
	@Override
	public List<ProductBatchComponentDTO> getAllProductBatchComponents() throws DALException 
	{
		List<ProductBatchComponentDTO> components = new ArrayList<ProductBatchComponentDTO>();

		try 
		{
			ResultSet rs = con.doQuery("SELECT * FROM productBatchComponent");

			while(rs.next()) 
			{
				ProductBatchComponentDTO dto = new ProductBatchComponentDTO(rs.getInt("id"), rs.getInt("productBatchID"), rs.getInt("commodityBatchID"), rs.getInt("userID"), rs.getDouble("tara"), rs.getDouble("netto"));
				components.add(dto);
			}
			if(components.isEmpty()) 
			{
				throw new DALException("ProductBatch komponent listen er tom...\nTilføj nogle værdier og prøv igen");
			}
			return components;
		}
		catch(SQLException | DALException e) 
		{
			System.out.println("ProductBatchComponentDAO error: " + e.getMessage());
			throw new DALException("Fejl i hentningen af produktbatch-listen");
		}
	}

}
