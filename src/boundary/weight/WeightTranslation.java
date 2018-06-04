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
	 * Konstruktør tager imod IP og forbinder til den ønskede IP
	 * @param ip IP'en der skal forbindes til
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
	 * Viser en besked på display
	 *
	 * @param message Den besked der vises på UI.
	 * @throws IOException Hvis der sker en fejl, bruges IOExeption
	 */
	public void showMsg(String message) throws DALException {

			// write commands to the weight (open telnet)
			write.println("D "+ "\"" + message + "\"");
	}

	/**
	 * Viser en lang besked på display
	 * @param message Den besked der vises på vægten.
	 */
	public void showLongMsg(String message) throws DALException {
			write.println("P111 " + "\"" + message + "\"");
	}

	/**
	 * Fjerner beskeden fra display
	 */
	public void removeMsg() throws DALException {

			// Write commends to the weight (open telnet)
			write.println("DW");
	}

	/**
	 * Skriver en besked til vægten og for et input fra brugeren tilbage.
	 * @param message Den besked der skal vises til brugeren
	 * @return ID på det som brugeren har tastet ind
	 * @throws DALException Brugerdefineret Exception
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
	 * Trækker information om nuværende vægt-info
	 *
	 * @return Vægt i double
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
	 * Trækker information om nuværende Tara-vægt
	 *
	 * @return Tara vægt i double
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

	/**
	 * Modtager en besked fra brugeren
	 * @return Den besked der blev indtastet af brugeren
	 * @throws DALException
	 */
	public String waitForMessage() throws DALException {
		try {
			String msgread = read.readLine();
			return msgread;
		} catch (IOException e) {
			throw new DALException("Error trying to get message");
		}
	}

	/**
	 * Slukker vægten
	 * @param i 1 for simulatoren, 2 for den fysiske maskine
	 * @throws DALException
	 * @throws IOException
	 */
	public void shutdownWeight(int i) throws DALException{
		if(i == 1) { // Virtual Shutdown
			write.println("Q ");
		}
		else if(i == 2) {
			write.println("PWR 0");
		}
	}

	/**
	 * Sætter vægten i simulatoren.
	 * @param wantedWeight Den ønskede vægt simlatoren skal stå på.
	 * @throws DALException
	 */
	public void setVirtualWeight(double wantedWeight) throws DALException{
		write.println("B " + wantedWeight);
	}

	/**
	 * Lukker alle de objekter vi har åbnet.
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
