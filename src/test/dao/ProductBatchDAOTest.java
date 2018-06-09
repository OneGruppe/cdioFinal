package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.dao_implementation.ProductBatchDAO;
import data.dao_interface.IProductBatchDAO;
import data.dto.ProductBatchComponentDTO;
import data.dto.ProductBatchDTO;
import data.dto.RecipeComponentDTO;
import data.dto.RecipeDTO;
import exceptions.DALException;

public class ProductBatchDAOTest {

	private IProductBatchDAO dao;
	private int testID1 = 50;
	private int testID2 = 51;

	@Before
	public void setUp()
	{
		try
		{
			dao = new ProductBatchDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void teardown() 
	{
		try 
		{
			dao.deleteProductBatch(testID1);
			dao.deleteProductBatch(testID2);
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createProductBatchTEST() 
	{
		ProductBatchDTO expected = new ProductBatchDTO(testID1, 1, 1);

		try 
		{
			dao.createProductBatch(expected);

			ProductBatchDTO actual = dao.getProductBatch(testID1);

			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void updateProductBatchTEST() 
	{
		ProductBatchDTO expected = new ProductBatchDTO(testID1, 1, 1);
		ProductBatchDTO updated = new ProductBatchDTO(testID1, 1, 0);

		try 
		{
			dao.createProductBatch(expected);
			dao.updateProductBatch(updated);
			
			ProductBatchDTO actual = dao.getProductBatch(testID1);

			assertEquals(updated.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void getAllProductBatchesTEST() 
	{
		ProductBatchDTO expected1 = new ProductBatchDTO(testID1, 1, 1);
		ProductBatchDTO expected2 = new ProductBatchDTO(testID2, 2, 1);

		List<ProductBatchDTO> expectedList = new ArrayList<ProductBatchDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try 
		{
			dao.createProductBatch(expected1);
			dao.createProductBatch(expected2);
			
			List<ProductBatchDTO> actualList = new ArrayList<ProductBatchDTO>();

			for (ProductBatchDTO dto : dao.getAllProductBatches())
			{
				if (dto.getId() == testID1) 
				{
					actualList.add(dto);
				}
				else if (dto.getId() == testID2) 
				{
					actualList.add(dto);
				}
			}
			assertEquals(expectedList.toString(), actualList.toString());
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}


}
