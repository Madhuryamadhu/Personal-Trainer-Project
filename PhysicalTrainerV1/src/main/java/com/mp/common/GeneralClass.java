package com.mp.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Base64;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GeneralClass {
	private static final Logger logger = LogManager.getLogger(GeneralClass.class);

	public String getFromProperty(String file,String property) {
		String value="";
		InputStream inputStream;
		try {
			Properties prop = new Properties();
			String propFileName = file+".properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} 
			value=prop.getProperty(property);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public Connection getConnection() {
		Connection connection=null;
		try {
			final String JDBC_DRIVER = getFromProperty("General", "JDBC_DRIVER");
			final String DB_URL = getFromProperty("General", "DB_URL");
			final String USER = getFromProperty("General", "USER");
			final String PASS = getFromProperty("General", "PASSWORD");
			logger.info("General class>> Getting Connection::- Driver->"+JDBC_DRIVER+" | URL->"+DB_URL+" | UserName->"+USER+" | Password->"+PASS );

			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public String getUniqueId() {
		long prefix = 0;
		String suffix="";
		String uniqueID="";
		try {
			suffix =new String(Base64.getDecoder().decode("MTkwNQ==".getBytes()));
			prefix= (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
			uniqueID =suffix+prefix+"";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uniqueID;
	}
	
}