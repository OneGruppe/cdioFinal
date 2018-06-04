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
	 * Creates a connection to the given URL
	 * @param url to MySQL Database
	 * @param username for MySQL user
	 * @param password for MySQL user
	 * @return a connection to the database URL
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static Connection connectTo(String url, String username, String password) 
	throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		// call the driver class' no argument constructor
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		// get Connection-object via DriverManager
		return (Connection) DriverManager.getConnection(url, username, password);
	}
	
	private static Connection conn;
	private static Statement stm;
	
	/**
	 * Constructor for the connector class
	 * @param server
	 * @param port
	 * @param database
	 * @param username
	 * @param password
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connector(String server, int port, String database, String username, String password) 
	throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		conn	= connectTo("jdbc:mysql://"+server+":"+port+"/"+database, username, password);
		stm		= conn.createStatement();
	}
	
	/**
	 * Constructor using the constants from the Constant class 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connector() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		this(Constant.server, Constant.port, Constant.database, Constant.username, Constant.password);
	}
	
	/**
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
