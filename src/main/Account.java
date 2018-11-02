package main;

public class Account {

	private String IBAN;
	private int pin;
	private String currency;
	private int balance = 0;
	private boolean isActive;
	public String getIBAN() {
		return IBAN;
	}
	public int getPin() {
		return pin;
	}
	public String getCurrency() {
		return currency;
	}
	public int getBalance() {
		return balance;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
