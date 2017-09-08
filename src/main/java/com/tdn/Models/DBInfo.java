/*package com.tdn.Models;




public class DBInfo {
	
	static String dbHost = "127.0.0.1";
	static String dbName = System.getenv("OPENSHIFT_APP_NAME");

	static int dbPort = 3306;
	
	static String dbURL = "jdbc:"+System.getenv("OPENSHIFT_MYSQL_DB_URL")+ dbName;

	 
	static String rootUserName = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
;
	
	static String rootPassword = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
;
	
	static String jdbcDriver = "com.mysql.jdbc.Driver";

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
	
	
	
}*/
