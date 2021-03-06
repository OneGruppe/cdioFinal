package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao.SupplierDAO;
import data.dao_interface.ISupplierDAO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class SupplierDAOTEST {

	private ISupplierDAO dao;
	private int testID1 = 50;
	private int testID2 = 51;

	@Before
	public void setUp() 
	{
		try 
		{
			dao = new SupplierDAO();
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
			con.doUpdate("DELETE FROM supplier WHERE id= " + testID1);
			con.doUpdate("DELETE FROM supplier WHERE id= " + testID2);
		} 
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

	@Test
	public void createSupplierTEST() 
	{
		SupplierDTO expected = new SupplierDTO(testID1, "Test");

		try 
		{
			dao.createSupplier(expected);

			SupplierDTO actual = dao.getSupplier(testID1);

			assertEquals(expected.toString(), actual.toString());
		} 
		catch(DALException e) 
		{
			System.out.println(e.getMessage());
			fail(e.getMessage());
		}
	}

	@Test
	public void getAllSuppliersTEST() 
	{
		SupplierDTO expected1 = new SupplierDTO(testID1, "Bongo");
		SupplierDTO expected2 = new SupplierDTO(testID2, "Brain");

		List<SupplierDTO> expectedList = new ArrayList<SupplierDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try 
		{
			dao.createSupplier(expected1);
			dao.createSupplier(expected2);

			List<SupplierDTO> actualList = new ArrayList<SupplierDTO>();

			for (SupplierDTO dto : dao.getAllSuppliers())
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
