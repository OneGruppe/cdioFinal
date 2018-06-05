package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.dao.*;

@RunWith(Suite.class)

@SuiteClasses({ CommodityBatchDAOTest.class, ProductBatchDAOTest.class, RecipeDAOTest.class, UserDAOTest.class})
public class AllTests {

}