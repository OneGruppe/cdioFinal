package test.dao;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.dao_implementation.ProductBatchComponentDAO;
import data.dao_interface.IProductBatchComponentDAO;
import exceptions.DALException;

public class ProductBatchComponentDAOTest 
{

	private IProductBatchComponentDAO dao;

	public ProductBatchComponentDAOTest() 
	{

	}

	@Before
	public void setUp()
	{
		try 
		{
			dao = new ProductBatchComponentDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
		} catch (DALException e) 
		{
			System.out.println("Error connecting" + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void tearDown()
	{
		// TODO
	}

	@Test
	public void createProductBatchComponentTEST()
	{
		// TODO
	}

	@Test
	public void updateProductBatchComponentTEST()
	{
		// TODO
	}

	@Test
	public void deleteProductBatchComponentTEST()
	{
		// TODO
	}

	@Test
	public void getProductBatchComponentTEST()
	{
		// TODO
	}

	@Test
	public void getAllProductBatchComponentsTEST()
	{
		// TODO
	}


}
