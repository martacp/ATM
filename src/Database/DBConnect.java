package Database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBConnect {

	public DBConnect() {
		Connection = null;
		Statement = null;
		ResultSet = null;
		Username = null;
		Password = null;
		ConnectionPath = null;
	}

	public DBConnect(String username, String password, String connectionPath){

		this.Username = username;
		this.Password = password;
		this.ConnectionPath = connectionPath;

		try {
			this.Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + connectionPath,
														  username,
					                                      password);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public ResultSet Query(String query){

		try {
			Statement = Connection.createStatement();
			ResultSet = Statement.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultSet;
	}

	protected Connection Connection;
	protected Statement Statement;
	protected ResultSet ResultSet;
	protected String Username;
	protected String Password;
	protected String ConnectionPath;
	protected String Sql;
	protected PreparedStatement PrepStmt;
}
