package controller.controller_implementation;

import java.util.List;

import controller.controller_interface.IProductbatchComponentController;
import data.dao_implementation.ProductBatchComponentDAO;
import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

public class ProductBatchComponentController implements IProductbatchComponentController {
	
	ProductBatchComponentDAO dao;

	public ProductBatchComponentController() throws DALException {
		dao = new ProductBatchComponentDAO();
	}
	
	@Override
	public void createProductBatchComponent(int pbID, int commodityBatchID, int userID, double tara, double netto)
			throws DALException {
		ProductBatchComponentDTO component = new ProductBatchComponentDTO(pbID, commodityBatchID, userID, tara, netto);
		
		dao.createProductBatchComponent(component);
	}

	@Override
	public void updateProductBatchComponent(int pbID, int commodityBatchID, int userID, double tara, double netto)
			throws DALException {
		ProductBatchComponentDTO component = new ProductBatchComponentDTO(pbID, commodityBatchID, userID, tara, netto);
			
		dao.createProductBatchComponent(component);		
	}

	@Override
	public ProductBatchComponentDTO getProductBatchComponent(int componentID) throws DALException {
		ProductBatchComponentDTO component = dao.getProductBatchComponent(componentID);
		return component;
	}

	@Override
	public List<ProductBatchComponentDTO> getAllProductBatchComponents() throws DALException {
		List<ProductBatchComponentDTO> componentList = dao.getAllProductBatchComponents();
		return componentList;
	}
}
