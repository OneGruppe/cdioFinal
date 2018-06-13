package controller.controller;

import java.util.List;

import controller.controller_interface.IProductBatchComponentController;
import data.dao.ProductBatchComponentDAO;
import data.dao_interface.IProductBatchComponentDAO;
import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

public class ProductBatchComponentController implements IProductBatchComponentController {

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
	public void createProductBatchComponent(int commodityBatchID, int productBatchID, int userID, double tara, double netto) throws DALException 
	{
		ProductBatchComponentDTO component = new ProductBatchComponentDTO(0, commodityBatchID, productBatchID, userID, tara, netto);
		dao.createProductBatchComponent(component);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductbatchComponentController#updateProductBatchComponent(int, int, int, int, double, double)
	 */
	@Override
	public void updateProductBatchComponent(int productBatchComponent, int productBatchID, int commodityBatchID, int userID, double tara, double netto) throws DALException 
	{
		ProductBatchComponentDTO component = new ProductBatchComponentDTO(productBatchComponent, productBatchID, commodityBatchID, userID, tara, netto);
		dao.createProductBatchComponent(component);
	}

	/*
	 * (non-Javadoc)
	 * @see controller.controller_interface.IProductbatchComponentController#getSingleProductBatchComponent(int)
	 */
	@Override
	public ProductBatchComponentDTO getSingleProductBatchComponent(int id) throws DALException 
	{
		ProductBatchComponentDTO component;
		component = dao.getSingleProductBatchComponent(id);
		return component;
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
