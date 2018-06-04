package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IProductBatchDAO;
import data.dto.ProductBatchDTO;
import exceptions.DALException;

public class ProductBatchDAO implements IProductBatchDAO 
{

	private Connector con;


	public ProductBatchDAO() throws DALException
	{
		try 
		{
			con = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}


	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchDAO#createProductBatch(data.dto.ProductBatchDTO)
	 */
	@Override
	public void createProductBatch(ProductBatchDTO productBatch) throws DALException 
	{
		con.doUpdate("INSERT INTO productBatch (" + productBatch.getPbID() + ", " 
				+ productBatch.getStatus() + ", " + productBatch.getRecipeID() + "," + productBatch.getUserID() +
				", " + productBatch.getComBatID() + ", " + productBatch.getTara() + "," + productBatch.getNetto());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchDAO#updateProductBatch(data.dto.ProductBatchDTO)
	 */
	@Override
	public void updateProductBatch(ProductBatchDTO productBatch) throws DALException 
	{
		con.doUpdate("UPDATE productBatch SET status=" + productBatch.getStatus() +
				", userID=" + productBatch.getUserID() + "WHERE productBatchID =" 
				+ productBatch.getPbID());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchDAO#deleteProductBatch(int)
	 */
	@Override
	public void deleteProductBatch(int pbID) throws DALException 
	{
		con.doUpdate("DELETE FROM productBatch WHERE produktBatchID =" + pbID);

	}


	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchDAO#showProductBatch(int)
	 */
	@Override
	public ProductBatchDTO showProductBatch(int productbatchID) throws DALException
	{
		ResultSet rs = con.doQuery("SELECT * FROM productBatch WHERE productBatchID ="
				+ productbatchID);
		try 
		{
			if(!rs.first()) 
			{
				throw new DALException("Produkt batchen med ID " + productbatchID + 
						" findes ikke");
			}

			return new ProductBatchDTO(rs.getInt("productBatchID"), 
					rs.getInt("status"), rs.getInt("recipeID"), rs.getInt("userID"),
					rs.getInt("commodityBatchID"), rs.getDouble("tara"), rs.getDouble("netto"));
		} 
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	}


	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchDAO#showProductBatch()
	 */
	@Override
	public List<ProductBatchDTO> showProductBatch() throws DALException
	{
		List<ProductBatchDTO> PBatches = new ArrayList<ProductBatchDTO>();
		ResultSet rs = con.doQuery("SELECT * FROM productBatch");

		try 
		{
			if(!rs.first()) 
			{
				throw new DALException("Der findes ingen produkt batches i databsen.");
			}
			while (rs.next()) {
				PBatches.add(new ProductBatchDTO(rs.getInt("productBatchID"), 
						rs.getInt("status"), rs.getInt("recipeID"), rs.getInt("userID"),
						rs.getInt("commodityBatchID"), rs.getDouble("tara"), rs.getDouble("netto")));
			}
			return PBatches;
		} 
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	} 

}
