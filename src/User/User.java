package User;

import Database.DBUser;

import java.sql.ResultSet;

public class User {

	private String Name;
	private String Password;
	private boolean IsActive;
	private int UserID;
	private DBUser Connection;

	public User(String name, String password) {
		Connection = new DBUser("root","", "atm");
		Name = name;
		Password = password;
		IsActive = true;
	}

//taie partial
	public boolean UserExists(){

		ResultSet result;
		int count = 0;
		result = Connection.query(String.format("SELECT COUNT(*) FROM User WHERE Name = '%s' AND Password = '%s'", Name, Password));
		try {
			if(result.next())
				count = result.getInt("COUNT(*)");
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
