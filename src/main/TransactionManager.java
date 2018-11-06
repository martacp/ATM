package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TransactionManager {

    private String FROM_IBAN;
    private String TO_IBAN;
    private String currency;
    private double amount;
    private int userID;
    private ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>(10);


    public TransactionManager(int id){
        userID = id;
    }

    public void create(String from, String to, String currency, double amount, int userid){

        DBConnect con = new DBConnect("root","", "atm");
        String sql = "insert into Transaction(FROM_IBAN, TO_IBAN, Currency, Amount, UserID)" + " values(?,?,?,?,?)";
        con.insertTransaction(sql, from, to, currency, amount, userid);

    }

    public void showHistory(){

        DBConnect con = new DBConnect("root", "", "atm");
        String query = "SELECT * FROM Transaction WHERE UserID = '" +  userID + "'";
        ResultSet result = con.query(query);
        try {
            while(result.next()){

                String from = result.getString("FROM_IBAN");
                String to = result.getString("TO_IBAN");
                String curr= result.getString("Currency");
                double am = result.getDouble("Amount");

                transactionHistory.add(new Transaction(from, to, am, curr));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0 ; i < transactionHistory.size(); i++) {
            //System.out.println("inside the for loop." + i);
            transactionHistory.get(i).show();
        }
    }

}
