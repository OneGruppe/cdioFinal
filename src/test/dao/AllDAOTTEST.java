package test.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.dao.*;

@RunWith(Suite.class)


@SuiteClasses({CommodityBatchDAOTEST.class, CommodityDAOTEST.class, ProductBatchComponentDAOTest.class, ProductBatchDAOTEST.class, RecipeComponentDAOTEST.class, RecipeDAOTEST.class, SupplierDAOTEST.class, UserDAOTEST.class})
public class AllDAOTTEST {
	
}
