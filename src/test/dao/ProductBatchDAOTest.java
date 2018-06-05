package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.CommodityBatchDAO;
import data.dao_implementation.CommodityDAO;
import data.dao_implementation.ProductBatchDAO;
import data.dao_implementation.RecipeDAO;
import data.dao_implementation.SupplierDAO;
import data.dao_implementation.UserDAO;
import data.dto.CommodityBatchDTO;
import data.dto.CommodityDTO;
import data.dto.ProductBatchDTO;
import data.dto.RecipeDTO;
import data.dto.SupplierDTO;
import data.dto.UserDTO;
import exceptions.DALException;

public class ProductBatchDAOTest
{
	ProductBatchDAO productbdao;
	RecipeDAO recipedao;
	CommodityDAO commoditydao;
	SupplierDAO supplierdao;
	UserDAO userdao;
	CommodityBatchDAO commoditybatchdao;

	@Before
	public void connect()
	{
		try
		{
			commoditydao = new CommodityDAO();
			commoditybatchdao = new CommodityBatchDAO();
			productbdao = new ProductBatchDAO();
			recipedao = new RecipeDAO();
			supplierdao = new SupplierDAO();
			userdao = new UserDAO();
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void teardown()
	{
		try
		{
			supplierdao.deleteSupplier(6);
			commoditydao.deleteCommodity(1);
			commoditybatchdao.deleteCommodityBatch(4);
			recipedao.deleteRecipe(5);
			productbdao.deleteProductBatch(3);
			Connector con = new Connector();
			con.doUpdate("DELETE FROM users WHERE userID = 3");
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createProductBatch() 
	{
		try
		{
			//Make a supplier
			SupplierDTO suppdto = new SupplierDTO(6, "Simons Lager");
			supplierdao.createSupplier(suppdto);

			//Make a supplierList
			List<SupplierDTO> suppList = new ArrayList<SupplierDTO>();
			suppList.add(suppdto);

			//Make a commodity
			CommodityDTO comdto = new CommodityDTO(1, "Tomat", suppList);
			commoditydao.createCommodity(comdto);

			//Make commodityBatch
			CommodityBatchDTO combatdto = new CommodityBatchDTO(4, comdto.getCommodityID(), 20);
			commoditybatchdao.createCommodityBatch(combatdto);

			//Make a commodityList
			List<Integer> comList = new ArrayList<Integer>();
			comList.add(comdto.getCommodityID());

			//Make a recipe
			RecipeDTO recipedto = new RecipeDTO(5, "Pizza", comList, 0.5, 0.1);
			recipedao.createRecipe(recipedto);

			//Make a user
			UserDTO userdto = new UserDTO(3, "Thomas Nielsen", "TN", 1);
			userdao.createUser(userdto);

			//Make a productBatch
			ProductBatchDTO expected = new ProductBatchDTO(3, 1, recipedto.getRecipeID(), userdto.getUserID(), combatdto.getCbid(), 0.1, 10);
			productbdao.createProductBatch(expected);
			
			ProductBatchDTO actual = productbdao.getProductBatch(3);
			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	/*
	@Ignore
	public void updateAndGetUser() 
	{
		ProductBatchDTO exPBatch = new ProductBatchDTO(3, 1, recipeID, userID, comBatID, tara, netto);
		ProductBatchDTO updPBatch = new ProductBatchDTO(3, 2, recipeID, userID, comBatID, tara, netto);

		/*
		try
		{
			userdao.createUser(exUser);
			ProductBatchDAO before = userdao.getUser(5);
			assertEquals(exUser.toString(), before.toString());

			// Update ProductBatch
			userdao.updateUser(updUser);
			ProductBatchDAO after = userdao.getUser(5);
			assertEquals(updUser.toString(), after.toString());
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Ignore
	public void getALLUser() 
	{
		ProductBatchDTO userPBatch = new ProductBatchDTO(3, status, recipeID, userID, comBatID, tara, netto);

		try
		{
			userdao.createUser(userOne);
			for (ProductBatchDAO usr : userdao.getAllUsers())
			{
				if (usr.getUserID() == 5)
				{
					assertEquals(userOne.toString(), usr.toString());
					break;
				}
			}
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}
	*/

}
