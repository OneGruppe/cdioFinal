package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import data.connector.Connector;
import data.dao_interface.IProductBatchDAO;
import data.dto.ProductBatchDTO;
import data.dto.UserDTO;
import exceptions.DALException;



public class ProductBatchDAO implements IProductBatchDAO {

		private Connector connector;
	

	public ProductBatchDAO()
	{
		try {
			connector = new Connector();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void createProductBatch(ProductBatchDTO productBatch, int userID, int commodityBatchID, double tara, double netto) throws DALException 
	{
		connector.doUpdate("INSERT INTO productBatch" +productBatch.getPbID()+ 
				productBatch.getStatus()+ productBatch.getRecipeID()+ userID+
				commodityBatchID+ tara + netto);
	}

	@Override
	public void updateProductBatch(ProductBatchDTO productBatch) throws DALException 
	{
		
		
	}

	@Override
	public void deleteProductBatch(int pbID) throws DALException 
	{
		connector.doUpdate("DELETE FROM productBatch WHERE produktBatchID =" +pbID);
		
	}


	@Override
	public ProductBatchDTO showProductBatch(int productbatchID) throws DALException
	{
		ResultSet rs = connector.doQuery("SELECT * FROM productBatch WHERE productBatchID ="
						+ productbatchID);
		try 
		{
			if(!rs.first()) 
			{
				throw new DALException("Produkt batchen med ID " +productbatchID+ 
						" findes ikke");
			}
			
			return new ProductBatchDTO(rs.getInt("productBatchID"), 
					rs.getInt("status"), rs.getInt("recipeID"), rs.getInt("userID"),
					rs.getInt("commodityBatchID"), rs.getDouble("tara"), rs.getDouble("netto"));
		} 
		catch (SQLException e) {throw new DALException(e.getMessage());}
	}



	@Override
	public List<ProductBatchDTO> showProductBatch() throws DALException
	{
		// TODO Auto-generated method stub
		return null;
	} 

}
