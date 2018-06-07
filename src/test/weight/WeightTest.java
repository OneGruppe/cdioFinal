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

	public void doConnect() {
		try {
			//weight = new WeightTranslation("169.254.2.3", 8000);
			 weight = new WeightTranslation("62.79.16.17", 8001);
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Before
	public void startUp() {
		doConnect();
	}

	@After
	public void wrapUp()
	{
		try {
			weight.closeAllLeaks();
		} catch (DALException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Shows a message that is possible to show.
	 */
	@Test
	public void showMsgTest()
	{
		try {
			weight.showMsg("Short");
			TimeUnit.MILLISECONDS.sleep(200);
			weight.removeMsg();
		} catch (DALException | InterruptedException e) {
			fail("showMsgTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Shows a message that is too long, and therefore shows
	 */
	@Test
	public void showMsgTooLongTest()
	{
		try {
			weight.showMsg("Msg too long");
			TimeUnit.MILLISECONDS.sleep(200);
			weight.removeMsg();
		} catch (DALException | InterruptedException e) {
			fail("showMsgTooLongTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Shows a long message
	 */
	@Test
	public void showLongMsgTest()
	{
		try {
			weight.showLongMsg("This msg can contain 30 chars");
			TimeUnit.MILLISECONDS.sleep(200);
			weight.removeLongMsg();
		} catch (DALException | InterruptedException e) {
			fail("showLongMsgTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Shows a long message, that is too long
	 */
	@Test
	public void showTooLongLongMsg()
	{
		try {
			weight.showLongMsg("This msg is too long to be shown");
			TimeUnit.MILLISECONDS.sleep(200);
			weight.removeLongMsg();
		} catch (DALException | InterruptedException e) {
			fail("showTooLongLongM - Error: " + e.getMessage());
		}
	}
	
	/**
	 * Returns the weight
	 */
	@Test
	public void getWeightTest()
	{
		try {
			double value = weight.getWeight();
			System.out.println("Weight:" + value);
		} catch (DALException e) {
			fail("getWeightTest - Error: " + e.getMessage());
		}
	}
	
	/**
	 * Returns the Tara, and set the tara value
	 */
	@Test
	public void getTaraWeightTest() 
	{
		try {
			double value = weight.getTaraWeight();
			System.out.println("Weight tara:" + value);
		} catch (DALException e) {
			fail("getWeightTest - Error: " + e.getMessage());
		}
	}


}
