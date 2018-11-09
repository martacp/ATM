package Database;

public class DBTransaction extends DBConnect {

    public DBTransaction(String username, String password, String connectionPath){
        super(username, password, connectionPath);
    }

    public void Insert(String from, String to, String currency, double amount, int userid){

        Sql = "INSERT INTO Transaction(FROM_IBAN, TO_IBAN, Currency, Amount, UserID) VALUES(?,?,?,?,?)";

        try {
            PrepStmt = Connection.prepareStatement(Sql);
            PrepStmt.setString (1, from);
            PrepStmt.setString (2, to);
            PrepStmt.setString (3, currency);
            PrepStmt.setDouble(4, amount);
            PrepStmt.setInt(5, userid);

            PrepStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
