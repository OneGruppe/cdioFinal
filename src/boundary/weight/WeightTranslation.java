package boundary.weight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import exceptions.DALException;

public class WeightTranslation 
{

	// declare socket to open connection to TCP/Telnet
	// declare Writer and reader for I/O
	private Socket socket;
	private PrintWriter write;
	private BufferedReader read;

	private final int WEIGHT_PORT = 8000; 

	/**
	 * Constructor that takes in the IP of the weight.
	 * @param ip 
	 * @throws DALException 
	 */
	public WeightTranslation(String ip) throws DALException 
	{
		try 
		{
			// create socket connection with ip and port, delivered from Main
			socket = new Socket(ip, WEIGHT_PORT);

			// initialize the writer and the reader with the socket output and input stream
			write = new PrintWriter(socket.getOutputStream(), true);
			read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// catch of exceptions
		} 
		catch (IOException e) 
		{
			throw new DALException("Error in connecting to the weight" + e.getMessage());
		}
	}

	/**
	 * Shows message on weight.
	 * @param message that is shown on weight.
	 * @throws IOException if error, an IOExeption is thrown.
	 */
	public void showMsg(String message) throws DALException 
	{
		write.println("D "+ "\"" + message + "\"");
		try 
		{
			String response = read.readLine();
			switch (response)
			{
			case "D A":
				System.out.println("showMsg Command to showMsg returned success");
				break;
			case "D I":
				System.out.println("showMsg - another thing blocks the display, removing and trying again.");
				clearDisplayAndShowWeight();
				showMsg(message);
			case "D L":
				throw new DALException("Command understood, parameter wrong or balance with	no display.");
			case "DW":
				clearDisplayAndShowWeight();
				showMsg(message);
			default:
				throw new DALException("Error showing message on weight - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new DALException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * Removes a normal message on weight.
	 * @param message that is shown on weight, send "" in param to clear text.
	 * @throws IOException if error, an IOExeption is thrown.
	 */
	public void removeMsg() throws DALException 
	{
		write.println("D \"\"");
		try
		{
			String response = read.readLine();
			switch (response)
			{
			case "D A":
				System.out.println("Command to removeMsg returned success");
				break;
			case "D I":
				System.out.println("Command to removeMsg returned an error");
			default:
				throw new DALException("Error showing message on weight - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new DALException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * Viser en lang besked p� display
	 * @param message Den besked der vises på v�gten.
	 */
	public void showLongMsg(String message) throws DALException 
	{
		write.println("P111 " + "\"" + message + "\"");
		try 
		{
			String response = read.readLine();
			switch (response) 
			{
			case "P111 A":
				System.out.println("Command to showMsg returned success");
				break;
			case "P111 I":
				System.out.println("showLongMsg - another thing blocks the display, removing and trying again.");
				clearDisplayAndShowWeight();
				showLongMsg(message);
			case "P111 L":
				throw new DALException("Error showing message in weight");
			case "DW":
				showWeightDisplay();
				removeMsg();
			default:
				throw new DALException("Error showing long message on weight - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new DALException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * removeLongMsg - 
	 * @throws DALException
	 */
	public void removeLongMsg() throws DALException
	{
		write.println("P111 \"\"");
		try 
		{
			String response = read.readLine();
			switch (response) 
			{
			case "P111 A":
				System.out.println("Command to showMsg returned success");
				break;
			case "P111 I":
				System.out.println("Command to removeMsg returned an error");
			case "P111 L":
				throw new DALException("Error in removing message on weight");
			default:
				throw new DALException("Error in removing long message in weight - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new DALException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * Shows the normal weight-mode on the display
	 * @throws DALException
	 */
	public void showWeightDisplay() throws DALException 
	{
		try 
		{
			write.println("DW");
			read.readLine();
			String response = read.readLine();

			switch (response) 
			{
			case "DW A":
				System.out.println("Command to showWeightDisplay returned success");
				break;
			case "DW I":
				System.out.println("Command to showWeightDisplay returned an error");
			default:
				throw new DALException("Error showing weight-display - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new DALException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * Shows a message on the display where the weighter must send a message back.
	 * @param message 
	 * @return ID
	 * @throws DALException
	 */
	public String getInputWithMsg(String message) throws DALException 
	{
		try
		{
			write.println("RM20 8 " + "\"" + message + "\" " + "\" \" " + "\"&3\"");

			read.readLine();
			String response = read.readLine();

			switch (response) 
			{
			case "RM20 A":
				System.out.println("Command to getInputWithMsg returned success");
				break;
			case "RM20 I":
				System.out.println("Command to getInputWithMsg returned an error");
			default:
				throw new DALException("Error showing getInputWithMsg - weight returns: " + response);
			}
			
			return resultInt;

		} 
		catch(IOException e) 
		{
			throw new DALException("Error getting the input");
		}
		return "Error";
	}
	
	/**
	 * Removes the displayed message on the weight.
	 */
	public void removeInputWithMsg() throws DALException {

			// Write commends to the weight (open telnet)
			write.println("RM20 0");
			try {
				String response = read.readLine();
			} catch (IOException e) {
				throw new DALException(e.getMessage());
			}
	}

	/**
	 * Will take the current weight load of the weight and pull it into a double.
	 * @return weight
	 * @throws IOException
	 */
	public double getWeight() throws DALException 
	{

		try 
		{
			// S command retrieves weight
			write.println("S");

			String response = read.readLine();

			// extracts only the numbers from response to a string
			String weightString = response.substring(9, (response.length() - 2));

			// convert from string to double.
			double weight = Double.parseDouble(weightString);
			return weight;

		} 
		catch(IOException e) 
		{
			throw new DALException("Error showing weight");
		}
	}

	/**
	 * Will set the tara weight on the weight to what's currently the weights' load.
	 * @return weight
	 * @throws InterruptedException 
	 * @throws IOException
	 */
	public double setTaraWeight() throws DALException, InterruptedException 
	{
		try
		{
			// T command retrieves weight
			write.println("T");
			String response = read.readLine();

			// extracts only the numbers from response to a string
			String weightString = response.substring(9, (response.length() - 2));

			// convert from string to double.
			double weight = Double.parseDouble(weightString);
			return weight;
		} 
		catch (IOException e) 
		{
			throw new DALException("Error showing Tara weight");
		}
	}

	private void clearDisplayAndShowWeight() throws DALException
	{
		removeMsg();
		removeLongMsg();
		showWeightDisplay();
	}

	/**
	 * Shuts down the weight remotely with input 1 for the simulator and 2 for the physical weight.
	 * @param weight
	 * @throws DALException
	 * @throws IOException
	 */
	public void shutdownWeight(int i) throws DALException
	{
		// Virtual Shutdown
		if(i == 1) 
		{ 
			write.println("Q ");
		}
		else if(i == 2) 
		{
			write.println("PWR 0");
		}
	}

	/**
	 * Sets the weight in the simulator where the parameter is the wished weight in double format.
	 * @param wantedWeight
	 * @throws DALException
	 */
	public void setVirtualWeight(double wantedWeight) throws DALException
	{
		write.println("B " + wantedWeight);
	}

	/**
	 * Closes all open objects
	 * @throws DALException
	 */
	public void closeAllLeaks() throws DALException 
	{
		try 
		{
			socket.close();
			write.close();
			read.close();

		} 
		catch (IOException e) 
		{
			throw new DALException();
		}
	}

}
