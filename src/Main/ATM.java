package Main;

import Account.AccountManager;
import Database.DBConnect;
import Transaction.TransactionManager;
import User.User;

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
		String newUser = "ciac", newAccount = "887766", pass = "123", repass = "123";
		double amount = 51.0;
		int userid;

			//User new_user = new User();
			//new_user.createUser(newUser, pass, repass);


			User user = new User(name, password);

			if(user.UserExists()){
				//logging in the user
				user.SetActiveUserAccount();
				user.LoggedIn();
				userid = user.getUserID();

				//selecting all bank accounts of said user
				AccountManager acc = new AccountManager(name);
				acc.getAccounts();

				TransactionManager transaction = new TransactionManager(userid);
				//transaction.create(from, to, currency, amount, userid);
				transaction.SetTransactions();
				System.out.println("User data correct!");
			}else{
				System.out.println("User data incorrect!");
			}

	}
}
