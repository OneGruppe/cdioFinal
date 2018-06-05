package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.IProductBatchController;
import data.dao_implementation.ProductBatchDAO;
import data.dto.ProductBatchDTO;
import exceptions.DALException;

public class ProductBatchController implements IProductBatchController {
	
	ProductBatchDAO pbdao;
	
	public ProductBatchController() throws DALException 
	{
		pbdao = new ProductBatchDAO();
	}

	@Override
	public void createProductBatch(int pbID, int status, int recipeID, int userID, int comBatID, double tara,
			double netto) throws DALException 
	{
		ProductBatchDTO productBatch = new ProductBatchDTO(pbID, status, recipeID, userID, comBatID, tara, netto);
		
		pbdao.createProductBatch(productBatch);
		
	}

	@Override
	public void updateProductBatch(int pbID, int status, int recipeID, int userID, int comBatID, double tara,
			double netto) throws DALException 
	{
		ProductBatchDTO productBatch = new ProductBatchDTO(pbID, status, recipeID, userID, comBatID, tara, netto);
		
		pbdao.updateProductBatch(productBatch);
		
	}

	@Override
	public void deleteProductBatch(int pbID) throws DALException 
	{
		pbdao.deleteProductBatch(pbID);
		
	}

	@Override
	public ProductBatchDTO getProductBatch(int pbID) throws DALException 
	{
		ProductBatchDTO productbatch;
		productbatch = pbdao.getProductBatch(pbID);
		return productbatch;
	}

	@Override
	public List<ProductBatchDTO> getAllProductBatches() throws DALException 
	{
		List<ProductBatchDTO> pbList;
		pbList = pbdao.getAllProductBatches();
		return pbList;
	}

}
