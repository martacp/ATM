package main;

import java.sql.*;

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

		public void insertTransaction(String s, String from, String to, String currency, double amount, int userid){

			try {
				PreparedStatement preparedStmt = connection.prepareStatement(s);
				preparedStmt.setString (1, from);
				preparedStmt.setString (2, to);
				preparedStmt.setString (3, currency);
				preparedStmt.setDouble(4, amount);
				preparedStmt.setInt(5, userid);

				preparedStmt.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	public void insertUser(String s, String name, String password){

			boolean isActive = true;
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(s);
			preparedStmt.setString (1, name);
			preparedStmt.setString (2, password);
			preparedStmt.setBoolean (3, isActive);

			preparedStmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deactivateUser(int id){
		try{
			boolean isActive = false;
			String s = "UPDATE User SET isActive = ? WHERE UserID = ?";
			PreparedStatement prepStmt = connection.prepareStatement(s);
			prepStmt.setBoolean(1, isActive);
			prepStmt.setInt(1, id);
		}catch(Exception e){
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
