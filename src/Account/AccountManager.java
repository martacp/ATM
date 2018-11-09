package Account;

import Account.Account;
import Database.DBAccount;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class AccountManager {

    private String Name;
    private DBAccount Connection;
    private ArrayList<Account> Accounts;

    public AccountManager(String name){

        Connection = new DBAccount("root", "","atm");
        Name = name;
        Accounts = new ArrayList<Account>(10);

    }

    public void GetAccounts(){

        ResultSet result = Connection.Query(String.format("SELECT * FROM Account " +
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

       // for(Account acc:Accounts)
         //   acc.show();
    }

    public void CreateAccount(int userid, int pin, String currency, double balance){

        String iban = IbanGenerator();
        Connection.Insert(userid, iban, pin, currency, balance);
    }

    public String IbanGenerator(){
        String iban = "";
        int iban_size = 6;
        int current_number = 0;
        Random rand = new Random();

        while(--iban_size >= 0)
        {
            current_number = rand.nextInt(10);
            iban += current_number;
        }
        System.out.println(iban);
        return iban;
    }
}
