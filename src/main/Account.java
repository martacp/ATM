package main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Account {

	private String IBAN;
	private String name;
	private int pin;
	private String currency;
	private int balance = 0;
	private boolean isActive;

	public Account(String name, String IBAN, int pin, String currency, int balance){
		if(balance >= 0){
			this.name = name;
			this.IBAN = IBAN;
			this.pin = pin;
			this.currency = currency;
			this.balance = balance;
		}
	}

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
