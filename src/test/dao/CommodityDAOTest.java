package test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.CommodityDAO;
import data.dao_implementation.SupplierDAO;
import data.dto.CommodityBatchDTO;
import data.dto.CommodityDTO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class CommodityDAOTest 
{
	CommodityDAO comDAO;
	SupplierDAO supDAO;
	List<Integer> supplierList = new ArrayList<Integer>();

	@Before
	public void connect()
	{
		try
		{
			comDAO = new CommodityDAO();
			supDAO = new SupplierDAO();
			
			SupplierDTO supplier1 = new SupplierDTO(1, "Supplier 1");
			supplierList.add(1);
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
			Connector con = new Connector();
			con.doUpdate("DELETE FROM commodity WHERE commodityID=" + 10);
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createCommodity() 
	{
		CommodityDTO expected = new CommodityDTO(10, "Test", supplierList); //Supplier er en interger list men implementeret som objekt list

		try
		{
			comDAO.createCommodity(expected);
			CommodityDTO actual = comDAO.getCommodity(10);
			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void updateCommodity()
	{
		CommodityDTO expected = new CommodityDTO(10, "Test", supplierList);
		CommodityDTO updateExpected = new CommodityDTO(10, "I got klamydia", supplierList);

		try
		{
			comDAO.createCommodity(expected);
			comDAO.updateCommodity(updateExpected);
			CommodityDTO actual = comDAO.getCommodity(10); 
			assertEquals(updateExpected.toString(), actual.toString());
		}
		catch(DALException e)
		{
			fail("Error " + e.getMessage());
		}
	}
}
