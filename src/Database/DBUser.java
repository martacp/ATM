package Database;

public class DBUser extends DBConnect {

    public DBUser(String username, String password, String connectionPath){
        super(username, password, connectionPath);
    }


    public void insert(String name, String password){

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

    public void update(int id){
        try{
            boolean isActive = false;
            String sql = "UPDATE User SET isActive = ? WHERE UserID = ?";
            PrepStmt = Connection.prepareStatement(sql);
            PrepStmt.setBoolean(1, isActive);
            PrepStmt.setInt(1, id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
