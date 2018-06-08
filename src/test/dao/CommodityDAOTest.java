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

public class CommodityDAOTest {
	CommodityDAO comDAO;
	SupplierDAO supDAO;
	int tempComID; //Used to get multiple Commodity ID's
	int tempSupID; //Used to get multiple supplier ID's
	
	@Before
	public void setUp() {
		tempComID = 0;
		
		try {
			comDAO = new CommodityDAO();
			supDAO = new SupplierDAO();
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@After
	public void teardown() {
		try {
			Connector con = new Connector();
			
			for(int i = 1; i <= tempComID; i++) { //i is equivalent to id therefor i starts at 1
				con.doUpdate("DELETE FROM commodity WHERE commodityID=" + i);
			}
			for(int i = 1; i <= tempSupID; i++) { 
				con.doUpdate("DELETE FROM supplier WHERE supplierID=" + i);
			}
		}
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}

	@Test
	public void createAndGetCommodity() {
		SupplierDTO supplier1 = new SupplierDTO(1, "Test1");
		SupplierDTO supplier2 = new SupplierDTO(2, "Test2");
		
		
		List<SupplierDTO> supplierList = new ArrayList<SupplierDTO>();
		supplierList.add(supplier1);
		supplierList.add(supplier2);
		
		try {
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
		catch(DALException e) {
			fail("Error " + e.getMessage()); 
		}
	}

	@Test
	public void updateCommodity() {
		SupplierDTO supplier1 = new SupplierDTO(1, "Test1");
		SupplierDTO supplier2 = new SupplierDTO(2, "Test2");
		
		
		List<SupplierDTO> supplierList = new ArrayList<SupplierDTO>();
		supplierList.add(supplier1);
		supplierList.add(supplier2);
		
		try {
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
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}
	
	
	@Test
	public void getAllCommodity() {
		SupplierDTO supplier1 = new SupplierDTO(1, "Test1");
		SupplierDTO supplier2 = new SupplierDTO(2, "Test2");
		
		
		List<SupplierDTO> supplierList1 = new ArrayList<SupplierDTO>();
		supplierList1.add(supplier1);
		supplierList1.add(supplier2);
		
		try {
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
		catch(DALException e) {
			fail("Error " + e.getMessage());
		}
	}
}
