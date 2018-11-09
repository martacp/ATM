package Login;

import Database.DBConnect;

import java.sql.ResultSet;

public class Login {

    private DBConnect Connection;
    private boolean LoggedIn;
    private ResultSet Result;
    private String Name;
    private String Password;
    private int UserID;

    public Login(String name, String password) {
        Connection = new DBConnect("root", "", "atm");

        int count = 0;
        try {
            Result = Connection.query(String.format("SELECT COUNT(*) FROM User WHERE Name = '%s' AND Password = '%s'", name, password));
            while(Result.next())
                count = Result.getInt("COUNT(*)");
        }catch(Exception e){
            e.printStackTrace();
        }

        if(count == 1){
            LoggedIn = true;
            Name = name;
            Password = password;
            try {
                Result = Connection.query(String.format("SELECT UserID FROM User WHERE Name = '%s' AND Password = '%s'", Name, Password));
                while(Result.next())
                    UserID = Result.getInt("UserID");
            }catch(Exception e){
                e.getStackTrace();
            }
        }else{
            LoggedIn = false;
        }
    }

    public int GetUserID(){ return UserID; }

    public boolean GetLoggedIn(){ return LoggedIn; }

    public void SetLoggedIn(boolean loggedIn){ LoggedIn = loggedIn; }
}
