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
            Result = Connection.Query(String.format("SELECT COUNT(*), UserID FROM User WHERE Name = '%s' AND Password = '%s'", name, password));
            while(Result.next()) {
                count = Result.getInt("COUNT(*)");
                UserID = Result.getInt("UserID");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        if(count == 1){
            LoggedIn = true;
            Name = name;
            Password = password;
        }else{
            LoggedIn = false;
            UserID = 0;
        }
    }

    public int GetUserID(){ return UserID; }

    public boolean GetLoggedIn(){ return LoggedIn; }

    public void SetLoggedIn(boolean loggedIn){ LoggedIn = loggedIn; }
}
