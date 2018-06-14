package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao.ProductBatchDAO;
import data.dao_interface.IProductBatchDAO;
import data.dto.ProductBatchDTO;
import exceptions.DALException;

public class ProductBatchDAOTEST {

	private IProductBatchDAO dao;
	private int testID1 = 50;
	private int testID2 = 51;

	@Before
	public void setUp()
	{
		try
		{
			dao = new ProductBatchDAO();
		}
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

	@After
	public void teardown() 
	{
		try 
		{
			Connector con = new Connector();
			con.doUpdate("DELETE FROM productBatch WHERE id= " + testID1);
			con.doUpdate("DELETE FROM productBatch WHERE id= " + testID2);
		}
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
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
			System.out.println(e.getMessage());
			fail(e.getMessage());
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
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}


}
