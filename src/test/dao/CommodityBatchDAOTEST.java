package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao.CommodityBatchDAO;
import data.dao_interface.ICommodityBatchDAO;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public class CommodityBatchDAOTEST {

	private ICommodityBatchDAO dao;
	private int testID1 = 50;
	private int testID2 = 51;

	@Before
	public void setUp() 
	{
		try
		{
			dao = new CommodityBatchDAO();
		}
		catch(DALException e)
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

	@After
	public void tearDown() 
	{
		try 
		{
			Connector con = new Connector();
			con.doUpdate("DELETE FROM user commodityBatch id= " + testID1);
			con.doUpdate("DELETE FROM user commodityBatch id= " + testID2);
		}
		catch (DALException e)
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

	@Test
	public void createCommodityBatchTEST()
	{
		CommodityBatchDTO expected = new CommodityBatchDTO(testID1, 1, 10.0);

		try
		{
			dao.createCommodityBatch(expected);
			
			for (CommodityBatchDTO actual : dao.getCommodityBatch(testID1))
			{
				assertEquals(expected.toString(), actual.toString());	
			}

		}
		catch(DALException e)
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

	@Test
	public void getAllCommodityBatchesTEST()
	{
		CommodityBatchDTO expected1 = new CommodityBatchDTO(testID1, 1, 10.0);
		CommodityBatchDTO expected2 = new CommodityBatchDTO(testID2, 2, 15.0);

		List<CommodityBatchDTO> expectedList = new ArrayList<CommodityBatchDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);
		
		try 
		{
			dao.createCommodityBatch(expected1);
			dao.createCommodityBatch(expected2);
			
			List<CommodityBatchDTO> actualList = new ArrayList<CommodityBatchDTO>();
			
			for (CommodityBatchDTO dto : dao.getAllCommodityBatches())
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
