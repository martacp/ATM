package Database;

import java.sql.PreparedStatement;

public class DBAccount extends DBConnect {

    public DBAccount(String username, String password, String connectionPath){
        super(username, password, connectionPath);
    }

    public void insert(int userId, String iban, int pin, String currency, double balance){
        String sql = "INSERT INTO Account(IBAN, PIN, Currency, Balance, IsActive, UserID) VALUES(?, ?, ?, ?, ?, ?)";
        boolean isActive = true;
        try {
            PrepStmt = Connection.prepareStatement(sql);
            PrepStmt.setString(1, iban);
            PrepStmt.setInt(2, pin);
            PrepStmt.setString(3, currency);
            PrepStmt.setDouble(4, balance);
            PrepStmt.setBoolean(5, isActive);
            PrepStmt.setInt(6, userId);
            PrepStmt.execute();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
