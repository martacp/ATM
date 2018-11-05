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

		String name = "clemi", password = "123", from = "112233", to = "223344", currency = "RON";
		double amount = 79.0;

			User user = new User(name, password);

			if(user.userExists()){
				//logging in the user
				user.setActiveUserAccount();
				user.loggedIn();

				//selecting all bank accounts of said user
				AccountManager acc = new AccountManager(name);
				acc.getAccounts();

				//Transaction transaction = new  Transaction(from, to, amount, currency);
				//transaction.addTransaction();

				TransactionManager manager = new TransactionManager();
				manager.showHistory();

				System.out.println("User data correct!");
			}else{
				System.out.println("User data incorrect!");
			}

	}
}
