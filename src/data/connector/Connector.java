package data.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.DALException;

public class Connector 
{
	/**
	 * <h1> <i>connectTo</i> </h1> <br>
	 * Establishes connection to given URL
	 * @param url to MySQL Database
	 * @param username for MySQL user
	 * @param password for MySQL user
	 * @return a connection to the database URL
	 * @throws DALException 
	 */
	public static Connection connectTo(String url, String username, String password) throws DALException
	{
		
		try 
		{
			// call the driver class' no argument constructor
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// get Connection-object via DriverManager
			return (Connection) DriverManager.getConnection(url, username, password);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			throw new DALException(e.getMessage());
		}
		
		
	}
	
	private static Connection conn;
	private static Statement stm;
	
	/**
	 * <h1> <i>Connector</i> </h1> <br>
	 * Constructor for the connector class
	 * @param server
	 * @param port
	 * @param database
	 * @param username
	 * @param password
	 * @throws DALException
	 */
	public Connector(String server, int port, String database, String username, String password) throws DALException
	{
		conn	= connectTo("jdbc:mysql://"+server+":"+port+"/"+database, username, password);
		try {
			stm		= conn.createStatement();
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
	}
	
	/**
	 * <h1> <i>Connector</i> </h1> <br>
	 * Constructor using the constants from the Constant class 
	 * and the Constructor from this class with the "this" keyword
	 * to create connection. 
	 * @throws DALException
	 */
	public Connector() throws DALException
	{
		this(Constant.server, Constant.port, Constant.database, Constant.username, Constant.password);
	}
	
	/**
	 * <h1> <i>doQuery</i> </h1> <br>
	 * Executes a query command to SQL database
	 * @param command (SQL query command)
	 * @return a ResultSet object of data produced by the given query command
	 * @throws DALException
	 */
	public ResultSet doQuery(String command) throws DALException
	{
		try {
			return stm.executeQuery(command);
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
	}
	
	/**
	 * <h1> <i>doUpdate</i> </h1> <br>
	 * Executes an updating command to SQL database
	 * @param command (SQL query command for updates)
	 * @return an Interger. Either row count for SQL DML or 0 for SQL that returns nothing
	 * @throws DALException
	 */
	public int doUpdate(String command) throws DALException
	{
		try {
			return stm.executeUpdate(command);
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
	}
}
