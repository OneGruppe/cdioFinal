package test.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.CommodityBatchDAO;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public class CommodityBatchDAOTest 
{
	CommodityBatchDAO dao;

	@Before
	public void setUp() 
	{

		try
		{
			dao = new CommodityBatchDAO();
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void tearDown() 
	{
		try 
		{
			Connector con = new Connector();
			con.doQuery("DELETE FROM commodityBatch WHERE commodityBatchID= 10");
		}
		catch (DALException e)
		{
			fail("Error: " + e.getMessage());
		}
	}

	@Test
	public void createCommodityBatch()
	{
		CommodityBatchDTO expected = new CommodityBatchDTO(10, 10, 10.0);

		try
		{
			dao.createCommodityBatch(expected);
			CommodityBatchDTO actual = dao.getCommodityBatch(10);
			assertEquals(expected.toString(), actual.toString());	
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void updateCommodityBatch()
	{
		CommodityBatchDTO expected = new CommodityBatchDTO(10, 10, 10.0);
		CommodityBatchDTO updateExpected = new CommodityBatchDTO(10, 10, 15.0);

		try
		{
			dao.createCommodityBatch(expected);
			dao.updateCommodityBatch(updateExpected);
			CommodityBatchDTO actual = dao.getCommodityBatch(10); 
			assertEquals(updateExpected.toString(), actual.toString());
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}
}
