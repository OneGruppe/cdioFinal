package test.weight;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import boundary.weight.WeightTranslation;
import exceptions.DALException;

public class WeightTest {

	WeightTranslation weight;

	@Before
	public void startUp() {
		try {
			weight = new WeightTranslation("62.79.16.17", 8001);
		} catch (DALException e) {
			fail("Error: " + e.getMessage());
		}
	}
	
	@After
	public void wrapUp()
	{
		try {
			weight.closeAllLeaks();
		} catch (DALException e) {
			fail("Error: " + e.getMessage());
		}
	}
	
	@Test
	public void showShortMsgTest()
	{
		try {
			showMsgTest();
			TimeUnit.SECONDS.sleep(2);
			removeMsgTest();
			showTooLongMsg();
		} catch (InterruptedException e) {
			fail("Error: " + e.getMessage());
		}
	}

	
	public void showMsgTest()
	{
		try {
			weight.showMsg("Hello");
		} catch (DALException e) {
			fail("Error: " + e.getMessage());
		}
	}
	
	public void removeMsgTest()
	{
		try {
			weight.removeMsg();
		} catch (DALException e)
		{
			fail("Error: " + e.getMessage());
		}
	}
	
	public void showTooLongMsg()
	{
		try {
			weight.showMsg("Hello with youuuuuuuu");
			fail("Somehow the message was sent");
		} catch (DALException e) {
			System.out.println("showTooLongMsg made error correctly");
		}
	}
	

	
}
