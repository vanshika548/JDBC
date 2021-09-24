package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.sql.Driver;

public class DBDemo {
	public static void main(String[]args) throws SQLException {
		String jdbcURL = "jdbc:mysql://localhost:3306/payroll_database?useSSL=FALSE";
		String userName = "root";
		String password = "Vanshika@123";
		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in classpath!",e);
		}
		
		listDrivers();
		
		try {
			System.out.println("Connecting to database"+ jdbcURL);
			con = DriverManager.getConnection(jdbcURL , userName , password);
			System.out.println("Connection is successful!!!!! "+con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while(driverList.hasMoreElements()) {
			Driver driverClass = driverList.nextElement();
			System.out.println("----"+driverClass.getClass().getName());
		}
	}
	
}
