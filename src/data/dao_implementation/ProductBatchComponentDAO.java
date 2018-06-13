package data.dao_implementation;

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
		con = new Connector();
	}

	public ProductBatchComponentDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		con = new Connector(server, port, database, username, password);
	}


	@Override
	public void createProductBatchComponent(ProductBatchComponentDTO component) throws DALException 
	{
		
		con.doUpdate("INSERT INTO productBatchComponent VALUES (" 
				+ component.getId() + ", "
				+ component.getProductbatchID() + ", "
				+ component.getCommodityBatchID() + ", "
				+ component.getUserID() + ", "
				+ component.getTara() + ", "
				+ component.getNetto() + ")" );
	}

	@Override
	public void updateProductBatchComponent(ProductBatchComponentDTO component) throws DALException 
	{
		con.doUpdate("UPDATE productBatchComponent SET "
				+ "productBatchID=" + component.getProductbatchID() + ", "
				+ "commodityBatchID=" + component.getCommodityBatchID()+ ", "
				+ "userID=" + component.getUserID() + ", "
				+ "tara=" + component.getTara() + ", "
				+ "netto=" + component.getNetto()
				+ " WHERE id=" + component.getId());
	}

	@Override
	public void deleteProductBatchComponent(int id) throws DALException 
	{
		con.doUpdate("DELETE FROM productBatchComponent WHERE id=" + id);
	}
	
	@Override
	public ProductBatchComponentDTO getSingleProductBatchComponent(int id) throws DALException 
	{
		ResultSet rs = con.doQuery("SELECT * FROM productBatchComponent WHERE id = " + id);

		try 
		{
			if(!rs.first()) 
			{
				throw new DALException("" + id);
			}
			else 
			{
				return new ProductBatchComponentDTO(rs.getInt("id"), rs.getInt("commodityBatchID"), rs.getInt("productBatchID"), rs.getInt("userID"), rs.getDouble("tara"), rs.getDouble("netto"));
			}
		} 
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}

	@Override
	public List<ProductBatchComponentDTO> getProductBatchComponent(int productBatchID) throws DALException 
	{
		List<ProductBatchComponentDTO> components = new ArrayList<ProductBatchComponentDTO>();
		ResultSet rs = con.doQuery("SELECT * FROM productBatchComponent WHERE productBatchID=" + productBatchID);

		try {
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
		catch(SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}


	@Override
	public List<ProductBatchComponentDTO> getAllProductBatchComponents() throws DALException 
	{
		List<ProductBatchComponentDTO> components = new ArrayList<ProductBatchComponentDTO>();
		ResultSet rs = con.doQuery("SELECT * FROM productBatchComponent");

		try {
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
		catch(SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}

}
