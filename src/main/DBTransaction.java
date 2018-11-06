package main;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBTransaction extends DBConnect{

    public void insertTransaction(String from, String to, String currency, double amount, int userid){

        String sql = "INSERT INTO Transaction(FROM_IBAN, TO_IBAN, Currency, Amount, UserID)" + " VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString (1, from);
            preparedStmt.setString (2, to);
            preparedStmt.setString (3, currency);
            preparedStmt.setDouble(4, amount);
            preparedStmt.setInt(5, userid);

            preparedStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}