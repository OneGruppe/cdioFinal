package boundary.rest_implementation;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import boundary.rest_interface.IProductBatchREST;
import controller.controller_implementation.ProductBatchController;
import data.dto.ProductBatchDTO;
import exceptions.DALException;

public class ProductBatchREST implements IProductBatchREST {
	
	private ProductBatchController pbc;
	
	public ProductBatchREST() 
	{
		try {
			pbc = new ProductBatchController();
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	@PUT
	@Path("createProductBatch")
	public void createProductBatch(@FormParam("pbID") int pbID, @FormParam("status") int status, @FormParam("recipeID") int recipeID, @FormParam("userID") int userID, @FormParam("comBatID") int comBatID, @FormParam("tara") double tara,
			@FormParam("netto") double netto) throws DALException 
	{
		pbc.createProductBatch(pbID, status, recipeID, userID, comBatID, tara, netto);
		
	}

	@Override
	@POST
	@Path("updateProductBatch")
	public void updateProductBatch(@FormParam("pbID") int pbID, @FormParam("status") int status, @FormParam("recipeID") int recipeID, @FormParam("userID") int userID, @FormParam("comBatID") int comBatID, @FormParam("tara") double tara,
			@FormParam("netto") double netto) throws DALException 
	{
		pbc.updateProductBatch(pbID, status, recipeID, userID, comBatID, tara, netto);
		
	}

	@Override
	@DELETE
	@Path("deleteProductBatch")
	public void deleteProductBatch(@FormParam("pbID") int pbID) throws DALException 
	{
		pbc.deleteProductBatch(pbID);
		
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getProductBatch")
	public ProductBatchDTO getProductBatch(@FormParam("pbID") int pbID) throws DALException 
	{
		ProductBatchDTO productbatch;
		productbatch = pbc.getProductBatch(pbID);
		return productbatch;
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllProductBatches")
	public List<ProductBatchDTO> getAllProductBatches() throws DALException 
	{
		List<ProductBatchDTO> productbatch;
		productbatch = pbc.getAllProductBatches();
		return productbatch;
	}

}
