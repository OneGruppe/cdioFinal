package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.IProductBatchController;
import data.dao_implementation.ProductBatchDAO;
import data.dao_interface.IProductBatchDAO;
import data.dto.ProductBatchDTO;
import exceptions.DALException;

public class ProductBatchController implements IProductBatchController 
{

	private IProductBatchDAO pbdao;

	public ProductBatchController() throws DALException 
	{
		pbdao = new ProductBatchDAO();
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductBatchController#createProductBatch(int, int, int)
	 */
	@Override
	public void createProductBatch(int pbID, int status, int recipeID) throws DALException 
	{
		ProductBatchDTO productBatch = new ProductBatchDTO(pbID, status, recipeID);

		pbdao.createProductBatch(productBatch);

	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductBatchController#updateProductBatch(int, int, int)
	 */
	@Override
	public void updateProductBatch(int pbID, int status) throws DALException 
	{
		ProductBatchDTO productBatch = new ProductBatchDTO(pbID, 0, status);

		pbdao.updateProductBatch(productBatch);

	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductBatchController#deleteProductBatch(int)
	 */
	@Override
	public void deleteProductBatch(int pbID) throws DALException 
	{
		pbdao.deleteProductBatch(pbID);

	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductBatchController#getProductBatch(int)
	 */
	@Override
	public ProductBatchDTO getProductBatch(int pbID) throws DALException 
	{
		ProductBatchDTO productbatch;
		productbatch = pbdao.getProductBatch(pbID);
		return productbatch;
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductBatchController#getAllProductBatches()
	 */
	@Override
	public List<ProductBatchDTO> getAllProductBatches() throws DALException 
	{
		List<ProductBatchDTO> pbList;
		pbList = pbdao.getAllProductBatches();
		return pbList;
	}


}
