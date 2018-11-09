package Login;

import Database.DBConnect;

import java.sql.ResultSet;

public class Login {

    private DBConnect Connection;
    private boolean LoggedIn;

    public Login(String name, String password) {
        Connection = new DBConnect("root", "", "atm");

        ResultSet result;
        int count = 0;
        try {
            result = Connection.query(String.format("SELECT COUNT(*) FROM User WHERE Name = '%s' AND Password = '%s'", name, password));
            count = result.getInt("COUNT(*)");
        }catch(Exception e){
            e.printStackTrace();
        }

        if(count == 1){
            LoggedIn = true;
        }else{
            LoggedIn = false;
        }
    }

    public boolean GetLoggedIn(){
        return LoggedIn;
    }

    public void SetLoggedIn(boolean loggedIn){
        LoggedIn = loggedIn;
    }
}
