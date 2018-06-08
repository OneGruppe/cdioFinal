package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.SupplierDAO;
import data.dao_interface.ISupplierDAO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class SupplierDAOTest 
{
	private ISupplierDAO dao;
	private int tempID; //Used to get multiple ID's

	@Before
	public void setUp() 
	{
		tempID = 0;

		try 
		{
			dao = new SupplierDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
		} 
		catch(DALException e) 
		{
			System.out.println("Error connecting" + e.getMessage());
			fail("Error: " + e.getMessage());
		}
	}

	@After
	public void tearDown()
	{
		try 
		{
			Connector con = new Connector();

			for(int i = 1; i <= tempID; i++) 
			{
				con.doUpdate("DELETE FROM supplier WHERE supplierID = " + i);
			}
		} 
		catch(DALException e) 
		{
			fail("Error: " + e.getMessage());
		}
	}

	//TODO - skal tjekkes igennem
	@Test
	public void createAndGetSupplierTEST() 
	{
		SupplierDTO expected = new SupplierDTO(1, "Test");
		tempID++;

		try 
		{
			dao.createSupplier(expected);

			SupplierDTO actual = dao.getSupplier(1);
			assertEquals(expected.toString(), actual.toString());
		} 
		catch(DALException e) 
		{
			fail("Error: " + e.getMessage());
		}
	}

	//TODO - skal tjekkes igennem
	@Test
	public void updateSupplierTEST() 
	{
		SupplierDTO dto = new SupplierDTO(1, "Test");
		SupplierDTO updateExpected = new SupplierDTO(1, "Bongo Bob");
		tempID++;

		try {
			dao.createSupplier(dto);
			dao.updateSupplier(updateExpected);

			SupplierDTO actual = dao.getSupplier(1);

			assertEquals(updateExpected.toString(), actual.toString());
		} catch(DALException e) 
		{
			fail("Error: " + e.getMessage());
		}
	}

	@Test
	public void deleteSupplierTEST() 
	{
		SupplierDTO dto = new SupplierDTO(1, "Test");
		tempID++;

		try 
		{
			dao.createSupplier(dto);
			dao.deleteSupplier(1);

			assertTrue(dao.getSupplier(1).toString() == null);
			fail("Error in testDeleteRecipe");
		}
		catch(DALException e) 
		{
			// Success
		}
	}

	//TODO - skal tjekkes igennem
	@Test
	public void getAllSuppliersTEST() 
	{
		SupplierDTO expected1 = new SupplierDTO(1, "Bongo");
		tempID++;
		SupplierDTO expected2 = new SupplierDTO(2, "Brain");
		tempID++;

		List<SupplierDTO> expectedList = new ArrayList<SupplierDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try 
		{
			dao.createSupplier(expected1);
			dao.createSupplier(expected2);

			List<SupplierDTO> actualList = dao.getAllSuppliers();

			assertEquals(expectedList.toString(), actualList.toString());
		}
		catch(DALException e) 
		{
			fail("Error " + e.getMessage());
		}
	}


}