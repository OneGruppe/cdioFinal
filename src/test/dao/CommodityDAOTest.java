package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.dao_implementation.CommodityDAO;
import data.dao_interface.ICommodityDAO;
import data.dto.CommodityDTO;
import exceptions.DALException;

public class CommodityDAOTest {

	private ICommodityDAO dao;
	private int testID1 = 50;
	private int testID2 = 51;

	@Before
	public void setUp() 
	{
		try 
		{
			dao = new CommodityDAO("91.100.3.26", 9865, "CDIOFinal_test", "Eclipse-bruger", "ySmTL37uDjYZmzyn");
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
			dao.deleteCommodity(testID1);
			dao.deleteCommodity(testID2);
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createCommodityTEST() 
	{
		CommodityDTO expected = new CommodityDTO(testID1, "Test", 1);

		try
		{
			dao.createCommodity(expected);
			CommodityDTO actual = dao.getCommodity(testID1);

			assertEquals(expected.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage()); 
		}
	}

	@Test
	public void updateCommodityTEST() 
	{
		CommodityDTO expected = new CommodityDTO(testID1, "Test", 1);
		CommodityDTO updated = new CommodityDTO(testID1, "Test2", 2);

		try 
		{
			dao.createCommodity(expected);
			dao.updateCommodity(updated);

			CommodityDTO actual = dao.getCommodity(testID1);

			assertEquals(updated.toString(), actual.toString());
		}
		catch(DALException e) 
		{
			System.out.println("Error: " + e.getMessage());
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void getAllCommodityTEST() 
	{
		CommodityDTO expected1 = new CommodityDTO(testID1, "Test", 1);
		CommodityDTO expected2 = new CommodityDTO(testID2, "Test2", 2);

		List<CommodityDTO> expectedList = new ArrayList<CommodityDTO>();
		expectedList.add(expected1);
		expectedList.add(expected2);

		try 
		{
			dao.createCommodity(expected1);
			dao.createCommodity(expected2);

			List<CommodityDTO> actualList = new ArrayList<CommodityDTO>();

			for (CommodityDTO dto : dao.getAllCommodities())
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
