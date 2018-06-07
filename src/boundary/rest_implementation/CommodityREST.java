package boundary.rest_implementation;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import boundary.rest_interface.ICommodityREST;
import controller.controller_implementation.CommodityController;
import data.dto.CommodityDTO;
import data.dto.SupplierDTO;
import exceptions.DALException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Path("commodity")
public class CommodityREST implements ICommodityREST {
	
	private CommodityController cc;
	
	public CommodityREST() 
	{
		try {
			
			cc = new CommodityController();
			
		} catch (DALException e) {
			
			System.out.println(e.getMessage());
		}
	}

	@Override
	@PUT
	@Path("createCommodity")
	public String createCommodity(@FormParam("id") int id, @FormParam("name") String name, @FormParam("suppliers") List<SupplierDTO> suppliers) throws DALException 
	{
		String returnMessage;
		cc.createCommodity(id, name, suppliers);
		
	}

	@Override
	@POST
	@Path("updateCommodity")
	public void updateCommodity(@FormParam("id") int id, @FormParam("name") String name, @FormParam("suppliers") List<SupplierDTO> suppliers) throws DALException 
	{
		cc.updateCommodity(id, name, suppliers);
	}

	@Override
	@DELETE
	@Path("deleteCommodity")
	public void deleteCommodity(int id) throws DALException 
	{
		cc.deleteCommodity(id);
	}

	@Override
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getCommodity")
	public CommodityDTO getCommodity(@FormParam("id") int id) throws DALException 
	{
		CommodityDTO commodity;
		commodity = cc.getCommodity(id);
		return commodity;
	}

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAllCommodities")
	public List<CommodityDTO> getAllCommodities() throws DALException 
	{
		List<CommodityDTO> commodities;
		commodities = cc.getAllCommodities();
		return commodities;
	}
	
}
