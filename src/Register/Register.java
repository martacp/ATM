package Register;

import Database.DBUser;
import User.User;

public class Register {

    private DBUser Connection;

    public Register(String name, String password, String reEnteredPassword){
        if(password == reEnteredPassword){
            Connection = new DBUser("root","","atm");
            Connection.insert(name, password);
        }else{

        }
    }
}
