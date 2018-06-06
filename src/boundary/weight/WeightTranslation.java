package boundary.weight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import exceptions.DALException;

public class WeightTranslation {

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
	public WeightTranslation(String ip) throws DALException {

		try {
			// create socket connection with ip and port, delivered from Main
			socket = new Socket(ip, WEIGHT_PORT);

			// initialize the writer and the reader with the socket output and input stream
			write = new PrintWriter(socket.getOutputStream(), true);
			read = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// catch of exceptions
		} catch (IOException e) {
			throw new DALException();
		}
	}

	/**
	 * Shows a message on the display on the weight.
	 *
	 * @param message
	 * @throws IOException
	 */
	public void showMsg(String message) throws DALException {

			// write commands to the weight (open telnet)
			write.println("D "+ "\"" + message + "\"");
	}

	/**
	 * Shows a longer message on the display on the weight.
	 * @param message
	 */
	public void showLongMsg(String message) throws DALException {
			write.println("P111 " + "\"" + message + "\"");
	}

	/**
	 * Removes the displayed message on the weight.
	 */
	public void removeMsg() throws DALException {

			// Write commends to the weight (open telnet)
			write.println("DW");
	}

	/**
	 * Shows a message on the display where the weighter must send a message back.
	 * @param message 
	 * @return ID
	 * @throws DALException
	 */
	public int getInputWithMsg(String message) throws DALException {

		try {
			//Sends message to weight with a given message
			write.println("RM20 8 " + "\"" + message + "\" " + "\" \" " + "\"&3\"");

			//Reads the input the user response with
			String response = read.readLine();

			// creates a string that only consists of the numbers in response
			String InputString = response.substring(8, (response.length() - 1));

			if(InputString.equals("")) {
				return 0;
			}

			int resultInt = Integer.parseInt(InputString);
			return resultInt;

		} catch(IOException e) {
			throw new DALException("Error getting the input");
		}
	}

	/**
	 * Will take the current weight load of the weight and pull it into a double.
	 * @return weight
	 * @throws IOException
	 */
	public double getWeight() throws DALException {

		try {
			// S command retrieves weight
			write.println("S");
			
			String response = read.readLine();

			// extracts only the numbers from response to a string
			String weightString = response.substring(9, (response.length() - 2));

			// convert from string to double.
			double weight = Double.parseDouble(weightString);
			return weight;

		} catch(IOException e) {
			throw new DALException("Error showing weight");
		}
	}

	/**
	 * Will set the tara weight on the weight to what's currently the weights' load.
	 * @return weight
	 * @throws InterruptedException 
	 * @throws IOException
	 */
	public double setTaraWeight() throws DALException, InterruptedException {

		try {
			// T command retrieves weight
			write.println("T");
			String response = read.readLine();

			// extracts only the numbers from response to a string
			String weightString = response.substring(9, (response.length() - 2));

			// convert from string to double.
			double weight = Double.parseDouble(weightString);
			return weight;

		} catch (IOException e) {
			throw new DALException("Error showing Tara weight");
		}
	}

//	/**
//	 * 
//	 * @return msgread
//	 * @throws DALException
//	 */
//	public String waitForMessage() throws DALException {
//		try {
//			String msgread = read.readLine();
//			return msgread;
//		} catch (IOException e) {
//			throw new DALException("Error trying to get message");
//		}
//	}

	/**
	 * Shuts down the weight remotely with input 1 for the simulator and 2 for the physical weight.
	 * @param weight
	 * @throws DALException
	 * @throws IOException
	 */
	public void shutdownWeight(int weight) throws DALException{
		if(weight == 1) { // Virtual Shutdown
			write.println("Q ");
		}
		else if(weight == 2) {
			write.println("PWR 0");
		}
	}

	/**
	 * Sets the weight in the simulator where the parameter is the wished weight in double format.
	 * @param wantedWeight
	 * @throws DALException
	 */
	public void setVirtualWeight(double wantedWeight) throws DALException{
		write.println("B " + wantedWeight);
	}

	/**
	 * Closes all open objects
	 * @throws DALException
	 */
	public void closeAllLeaks() throws DALException {
		try {
			socket.close();
			write.close();
			read.close();

		} catch (IOException e) {
			throw new DALException();
		}
	}

}
