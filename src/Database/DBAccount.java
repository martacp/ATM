package Database;

import java.sql.PreparedStatement;

public class DBAccount extends DBConnect {

    public DBAccount(String username, String password, String connectionPath){
        super(username, password, connectionPath);
    }

    public void insert(int userId, String iban, int pin, String currency, double balance){
        String sql = "INSERT INTO Account(IBAN, Pin, Currency, Balance, IsActive, UserID) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prepStmt = Connection.prepareStatement(sql);
            prepStmt.setString(1, iban);
            prepStmt.setInt(2, pin);
            prepStmt.setString(3, currency);
            prepStmt.setDouble(4, balance);
            prepStmt.setBoolean(5, true);
            prepStmt.setInt(6, userId);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
