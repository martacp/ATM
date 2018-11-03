package main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class DBConnect {

	public DBConnect() {
		connection = null;
		statement = null;
		resultSet = null;
		username = null;
		password = null;
		connectionPath = null;
	}

	public DBConnect(String username, String password, String connectionPath){

		this.username = username;
		this.password = password;
		this.connectionPath = connectionPath;

		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + connectionPath,
														  username,
					                                      password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet query(String query){

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private String username;
	private String password;
	private String connectionPath;
}
