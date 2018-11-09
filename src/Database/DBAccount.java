package Database;

import java.sql.PreparedStatement;

public class DBAccount extends DBConnect {

    public DBAccount(String username, String password, String connectionPath){
        super(username, password, connectionPath);
    }

    public void Insert(int userId, String iban, int pin, String currency, double balance){
        Sql = "INSERT INTO Account(IBAN, PIN, Currency, Balance, IsActive, UserID) VALUES(?, ?, ?, ?, ?, ?)";
        boolean isActive = true;
        try {
            PrepStmt = Connection.prepareStatement(Sql);
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

    public void Update(int userId, int pin, String currency, double balance){
        Sql = "UPDATE Account SET PIN = ?, Currency = ?, Balance = ? WHERE UserID = ? ";
        try{
            PrepStmt.setInt(1, pin);
            PrepStmt.setString(2, currency);
            PrepStmt.setDouble(3, balance);
            PrepStmt.setInt(4, userId);
            PrepStmt.execute();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
