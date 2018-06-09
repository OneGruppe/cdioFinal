package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IProductBatchComponentDAO;
import data.dto.CommodityBatchDTO;
import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

public class ProductBatchComponentDAO implements IProductBatchComponentDAO {

	private Connector con;

	/**
	 * Constructor that uses Constant-class to connect
	 * @throws DALException
	 */
	public ProductBatchComponentDAO() throws DALException
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
	public ProductBatchComponentDAO(String server, int port, String database, String username, String password) throws DALException 
	{
		con = new Connector(server, port, database, username, password);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#createProductBatchComponent(data.dto.ProductBatchComponentDTO)
	 */
	@Override
	public void createProductBatchComponent(ProductBatchComponentDTO component) throws DALException 
	{
		con.doQuery("INSERT INTO productBatchComponent VALUES ("
				+ component.getProductBatchComponentID() + ", "
				+ component.getProductBatchID() + ", "
				+ component.getCommodityBatchID() + ", "
				+ component.getUserID() + ", "
				+ component.getTara() + ", "
				+ component.getNetto() + ")" );
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#updateProductBatchComponent(data.dto.ProductBatchComponentDTO)
	 */
	@Override
	public void updateProductBatchComponent(ProductBatchComponentDTO component) throws DALException 
	{
		con.doUpdate("UPDATE productBatchComponent SET "
				+ "productBatchID=" + component.getProductBatchID() + ", "
				+ "commodityBatchID=" + component.getCommodityBatchID() + ", "
				+ "userID=" + component.getUserID() + ", "
				+ "tara=" + component.getTara() + ", "
				+ "netto=" + component.getNetto() + " "
				+ "WHERE productBatchComponent=" + component.getProductBatchComponentID());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#updateProductBatchComponent(data.dto.ProductBatchComponentDTO)
	 */
	@Override
	public void deleteProductBatchComponent(int prodbatcomID) throws DALException 
	{
		con.doUpdate("DELETE FROM productBatchComponent "
				+ "WHERE commodityBatchID=" + prodbatcomID);
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchComponentDAO#getProductBatchComponent(int)
	 */
	@Override
	public ProductBatchComponentDTO getProductBatchComponent(int productBatchID) throws DALException 
	{
		ResultSet rs = con.doQuery("SELECT * FROM productBatchComponent "
				+ "WHERE productBatchID= " + productBatchID);

		try {
			if(!rs.first()) 
			{
				throw new DALException("Produkt batch komponenten med productBatchID'et " + productBatchID + " findes ikke");
			} 
			else 
			{
				return new ProductBatchComponentDTO(rs.getInt("productBatchComponentID"), rs.getInt("productBatchID"), rs.getInt("commodityBatchID"), rs.getInt("userID"), rs.getDouble("tara"), rs.getDouble("netto"));
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
	public List<ProductBatchComponentDTO> getAllProductBatchComponents() throws DALException 
	{
		List<ProductBatchComponentDTO> productBatchList = new ArrayList<ProductBatchComponentDTO>();
		ResultSet rs = con.doQuery("SELECT * FROM productBatchComponent");

		try 
		{
			while(rs.next()) 
			{
				ProductBatchComponentDTO dto = new ProductBatchComponentDTO(rs.getInt("productBatchComponentID"), rs.getInt("productBatchID"), rs.getInt("commodityBatchID"), rs.getInt("userID"), rs.getDouble("tara"), rs.getDouble("netto"));
				productBatchList.add(dto);

				if(dto.getProductBatchID() == 0) 
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
