package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;



public class ATM {

	public static void main(String[] args) {
		ResultSet result;
		DBConnect con = new DBConnect("root","", "atm");
		result = con.query("SELECT * FROM User");
		try {
			while(result.next()){
                System.out.println(result.getString("name"));
            }
		} catch (Exception e) {
			e.printStackTrace();
		}

		String name = "clemi", password = "123";
			User user = new User(name, password);

			if(user.userExists()){
				System.out.println("User data correct!");
			}else{
				System.out.println("User data incorrect!");
			}


	}
}
