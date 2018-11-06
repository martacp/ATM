package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Transaction {

	private String from;
	private String to;
	private double amount;
	private String currency;
	
	public Transaction(String from, String to, double amount, String currency) {
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.currency = currency;
	}

	public void show(){
		System.out.println(from + " " + to + " " + currency + " " + amount);
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public double getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
