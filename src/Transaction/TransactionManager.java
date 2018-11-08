package Transaction;

import Database.DBTransaction;
import Transaction.Transaction;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TransactionManager {

    private DBTransaction Connection;
    private int UserID;
    private ArrayList<Transaction> Transactions;

    public TransactionManager(int userID){
        UserID = userID;
        Transactions = new ArrayList<Transaction>();
        Connection = new DBTransaction("root", "", "atm");
    }

    public void Create(String from, String to, String currency, double amount, int userid){
        Connection.insertTransaction(from, to, currency, amount, userid);
    }

    public ArrayList<Transaction> GetTransanctions(){
        return Transactions;
    }

    public void SetTransactions(){
        String query = "SELECT * FROM Transaction WHERE UserID = '" +  UserID + "'";
        ResultSet result = Connection.query(query);
        try {
            while(result.next()){
               Transactions.add(new Transaction(result.getString("FROM_IBAN"),
                                                 result.getString("TO_IBAN"),
                                                 result.getDouble("Amount"),
                                                 result.getString("Currency")
                                                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Transaction t : Transactions) {
            t.show();
        }
    }

}
