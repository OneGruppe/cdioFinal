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
		con = new Connector();
	}


	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchDAO#createProductBatch(data.dto.ProductBatchDTO)
	 */
	@Override
	public void createProductBatch(ProductBatchDTO productBatch) throws DALException 
	{
		con.doUpdate("INSERT INTO productBatch (" + productBatch.getID() + ", "	
													+ productBatch.getRecipeID() + ", " 
													+ productBatch.getStatus() + ")" );
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchDAO#updateProductBatch(data.dto.ProductBatchDTO)
	 */
	@Override
	public void updateProductBatch(ProductBatchDTO productBatch) throws DALException 
	{
		con.doUpdate("UPDATE productBatch SET Status= " + productBatch.getStatus() + "WHERE productBatchID= " + productBatch.getID());
	}

	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchDAO#deleteProductBatch(int)
	 */
	@Override
	public void deleteProductBatch(int productBatchID) throws DALException 
	{
		con.doUpdate("DELETE FROM productBatch WHERE produktBatchID= " + productBatchID);
	}


	/*
	 * (non-Javadoc)
	 * @see data.dao_interface.IProductBatchDAO#showProductBatch(int)
	 */
	@Override
	public ProductBatchDTO getProductBatch(int productbatchID) throws DALException
	{
		ResultSet rs = con.doQuery("SELECT * FROM productBatch WHERE productBatchID= " + productbatchID);

		try 
		{
			if(!rs.first()) 
			{
				throw new DALException("ProduktBatch med ID " + productbatchID + " findes ikke");
			}
			else
			{
				return new ProductBatchDTO(rs.getInt("productBatchID"), rs.getInt("recipeID"), rs.getInt("status"));
			}

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
	public List<ProductBatchDTO> getAllProductBatches() throws DALException
	{
		List<ProductBatchDTO> PBatches = new ArrayList<ProductBatchDTO>();

		ResultSet rs = con.doQuery("SELECT * FROM productBatch");

		try 
		{
			while (rs.next()) {
				ProductBatchDTO prodbatdto = new ProductBatchDTO(rs.getInt("productBatchID"), rs.getInt("recipeID"), rs.getInt("status"));
				PBatches.add(prodbatdto);
				if (prodbatdto.getID() == 0) {throw new DALException("Produktbatchlisten er tom");}
			}
			return PBatches;
		} 
		catch (SQLException e) 
		{
			throw new DALException(e.getMessage());
		}
	} 


}
