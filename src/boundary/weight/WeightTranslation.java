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

	/**
	 * Constructor that takes in the IP of the weight.
	 * @param ip The ip that is used to connect to the weight (62.79.16.17)
	 * @param port The port that is used to connect to the weight (port is 2.2=8000 and 2.3=8001)
	 * @throws DALException 
	 */
	public WeightTranslation(String ip, int port) throws DALException 
	{
		try 
		{
			// create socket connection with ip and port, delivered from Main
			socket = new Socket(ip, port);
			// initialize the writer and the reader with the socket output and input stream
			write = new PrintWriter(socket.getOutputStream(), true);
			read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			showMsg("Init");
			removeMsg();
		}
		catch (IOException e) 
		{
			throw new DALException("Error in connecting to the weight" + e.getMessage());
		}
	}

	/**
	 * Shows message on weight, can only show 6 char's
	 * @param recvMessage that is shown on weight.
	 * @throws IOException if error, an IOExeption is thrown.
	 */
	public void showMsg(String recvMessage) throws DALException 
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
				throw new DALException("Command understood, parameter wrong or balance with	no display.");
			case "DW":
				clearDisplayAndShowWeight();
				showMsg(message);
			case "ES":
				showMsg(message);
				break;
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
				// success
				break;
			case "D I":
				System.out.println("Command to removeMsg returned an error");
			case "ES":
				removeMsg();
				break;
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
	 * Shows a long message, can only show 30 char's
	 * @param message the message that is printed on the weight.
	 * @throws DALException
	 */
	public void showLongMsg(String recvMessage) throws DALException 
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
				throw new DALException("Error showing message in weight");
			case "ES":
				showLongMsg(message);
				break;
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
	 * Removes a long message
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
				// success
				break;
			case "P111 I":
				System.out.println("Command to removeLongMsg returned an error");
			case "P111 L":
				throw new DALException("Error in removing message on weight");
			case "ES":
				removeLongMsg();
				break;
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
	 * Shows a message on the display where the weighter must send a message back.
	 * @param promtMessage Promt string (max. 24 characters)
	 * @param message2 Text/Value to be displayed as default, and to be overwritten by user input. (max. 24 characters)
	 * @param unit Unit (max. 7 characters)
	 * @return
	 * @throws DALException
	 */
	public String getInputWithMsg(String promtMessage, String message2, String unit) throws DALException 
	{
		try
		{
			String correctedPromtMessage = promtMessage, correctedMessage2 = message2, correctedUnit = unit;
			if(promtMessage.length() > 24)
			{
				correctedPromtMessage = promtMessage.substring(0, 24);
			}
			if(message2.length() > 24)
			{
				correctedMessage2 = message2.substring(0, 24);
			}
			if(unit.length() > 8)
			{
				correctedUnit = unit.substring(0, 7);
			}
			write.println("RM20 8 " + "\"" + correctedPromtMessage + "\" \"" + correctedMessage2 + "\" \"&3" + correctedUnit + "\"");
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
				clearDisplayAndShowWeight();
				getInputWithMsg(correctedPromtMessage, correctedMessage2, correctedUnit);
			case "ES":
				getInputWithMsg(correctedPromtMessage, correctedMessage2, correctedUnit);
				break;
			default:
				if(response.subSequence(0, 6).equals("RM20 A"))
				{
					String subResponse = response.substring(8, response.length()-1);

					if(subResponse.equals(correctedMessage2)) {
						return "";
					}
					else
					{
						return subResponse;
					}
				}
				else
				{
					throw new DALException("Error showing getInputWithMsg - weight returns: " + response);
				}
			}
			return null;
		} 
		catch(IOException e) 
		{
			throw new DALException("Error getting the input");
		}
	}


	/**
	 * Removes the displayed message on the weight.
	 * @throws DALException
	 */
	public void removeInputWithMsg() throws DALException 
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
				throw new DALException("Error in removeInputWithMsg - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new DALException("Cannot read line from Weight - " + e.getMessage());
		}

	}

	/**
	 * Will take the current weight load of the weight and pull it into a double.
	 * @return weight Weight in the form of a double
	 * @throws DALException
	 */
	public double getWeight() throws DALException 
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
				throw new DALException("Upper limit of taring range exceeded.");
			case "S -":
				throw new DALException("Lower limit of taring range exceeded.");
			case "ES":
				break;
			default:
				if((response.subSequence(0, 3).equals("S S")))
				{
					return Double.parseDouble(response.substring(9, (response.length() - 3)));
				}
				else
				{
					throw new DALException("Error showing getInputWithMsg - weight returns: " + response);
				}
			}

			// extracts only the numbers from response to a string
			String weightString = response.substring(3, (response.length() - 2));

			// convert from string to double.
			double weight = Double.parseDouble(weightString);
			return 0;

		} 
		catch(IOException e) 
		{
			throw new DALException("Error showing weight");
		}
	}

	/**
	 * Will set the tara weight on the weight to what's currently the weights' load.
	 * @return weight Weight in the form of a double
	 * @throws DALException
	 */
	public double getTaraWeight() throws DALException
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
				throw new DALException("Upper limit of taring range exceeded.");
			case "T -":
				throw new DALException("Lower limit of taring range exceeded.");
			case "ES":
				break;
			default:
				if(response.subSequence(0, 3).equals("T S"))
				{
					return Double.parseDouble(response.substring(9, (response.length() - 2)));
				}
				else
				{
					throw new DALException("Error showing getInputWithMsg - weight returns: " + response);
				}
			}
			return 0;
		} 
		catch (IOException e) 
		{
			throw new DALException("Error showing Tara weight");
		}
	}

	/**
	 * Remove the tara weight from the weight.
	 * @throws DALException
	 */
	public void removeTaraWeight() throws DALException
	{
		try
		{
			write.println("TA 0");
			String response = read.readLine();

			switch (response)
			{
			case "TA A":
				// success
				break;
			case "TA I":
				System.out.println("Command to removeTaraWeight returned an error");
			case "TA L":
				System.out.println("Command to removeTaraWeight returned an error");
			case "ES":
				break;
			default:
				throw new DALException("Error in removeTaraWeight - weight returns: " + response);
			}
		}
		catch (IOException e) 
		{
			throw new DALException("Error showing Tara weight");
		}
	}

	/**
	 * Shows the normal weight-mode on the display
	 * @throws DALException
	 */
	public void showWeight() throws DALException 
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
				throw new DALException("Error showing weight-display - weight returns: " + response);
			}
		} 
		catch (IOException e) 
		{
			throw new DALException("Cannot read line from Weight - " + e.getMessage());
		}
	}

	/**
	 * Clearing all that can be cleared, removeMsg() + removeLongMsg() + removeInputWithMsg() + showWeightDisplay()
	 * @throws DALException
	 */
	public void clearDisplayAndShowWeight() throws DALException
	{
		removeMsg();
		removeLongMsg();
		removeInputWithMsg();
		showWeight();
	}

	/**
	 * Shuts down the weight remotely, but only with the physical weight
	 * @throws DALException
	 */
	public void shutdownWeight() throws DALException
	{
		try 
		{
			clearDisplayAndShowWeight();
			write.println("PWR 0");
			read.readLine();
			write.println("PWR 0");
			read.readLine();
		}
		catch (IOException e) 
		{
			throw new DALException(e.getMessage());
		}
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
			throw new DALException(e.getMessage());
		}
	}

}
