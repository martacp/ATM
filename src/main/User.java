package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class User {

	private String name;
	private String password;
	private boolean isActive;
	private boolean isLoggedIn;
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		isLoggedIn = false;
		isActive = false;
	}

	public void setActiveUserAccount(){
		if(isActive == false)
			isActive = true;
	}

	public void login(){
		isLoggedIn = true;
	}

	public boolean userExists(){
		DBConnect con = new DBConnect("root","", "atm");
		ResultSet result;
		int count = 0;
		result = con.query(String.format("SELECT COUNT(*) FROM User WHERE Name = '%s' AND Password = '%s'", name, password));
		try {
			if(result.next())
				count = result.getInt("COUNT(*)");
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(count > 1)
			throw new RuntimeException();
		if(count == 1)
			return true;
		else
			return false;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
