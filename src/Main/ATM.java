package Main;

import Account.AccountManager;
import Database.DBConnect;
import Transaction.TransactionManager;
import Login.Login;

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

		String from = "112233", to = "223344", currency = "RON";
		String newUser = "ciac", newAccount = "887766", pass = "123", repassword = "123";
		double amount = 51.0;

			//User new_user = new User();
			//new_user.createUser(newUser, pass, repass);

		//login info
		String name = "clemi", password = "123";
		Login login = new Login(name, password);

		//new account info
		int userid , pin = 1234;
		double balance = 1000.0;

			if(login.GetLoggedIn()){

				userid = login.GetUserID();

				AccountManager acc = new AccountManager(name);
				acc.CreateAccount(userid, pin, currency, balance);
				acc.GetAccounts();

				TransactionManager transaction = new TransactionManager(userid);
				//transaction.Create(from, to, currency, amount, userid);
				transaction.SetTransactions();
				System.out.println("User data correct!");
			}else{
				System.out.println("User data incorrect!");
			}

	}
}
