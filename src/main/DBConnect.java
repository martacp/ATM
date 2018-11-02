package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public DBConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
			System.out.println("Database error:" + e);
		}
	}

}
