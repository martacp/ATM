package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class AccountManager {

    private String name;

    public AccountManager(String name){
        this.name = name;
    }

    public void getAccounts(){

        DBConnect con = new DBConnect("root","", "atm");
        ResultSet result = con.query(String.format("select * from Account " +
                "inner join User on User.UserID = Account.UserID " +
                "where User.Name = '%s';", name));
        String iban, currency;
        int balance;
        try {
            while(result.next()){

                iban = result.getString("IBAN");
                currency = result.getString("currency");
                balance = result.getInt("balance");

                System.out.println("IBAN: " + iban);
                System.out.println("Currency: " + currency);
                System.out.println("Balance: " + balance + " " + currency);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
