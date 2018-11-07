package main;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AccountManager {

    private String Name;
    private DBConnect Connection;
    private ArrayList<Account> Accounts;

    public AccountManager(String name){

        Connection = new DBConnect("root", "","atm");
        Name = name;
        Accounts = new ArrayList<Account>(10);
    }

    public void getAccounts(){

        ResultSet result = Connection.query(String.format("SELECT * FROM Account " +
                                     "INNER JOIN User ON User.UserID = Account.UserID " +
                                     "WHERE User.Name = '%s';", Name));
        try {
            while(result.next()){

                Accounts.add(new Account( Name,
                                          result.getString("IBAN"),
                                          result.getInt("PIN"),
                                          result.getString("Currency"),
                                          result.getDouble("Balance")));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        for(Account acc:Accounts)
            acc.show();
    }
}
