package Database;

import Database.DBConnect;

import java.sql.PreparedStatement;

public class DBUser extends DBConnect {

    public DBUser(String username, String password, String connectionPath){
        super(username, password, connectionPath);
    }


    public void insertUser(String name, String password){

        boolean isActive = true;
        String sql = "INSERT INTO User(Name, Password, IsActive) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStmt = Connection.prepareStatement(sql);
            preparedStmt.setString (1, name);
            preparedStmt.setString (2, password);
            preparedStmt.setBoolean (3, isActive);

            preparedStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deactivateUser(int id){
        try{
            boolean isActive = false;
            String sql = "UPDATE User SET isActive = ? WHERE UserID = ?";
            PreparedStatement prepStmt = Connection.prepareStatement(sql);
            prepStmt.setBoolean(1, isActive);
            prepStmt.setInt(1, id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
