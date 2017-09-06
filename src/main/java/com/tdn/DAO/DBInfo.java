package com.tdn.DAO;




public class DBInfo {
	
	static String dbHost = "mysql";
	static String dbName = "tdndb";
	static int dbPort = 3306;
	
	static String dbURL = "jdbc:mysql:" + dbHost + ":" + dbPort +"/" +dbName;
	
	static String rootUserName = "root";
	
	static String rootPassword = "tdnrootpassword";
	
	static String jdbcDriver = "com.msql.jdbc.Driver";

	public static String getDbHost() {
		return dbHost;
	}

	public static String getDbName() {
		return dbName;
	}

	public static int getDbPort() {
		return dbPort;
	}

	public static String getDbURL() {
		return dbURL;
	}

	public static String getRootUserName() {
		return rootUserName;
	}

	public static String getRootPassword() {
		return rootPassword;
	}

	public static String getJdbcDriver() {
		return jdbcDriver;
	}
	
	
	
}
