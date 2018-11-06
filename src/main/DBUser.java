package main;

import java.sql.PreparedStatement;

public class DBUser extends DBConnect {

    public void insertUser(String s, String name, String password){

        boolean isActive = true;
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(s);
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
            String s = "UPDATE User SET isActive = ? WHERE UserID = ?";
            PreparedStatement prepStmt = connection.prepareStatement(s);
            prepStmt.setBoolean(1, isActive);
            prepStmt.setInt(1, id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
