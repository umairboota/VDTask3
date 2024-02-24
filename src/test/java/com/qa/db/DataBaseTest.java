package com.qa.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Task3_LoginPage;

public class DataBaseTest extends TestBase {

	public DataBaseTest() {
		super();
	}

	// Connection object
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	// Constant for Database URL

	@BeforeTest
		public void setUpTest() {
			
			try {
	// Database connection
				String dbClass = "com.mysql.cj.jdbc.Driver";
				Class.forName(dbClass).newInstance();
	// Get connection to DB
				Connection con = DriverManager.getConnection(prop.getProperty("DB_URL"), prop.getProperty("DB_USER"), prop.getProperty("DB_PASSWORD"));
				
	// Statement object to send the SQL statement to the Database
				stmt = con.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	@Test
	public void test() {
		try {
			String query = "select * from employee_table";
			// Get the contents of userinfo table from DB
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				System.out.print(res.getString(1));
				System.out.print(" " + res.getString(2));
				System.out.print(" " + res.getString(3));
				System.out.println(" " + res.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() throws SQLException {
		// Close DB connection
		if (con != null) {
			con.close();
		}
	}
}