package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.dao.ProductBatchComponentDAO;
import data.dao_interface.IProductBatchComponentDAO;
import data.dto.ProductBatchComponentDTO;
import exceptions.DALException;

public class ProductBatchComponentDAOTest {

	private IProductBatchComponentDAO dao;
	private int testID1 = 50;
	private int testID2 = 51;

	@Before
	public void setUp() 
	{
		try 
		{
			dao = new ProductBatchComponentDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
		} 
		catch (DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void tearDown() 
	{
		try 
		{
			dao.deleteProductBatchComponent(testID1);
			dao.deleteProductBatchComponent(testID2);
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createProductBatchComponentTEST() 
	{
		ProductBatchComponentDTO expected = new ProductBatchComponentDTO(testID1, 1, 1, 1, 1.0, 1.0);

		try {
			dao.createProductBatchComponent(expected);

			for(ProductBatchComponentDTO actual : dao.getProductBatchComponent(1)) 
			{
				assertEquals(expected.toString(), actual.toString());
			}
		} 
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void updateProductBatchComponentTEST()
	{
		ProductBatchComponentDTO expected = new ProductBatchComponentDTO(testID1, 1, 1, 1, 1.0, 1.0);
		ProductBatchComponentDTO updated = new ProductBatchComponentDTO(testID1, 1, 2, 1, 2.0, 2.0);

		try {
			dao.createProductBatchComponent(expected);
			dao.updateProductBatchComponent(updated);

			for(ProductBatchComponentDTO actual : dao.getProductBatchComponent(1)) {
				if(updated.getId() == updated.getId())
				{					
					assertEquals(updated.toString(), actual.toString());
				}
			}
		} 
		catch (DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void getAllProductBatchComponentsTEST() 
	{
		ProductBatchComponentDTO expected1 = new ProductBatchComponentDTO(testID1, 1, 1, 1, 1.0, 1.0);
		ProductBatchComponentDTO expected2 = new ProductBatchComponentDTO(testID2, 1, 1, 1, 2.0, 2.0);

		List<ProductBatchComponentDTO> expectedList = new ArrayList<ProductBatchComponentDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try 
		{
			dao.createProductBatchComponent(expected1);
			dao.createProductBatchComponent(expected2);

			List<ProductBatchComponentDTO> actualList = new ArrayList<ProductBatchComponentDTO>();

			for (ProductBatchComponentDTO dto : dao.getAllProductBatchComponents()) 
			{
				if (dto.getId() == testID1 || dto.getId() == testID2) 
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
