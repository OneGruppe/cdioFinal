package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.dao.*;

@RunWith(Suite.class)

@SuiteClasses({SupplierDAOTest.class})
public class AllTests {
	
	//RecipeDAOTest.class, UserDAOTest.class
	
}