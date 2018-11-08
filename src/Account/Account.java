package Account;

public class Account {

	private String Iban;
	private String Name;
	private int Pin;
	private String Currency;
	private double Balance = 0;
	private boolean IsActive;

	public Account(String name, String iban, int pin, String currency, double balance){
		if(balance >= 0){
			Name = name;
			Iban = iban;
			Pin = pin;
			Currency = currency;
			Balance = balance;
		}
	}

	public void show(){
		System.out.println( Name + " " + Iban + " " + Pin + " " + Currency + " " + Balance);
	}

	public String getIban() { return Iban; }
	public int getPin() {
		return Pin;
	}
	public String getCurrency() {
		return Currency;
	}
	public double getBalance() {
		return Balance;
	}
	public boolean isActive() { return IsActive; }
	public void setIban(String iban) {
		Iban= iban;
	}
	public void setPin(int pin) {
		Pin = pin;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public void setActive(boolean isActive) {
		IsActive = isActive;
	}

}
