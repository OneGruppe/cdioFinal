package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.dao_implementation.CommodityDAO;
import data.dao_implementation.ProductBatchDAO;
import data.dao_implementation.RecipeDAO;
import data.dto.ProductBatchDTO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class ProductBatchDAOTest
{
	ProductBatchDAO productbdao;
	RecipeDAO recipedao;
	CommodityDAO commoditydao;

	@Before
	public void connect()
	{
		try
		{
			commoditydao = new CommodityDAO();
			productbdao = new ProductBatchDAO();
			recipedao = new RecipeDAO();
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
			productbdao.deleteProductBatch(3);
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createAndGetUser() 
	{
		RecipeDTO recipe = new RecipeDTO(5, "Pizza", commodityID, nomNetto, recipeTolerance)
				try
		{
					ProductBatchDTO expected = new ProductBatchDTO(3, 1, recipeID, userID, comBatID, tara, netto);
					productbdao.createProductBatch(expected);
					ProductBatchDTO actual = productbdao.getProductBatch(3);
					assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
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
		 */
	}

	@Test
	public void getALLUser() 
	{
		ProductBatchDTO userPBatch = new ProductBatchDTO(3, status, recipeID, userID, comBatID, tara, netto);

		/*
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
		 */
	}

}
