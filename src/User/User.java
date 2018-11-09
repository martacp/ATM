package User;

import Database.DBUser;

import java.sql.ResultSet;

public class User {

	private String Name;
	private String Password;
	private boolean IsActive;
	private int UserID;

	public User(String name, String password) {
		Name = name;
		Password = password;
		IsActive = true;
	}

	public String GetName() { return Name; }

	public String GetPassword() {
		return Password;
	}

	public int GetUserID(){ return UserID; }

	public boolean GetIsActive() {
		return IsActive;
	}

	public void SetName(String name) {
		Name = name;
	}

	public void SetPassword(String password) {
		Password = password;
	}

	public void SetIsActive(boolean isActive) {
		IsActive = isActive;
	}

	public void SetUserID(int userid){ UserID = userid;}

}
