package config;

public class Constant {

	public static final String
	/*
	dbServer					= "diplomportal.c2nouactg6m6.eu-west-1.rds.amazonaws.com", 
	databaseName				= "s160198",
	dbUsername					= System.getenv("cdioFinal12_SQL_User"), 
	dbPassword					= System.getenv("cdioFinal12_SQL_Password"),
	weightConstantIP			= "62.79.16.17";
	*/
	
	dbServer					= "nasdino.myds.me", 
	databaseName				= "CDIOFinal",
	dbUsername					= System.getenv("cdioFinal12_NSQL_User"), 
	dbPassword					= System.getenv("cdioFinal12_NSQL_Password"),
	weightConstantIP			= "62.79.16.17";

	public static final int
	//dbPort					= 3306,
	dbPort						= 9865,
	weightPortOne				= 8000,
	weightPortTwo				= 8001;


}
