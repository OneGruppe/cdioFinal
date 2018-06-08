package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.dao.*;

@RunWith(Suite.class)

@SuiteClasses({CommodityBatchDAOTest.class, CommodityDAOTest.class, ProductBatchComponentDAOTest.class, ProductBatchDAOTest.class, RecipeComponentDAOTest.class, RecipeDAOTest.class, SupplierDAOTest.class, UserDAOTest.class})
public class AllTests {
	
}