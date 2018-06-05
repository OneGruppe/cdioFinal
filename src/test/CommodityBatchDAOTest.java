package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.connector.Connector;
import data.dao_implementation.CommodityBatchDAO;
import data.dto.CommodityBatchDTO;
import exceptions.DALException;

public class CommodityBatchDAOTest {
	CommodityBatchDAO dao;
	
	@Before
	public void setUp() throws Exception {
		dao = new CommodityBatchDAO();
	}

	@After
	public void tearDown() throws Exception {
		Connector con = new Connector();
		try {
			con.doQuery("DELETE FROM commodityBatch WHERE commodityBatchID= 10");
		}
		catch (DALException e){
			fail("Error: " + e.getMessage());
		}
	}

	@Test
	public void createCommodityBatch() throws DALException {
		CommodityBatchDTO expected = new CommodityBatchDTO(10, 10, 10.0);
		
		dao.createCommodityBatch(expected);
		CommodityBatchDTO actual = dao.getCommodityBatch(10);
		assertEquals(expected.toString(), actual.toString());	
	}
	
	@Test
	public void updateCommodityBatch() throws DALException {
		CommodityBatchDTO updateExpected = new CommodityBatchDTO(10, 10, 15.0);
		 
		
		dao.updateCommodityBatch(updateExpected);
		CommodityBatchDTO actual = dao.getCommodityBatch(10); 
		assertEquals(updateExpected.toString(), actual.toString());
	}
}
