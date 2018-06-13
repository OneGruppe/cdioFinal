package test.weight;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import boundary.weight.WeightTranslation;
import data.connector.Constant;
import exceptions.WeightException;

public class WeightTranslateTEST {

	WeightTranslation weight;

	@Before
	public void startUp() 
	{
			try {
				weight = new WeightTranslation(Constant.weightPortOne);
			} catch (IOException | WeightException e) {
				System.out.println(e.getMessage());
			}
	}

	@After
	public void wrapUp()
	{
		try 
		{
			weight.closeAllLeaks();
		} 
		catch (WeightException e) 
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Shows a message that is possible to show.
	 */
	@Test
	public void showMsgTest()
	{
		try 
		{
			weight.showMsg("Short");
			TimeUnit.MILLISECONDS.sleep(200);
			weight.removeMsg();
		} 
		catch (WeightException | InterruptedException e) 
		{
			fail("showMsgTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Shows a message that is too long, and therefore shows
	 */
	@Test
	public void showMsgTooLongTest()
	{
		try 
		{
			weight.showMsg("Msg too long");
			TimeUnit.MILLISECONDS.sleep(200);
			weight.removeMsg();
		} 
		catch (WeightException | InterruptedException e) 
		{
			fail("showMsgTooLongTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Shows a long message
	 */
	@Test
	public void showLongMsgTest()
	{
		try 
		{
			weight.showLongMsg("This msg can contain 30 chars");
			TimeUnit.MILLISECONDS.sleep(200);
			weight.removeLongMsg();
		} 
		catch (WeightException | InterruptedException e) 
		{
			fail("showLongMsgTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Shows a long message, that is too long
	 */
	@Test
	public void showTooLongLongMsgTest()
	{
		try 
		{
			weight.showLongMsg("This msg is too long to be shown");
			TimeUnit.MILLISECONDS.sleep(200);
			weight.removeLongMsg();
		} 
		catch (WeightException | InterruptedException e) 
		{
			fail("showTooLongLongM - Error: " + e.getMessage());
		}
	}

	/*
	 * uses the inputWithMsg and prints out the response
	 */
	@Test
	public void getInputWithMsgTest()
	{
		try 
		{
			int response = weight.getInputWithMsg("Enter kilo", 0, " kg");
			System.out.println("Response from weight: '" + response + "'");
		} 
		catch (WeightException e) 
		{
			fail("getInputWithMsgTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Returns the weight
	 */
	@Test
	public void getWeightTest()
	{
		try 
		{
			double value = weight.getWeight();
			System.out.println("Weight:" + value);
		} 
		catch (WeightException e) 
		{
			fail("getWeightTest - Error: " + e.getMessage());
		}
	}

	/**
	 * Returns the Tara, and set the tara value
	 */
	@Test
	public void getTaraWeightTest() 
	{
		try 
		{
			double value = weight.getTaraWeight();
			System.out.println("Weight tara:" + value);
			weight.removeTaraWeight();
		} 
		catch (WeightException e) 
		{
			fail("getWeightTest - Error: " + e.getMessage());
		}
	}


}
