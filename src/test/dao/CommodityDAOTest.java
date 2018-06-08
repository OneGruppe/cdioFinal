package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.CommodityDAO;
import data.dao_implementation.SupplierDAO;
import data.dao_interface.ICommodityDAO;
import data.dao_interface.ISupplierDAO;
import data.dto.CommodityDTO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class CommodityDAOTest 
{
	
	private ICommodityDAO comDAO;
	private ISupplierDAO supDAO;
	private int tempComID; //Used to get multiple Commodity ID's
	private int tempSupID; //Used to get multiple supplier ID's

	@Before
	public void setUp() 
	{
		tempComID = 0;
		tempSupID = 0;

		try 
		{
			comDAO = new CommodityDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
			supDAO = new SupplierDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
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

			for(int i = 1; i <= tempComID; i++) 
			{
				con.doUpdate("DELETE FROM commodity WHERE commodityID = " + i);
			}
			for(int i = 1; i <= tempSupID; i++) 
			{ 
				con.doUpdate("DELETE FROM supplier WHERE supplierID = " + i);
			}
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}

	//TODO - virker ikke, måske DAO-problem
	@Test
	public void createAndGetCommodityTEST() 
	{
		SupplierDTO supplier1 = new SupplierDTO(2, "Test1");
		SupplierDTO supplier2 = new SupplierDTO(2, "Test2");


		List<SupplierDTO> supplierList = new ArrayList<SupplierDTO>();
		supplierList.add(supplier1);
		supplierList.add(supplier2);

		try 
		{
			supDAO.createSupplier(supplier1);
			tempSupID++;
			supDAO.createSupplier(supplier2);
			tempSupID++;

			CommodityDTO expected = new CommodityDTO(1, "Test", supplierList);

			comDAO.createCommodity(expected);
			tempComID++;

			CommodityDTO actual = comDAO.getCommodity(1);

			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage()); 
		}
	}

	//TODO - virker ikke, måske DAO-problem
	@Test
	public void updateCommodityTEST() 
	{
		SupplierDTO supplier1 = new SupplierDTO(1, "Test1");
		SupplierDTO supplier2 = new SupplierDTO(2, "Test2");


		List<SupplierDTO> supplierList = new ArrayList<SupplierDTO>();
		supplierList.add(supplier1);
		supplierList.add(supplier2);

		try 
		{
			supDAO.createSupplier(supplier1);
			tempSupID++;
			supDAO.createSupplier(supplier2);
			tempSupID++;

			CommodityDTO dto = new CommodityDTO(1, "Test", supplierList);
			CommodityDTO updateExpected = new CommodityDTO(1, "Bongo Bob", supplierList);

			comDAO.createCommodity(dto);
			comDAO.updateCommodity(updateExpected);
			tempComID++;


			CommodityDTO actual = comDAO.getCommodity(1);

			assertEquals(updateExpected.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}

	//TODO - virker ikke, måske DAO-problem
	@Test
	public void getAllCommodityTEST() 
	{
		SupplierDTO supplier1 = new SupplierDTO(1, "Test1");
		SupplierDTO supplier2 = new SupplierDTO(2, "Test2");


		List<SupplierDTO> supplierList = new ArrayList<SupplierDTO>();
		supplierList.add(supplier1);
		supplierList.add(supplier2);

		try 
		{
			supDAO.createSupplier(supplier1);
			tempSupID++;
			supDAO.createSupplier(supplier2);
			tempSupID++;

			CommodityDTO dto = new CommodityDTO(1, "Test", supplierList);
			CommodityDTO updateExpected = new CommodityDTO(1, "Bongo Bob", supplierList);

			comDAO.createCommodity(dto);
			comDAO.updateCommodity(updateExpected);
			tempComID++;


			CommodityDTO actual = comDAO.getCommodity(1);

			assertEquals(updateExpected.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}


}
