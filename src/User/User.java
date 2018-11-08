package User;

import Database.DBUser;

import java.sql.ResultSet;

public class User {

	private String Name;
	private String Password;
	private boolean IsActive;
	private boolean IsLoggedIn;
	private int UserID;
	private DBUser Connection;

	public User() {
		Connection = new DBUser("root", "","atm");
		Name = null;
		Password = null;
		IsLoggedIn = false;
		IsActive = false;
	}

	public User(String name, String password) {
		Connection = new DBUser("root","", "atm");
		Name = name;
		Password = password;
		IsLoggedIn = false;
		IsActive = false;
	}

	public void SetActiveUserAccount(){
		if(IsActive == false)
			IsActive = true;
	}

	public void DeactivateUser(){ Connection.deactivateUser(UserID); }

	public void LoggedIn(){

		ResultSet result;
		IsLoggedIn = true;
		IsActive = true;
		result = Connection.query(String.format("SELECT * FROM User WHERE Name = '%s'", Name));
		try {
			while (result.next()) {
				UserID = result.getInt("UserID");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void CreateUser(String name, String password, String repassword){
		if(password == repassword){
			Name = name;
			Password = password;

			Connection.insertUser(Name, Password);
		}
	}

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

	public String getName() { return Name; }

	public String getPassword() {
		return Password;
	}

	public int getUserID(){ return UserID; }

	public boolean isActive() {
		return IsActive;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setActive(boolean isActive) {
		IsActive = isActive;
	}

	public void setUserID(int userid){ UserID = userid;}

}
