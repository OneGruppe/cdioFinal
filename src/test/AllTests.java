package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.dao.CommodityBatchDAOTest;
import test.dao.UserDAOTest;

@RunWith(Suite.class)

@SuiteClasses({ UserDAOTest.class, CommodityBatchDAOTest.class })
public class AllTests {

	
}