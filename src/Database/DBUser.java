package Database;

public class DBUser extends DBConnect {

    public DBUser(String username, String password, String connectionPath){
        super(username, password, connectionPath);
    }


    public void Insert(String name, String password){

        boolean isActive = true;
        Sql = "INSERT INTO User(Name, Password, IsActive) VALUES(?,?,?)";
        try {
            PrepStmt = Connection.prepareStatement(Sql);
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
            Sql = "UPDATE User SET Name = ?, Password = ? WHERE UserID = ?";
            PrepStmt = Connection.prepareStatement(Sql);
            PrepStmt.setString(1, name);
            PrepStmt.setString(2, password);
            PrepStmt.setInt(3, userid);
            PrepStmt.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void Delete(int userId){
        try{
            Sql = "DELETE FROM User WHERE UserID = ?";
            PrepStmt = Connection.prepareStatement(Sql);
            PrepStmt.setInt(1, userId);
            PrepStmt.execute();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
