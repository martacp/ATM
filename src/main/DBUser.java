package main;

import java.sql.PreparedStatement;

public class DBUser extends DBConnect {

    public void insertUser(String name, String password){

        boolean isActive = true;
        String sql = "INSERT INTO User(Name, Password, IsActive) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
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
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setBoolean(1, isActive);
            prepStmt.setInt(1, id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
