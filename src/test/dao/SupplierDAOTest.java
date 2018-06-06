package test.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.SupplierDAO;
import data.dto.SupplierDTO;
import exceptions.DALException;

public class SupplierDAOTest {
	SupplierDAO dao;

	@Before
	public void setUp() throws Exception {
		try {
			dao = new SupplierDAO();
		} catch(DALException e) {
			fail("Error: " + e.getMessage());
		}
	}

	@After
	public void tearDown() throws Exception {
		try {
			Connector con = new Connector();
			con.doQuery("DELETE FROM commodityBatch WHERE supplier= 10");
		} catch(DALException e) {
			fail("Error: " + e.getMessage());
			System.getenv("DATABASE_URL")
		}
	}

	@Test
	public void createSupplier() {
		SupplierDTO expected = new SupplierDTO(10, "Test");
		
		try {
			dao.createSupplier(expected);
			SupplierDTO actual = dao.getSupplier(10);
			assertEquals(expected.toString(), actual.toString());
		} catch(DALException e) {
			fail("Error: " + e.getMessage());
		}
	}
	
	
	@Test
	public void updateSupplier() {
		SupplierDTO expected = new SupplierDTO(10, "Test");
		SupplierDTO updateExpected = new SupplierDTO(10, "Superman");
		
		try {
			dao.createSupplier(expected);
			dao.updateSupplier(updateExpected);
			SupplierDTO actual = dao.getSupplier(10);
			assertEquals(expected.toString(), actual.toString());
		} catch(DALException e) {
			fail("Error: " + e.getMessage());
		}
	}

}
