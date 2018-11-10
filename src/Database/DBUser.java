package Database;

import java.sql.PreparedStatement;

public class DBUser extends DBConnect {

    public DBUser(String username, String password, String connectionPath){
        super(username, password, connectionPath);
    }


    public void Insert(String name, String password){

        boolean isActive = true;
        String sql = "INSERT INTO User(Name, Password, IsActive) VALUES(?,?,?)";
        try {
            PrepStmt = Connection.prepareStatement(sql);
            PrepStmt.setString (1, name);
            PrepStmt.setString (2, password);
            PrepStmt.setBoolean (3, isActive);

            PrepStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update(int userid, String name, String password){
        try{
            String sql = "UPDATE User SET Name = ?, Password = ? WHERE UserID = ?";
            PrepStmt = Connection.prepareStatement(sql);
            PrepStmt.setString(1, name);
            PrepStmt.setString(2, password);
            PrepStmt.setInt(3, userid);
            PrepStmt.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
