package test.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import data.dao_implementation.CommodityBatchDAO;
import data.dao_interface.ICommodityBatchDAO;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public class CommodityBatchDAOTest 
{

	private ICommodityBatchDAO dao;

	//TODO - virker ikke, måske DAO-problem
	@Before
	public void setUp() 
	{
		try
		{
			dao = new CommodityBatchDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
		}
		catch(DALException e)
		{
			System.out.println("Error connecting" + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}
	
	//TODO - virker ikke, måske DAO-problem
	@After
	public void tearDown() 
	{
		try 
		{
			dao.deleteCommodityBatch(10);
		}
		catch (DALException e)
		{
			fail("Error: " + e.getMessage());
		}
	}

	//TODO - virker ikke, måske DAO-problem
	@Test
	public void createCommodityBatchTEST()
	{
		CommodityBatchDTO expected = new CommodityBatchDTO(10, 1, 1, 10.0);

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

	//TODO - virker ikke, måske DAO-problem
	@Test
	public void updateCommodityBatchTEST()
	{
		CommodityBatchDTO expected = new CommodityBatchDTO(10, 1, 1, 10.0);
		CommodityBatchDTO updateExpected = new CommodityBatchDTO(10, 2, 2, 15.0);

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

	//TODO - virker ikke, måske DAO-problem
	@Test
	public void getCommodityBatchTEST()
	{
		//TODO
	}

	//TODO - virker ikke, måske DAO-problem
	@Test
	public void getAllCommodityBatchesTEST()
	{
		//TODO
	}


}
