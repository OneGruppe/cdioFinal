package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.IProductbatchComponentController;
import data.dao_implementation.ProductBatchComponentDAO;
import data.dao_interface.IProductBatchComponentDAO;
import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

public class ProductBatchComponentController implements IProductbatchComponentController {

	private IProductBatchComponentDAO dao;

	public ProductBatchComponentController() throws DALException 
	{
		dao = new ProductBatchComponentDAO();
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductbatchComponentController#createProductBatchComponent(int, int, int, int, double, double)
	 */
	@Override
	public void createProductBatchComponent(int productBatchComponentID, int productBatchID, int commodityBatchID, int userID, double tara, double netto) throws DALException 
	{
		ProductBatchComponentDTO component = new ProductBatchComponentDTO(productBatchComponentID, productBatchID, commodityBatchID, userID, tara, netto);
		dao.createProductBatchComponent(component);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductbatchComponentController#updateProductBatchComponent(int, int, int, int, double, double)
	 */
	@Override
	public void updateProductBatchComponent(int productBatchComponentID, int productBatchID, int commodityBatchID, int userID, double tara, double netto) throws DALException 
	{
		ProductBatchComponentDTO component = new ProductBatchComponentDTO(productBatchComponentID, productBatchID, commodityBatchID, userID, tara, netto);
		dao.createProductBatchComponent(component);		
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductbatchComponentController#getProductBatchComponent(int)
	 */
	@Override
	public List<ProductBatchComponentDTO> getProductBatchComponent(int productBatchID) throws DALException 
	{
		return dao.getProductBatchComponent(productBatchID);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductbatchComponentController#getAllProductBatchComponents()
	 */
	@Override
	public List<ProductBatchComponentDTO> getAllProductBatchComponents() throws DALException 
	{
		List<ProductBatchComponentDTO> componentList = dao.getAllProductBatchComponents();
		return componentList;
	}


}
