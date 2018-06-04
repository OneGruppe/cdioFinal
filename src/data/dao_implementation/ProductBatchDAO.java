package data.dao_implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public void createProductBatch(ProductBatchDTO productBatch) throws DALException 
	{
		connector.doUpdate("INSERT INTO productBatch" +productBatch.getPbID()+ 
				productBatch.getStatus()+ productBatch.getRecipeID()+ userID+);
	}

	@Override
	public void updateProductBatch(ProductBatchDTO productBatch) throws DALException 
	{
		connector.doUpdate("UPDATE productBatch SET status=" +productBatch.getStatus()+
					", userID="+productBatch.getUserID()+"WHERE productBatchID =" 
					+productBatch.getPbID());
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
		List<ProductBatchDTO> PBatches = new ArrayList<ProductBatchDTO>();
		ResultSet rs = connector.doQuery("SELECT * FROM productBatch");
		
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
		catch (SQLException e) {throw new DALException(e.getMessage());}
		} 

}
