package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionManager {

    private ArrayList<String> USER_IBAN = new ArrayList<String>(10);
    private ArrayList<String> RECEIVING_IBAN = new ArrayList<String>(10);
    private ArrayList<String> currency = new ArrayList<String>(10);
    private ArrayList<Double> amount = new ArrayList<Double>(10);


    public TransactionManager(){
        DBConnect con = new DBConnect("root", "", "atm");
        String query = "SELECT * FROM Transaction";
        ResultSet result = con.query(query);
        try {
            while(result.next()){
                USER_IBAN.add(result.getString("FROM_IBAN"));
                RECEIVING_IBAN.add(result.getString("TO_IBAN"));
                currency.add(result.getString("Currency"));
                amount.add(result.getDouble("Amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void showHistory(){
        for(int i = 0 ; i < currency.size(); i++)
            System.out.println( USER_IBAN.get(i) + " " + RECEIVING_IBAN .get(i)+ " " + currency.get(i) + " " + amount.get(i));
    }

}
