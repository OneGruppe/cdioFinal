package boundary.weight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import boundary.weight_interface.IWeightTranslation;
import config.Constant;
import exceptions.DALException;
import exceptions.WeightException;

public class WeightTranslation implements IWeightTranslation{

	// declare socket to open connection to TCP/Telnet
	// declare Writer and reader for I/O
	private Socket socket;
	private PrintWriter write;
	private BufferedReader read;

	/**
	 * Constructor that takes in the port of the weight.
	 * After connection start, the 
	 * Ports can be recieved from Constant-class.
	 * @param port
	 * @throws DALException if the initial show+remove fails
	 * @throws IOException if connection failed
	 * @throws WeightException if initial showMsg("Init") and removeMsg fails
	 */
	public WeightTranslation(int port) throws IOException, WeightException
	{
		try 
		{
			// create socket connection with ip and port, delivered from Main
			socket = new Socket(Constant.weightConstantIP, port);
			// initialize the writer and the reader with the socket output and input stream
			write = new PrintWriter(socket.getOutputStream(), true);
			read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			showMsg("Init");
			removeMsg();
		}
		catch (IOException e) 
		{
			throw new IOException("Cannot connect to the weight" + e.getMessage());
		}
	}

	/**
	 * Shows message on weight, can only show 6 char's
	 * @param recvMessage that is shown on weight.
	 * @throws WeightException 
	 */
	public void showMsg(String recvMessage) throws WeightException
	{
		String message = recvMessage;
		if (message.length() > 5)
		{
			message = message.substring(0, 6);
		}
		write.println("D "+ "\"" + message + "\"");
		try 
		{
			String response = read.readLine();
			switch (response)
			{
			case "D A":
				// success
				break;
			case "D I":
				System.out.println("showMsg - another thing blocks the display, removing and trying again.");
				clearDisplayAndShowWeight();
				showMsg(message);
			case "D L":
				throw new WeightException("Command understood, parameter wrong or balance with	no display.");
			case "DW":
				clearDisplayAndShowWeight();
				showMsg(message);
			case "ES":
				showMsg(message);
				break;
			default:
				throw new WeightException("Error showing message on weight - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new WeightException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * Removes a normal message on weight.
	 * @param message that is shown on weight, send "" in param to clear text.
	 * @throws WeightException
	 */
	public void removeMsg() throws WeightException
	{
		write.println("D \"\"");
		try
		{
			String response = read.readLine();
			switch (response)
			{
			case "D A":
				// success
				break;
			case "D I":
				System.out.println("Command to removeMsg returned an error");
			case "ES":
				removeMsg();
				break;
			default:
				throw new WeightException("Error showing message on weight - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new WeightException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * Shows a long message, can only show 30 char's
	 * @param message the message that is printed on the weight.
	 * @throws WeightException 
	 */
	public void showLongMsg(String recvMessage) throws WeightException
	{
		String message = recvMessage;
		if (message.length() > 30)
		{
			message = message.substring(0, 30);
		}
		write.println("P111 " + "\"" + message + "\"");
		try 
		{
			String response = read.readLine();
			switch (response) 
			{
			case "P111 A":
				// success
				break;
			case "P111 I":
				System.out.println("Command to showLongMsg - another thing blocks the display, removing and trying again.");
				clearDisplayAndShowWeight();
				showLongMsg(message);
			case "P111 L":
				throw new WeightException("Error showing message in weight");
			case "ES":
				showLongMsg(message);
				break;
			default:
				throw new WeightException("Error showing long message on weight - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new WeightException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * Removes a long message
	 * @throws WeightException
	 */
	public void removeLongMsg() throws WeightException
	{
		write.println("P111 \"\"");
		try 
		{
			String response = read.readLine();
			switch (response) 
			{
			case "P111 A":
				// success
				break;
			case "P111 I":
				System.out.println("Command to removeLongMsg returned an error");
			case "P111 L":
				throw new WeightException("Error in removing message on weight");
			case "ES":
				removeLongMsg();
				break;
			default:
				throw new WeightException("Error in removing long message in weight - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new WeightException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * Shows a message on the display where the weighter must send a message back.
	 * @param promtMessage Promt string (max. 24 characters)
	 * @param defaultNumber Text/Value to be displayed as default, and to be overwritten by user input. (max. 24 characters)
	 * @param unit Unit (max. 7 characters)
	 * @return int message
	 * @throws WeightException
	 */
	public int getInputWithMsg(String promtMessage, int defaultNumber, String unit) throws WeightException
	{
		try
		{
			String correctedPromtMessage = promtMessage, correctedDefaultNumber = "", correctedUnit = unit;
			if(promtMessage.length() > 24)
			{
				correctedPromtMessage = promtMessage.substring(0, 24);
			}
			if(defaultNumber != 0)
			{
				correctedDefaultNumber = defaultNumber + "";
			}
			if(unit.length() > 8)
			{
				correctedUnit = unit.substring(0, 7);
			}
			write.println("RM20 1 " + "\"" + correctedPromtMessage + "\" \"" + correctedDefaultNumber + "\" \"" + correctedUnit + "\"");
			read.readLine();
			String response = read.readLine();

			switch (response) 
			{
			case "RM20 B":
				// success
				break;
			case "RM20 I":
				System.out.println("Command to getInputWithMsg returned an error");
				break;
			case "RM20 C":
				//TODO clearDisplayAndShowWeight virker ikke?
				//clearDisplayAndShowWeight();
				//getInputWithMsg(correctedPromtMessage, defaultNumber, correctedUnit);
				return -2;
			case "ES":
				getInputWithMsg(correctedPromtMessage, defaultNumber, correctedUnit);
				break;
			default:
				if(response.subSequence(0, 6).equals("RM20 A"))
				{
					String subResponse = response.substring(8, response.length()-1);
					if(subResponse.equals(""))
						return -1;
					else return Integer.parseInt(subResponse);
				}
				else
				{
					throw new WeightException("Error showing getInputWithMsg - weight returns: " + response);
				}
			}
			return -9999;
		} 
		catch(IOException e) 
		{
			throw new WeightException("Error getting the input");
		}
	}


	/**
	 * Removes the displayed message on the weight.
	 * @throws WeightException 
	 */
	public void removeInputWithMsg() throws WeightException
	{

		// Write commends to the weight (open telnet)
		write.println("RM20 0");
		try 
		{
			String response = read.readLine();
			switch (response) 
			{
			case "RM20 A":
				// success
				break;
			case "RM20 I":
				System.out.println("Command to removeInputWithMsg returned an error");
			case "ES":
				removeInputWithMsg();
				break;
			default:
				throw new WeightException("Error in removeInputWithMsg - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new WeightException("Cannot read line from Weight - " + e.getMessage());
		}

	}

	/**
	 * Will take the current weight load of the weight and pull it into a double.
	 * @return weight Weight in the form of a double
	 * @throws WeightException 
	 */
	public double getWeight() throws WeightException
	{
		try 
		{
			// S command retrieves weight
			write.println("S");

			String response = read.readLine();
			switch (response) 
			{
			case "S I":
				clearDisplayAndShowWeight();
				getTaraWeight();
				break;
			case "S +":
				throw new WeightException("Upper limit of taring range exceeded.");
			case "S -":
				throw new WeightException("Lower limit of taring range exceeded.");
			case "ES":
				break;
			default:
				if((response.subSequence(0, 3).equals("S S")))
				{
					return Double.parseDouble(response.substring(9, (response.length() - 3)));
				}
				else
				{
					throw new WeightException("Error showing getInputWithMsg - weight returns: " + response);
				}
			}
			return 0;
		} 
		catch(IOException e) 
		{
			throw new WeightException("Error showing weight");
		}
	}

	/**
	 * Will set the tara weight on the weight to what's currently the weights' load.
	 * @return weight Weight in the form of a double
	 * @throws WeightException 
	 */
	public double getTaraWeight() throws WeightException
	{
		try
		{
			// T command retrieves weight
			write.println("T");
			String response = read.readLine();

			switch (response) 
			{
			case "T I":
				clearDisplayAndShowWeight();
				getTaraWeight();
				break;
			case "T +":
				throw new WeightException("Upper limit of taring range exceeded.");
			case "T -":
				throw new WeightException("Lower limit of taring range exceeded.");
			case "ES":
				break;
			default:
				if(response.subSequence(0, 3).equals("T S"))
				{
					return Double.parseDouble(response.substring(9, (response.length() - 2)));
				}
				else
				{
					throw new WeightException("Error showing getInputWithMsg - weight returns: " + response);
				}
			}
			return 0;
		} 
		catch (IOException e) 
		{
			throw new WeightException("Error showing Tara weight");
		}
	}

	/**
	 * Remove the tara weight from the weight.
	 * @throws WeightException 
	 */
	public void removeTaraWeight() throws WeightException
	{
		try
		{
			write.println("TAC");
			String response = read.readLine();

			switch (response)
			{
			case "TAC A":
				// success
				break;
			case "TAC I":
				System.out.println("Command to removeTaraWeight returned an error - I");
			case "TAC L":
				System.out.println("Command to removeTaraWeight returned an error - L");
			case "ES":
				break;
			default:
				throw new WeightException("Error in removeTaraWeight - weight returns: " + response);
			}
		}
		catch (IOException e) 
		{
			throw new WeightException("Error showing Tara weight");
		}
	}

	/**
	 * Shows the normal weight-mode on the display
	 * @throws WeightException 
	 */
	public void showWeight() throws WeightException
	{
		try 
		{
			write.println("DW");
			read.readLine();
			String response = read.readLine();

			switch (response) 
			{
			case "DW A":
				// success
				break;
			case "DW I":
				System.out.println("Command to showWeightDisplay returned an error");
			case "ES":
				showWeight();
				break;
			default:
				throw new WeightException("Error showing weight-display - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new WeightException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * Clearing all that can be cleared, removeMsg() + removeLongMsg() + removeInputWithMsg() + showWeightDisplay()
	 * @throws WeightException 
	 */
	public void clearDisplayAndShowWeight() throws WeightException
	{
		removeMsg();
		removeLongMsg();
		removeInputWithMsg();
		showWeight();
	}

	/**
	 * Closes all open objects
	 * @throws WeightException 
	 */
	public void closeAllLeaks() throws WeightException
	{
		try 
		{
			socket.close();
			write.close();
			read.close();
		} 
		catch (IOException e) 
		{
			throw new WeightException("Cannot close ressources" + e.getMessage());
		}
	}


}
