package data.connector;

public class Constant {

	public static final String
	dbServer					= "diplomportal.c2nouactg6m6.eu-west-1.rds.amazonaws.com", 
	databaseName				= "s160198",
	dbUsername					= System.getenv("cdioFinal12.SQL.User"), 
	dbPassword					= System.getenv("cdioFinal12.SQL.Password"),
	weightConstantIP			= "62.79.16.17";

	public static final int
	dbPort					= 3306,
	weightPortOne				= 8000,
	weightPortTwo				= 8001;
}
