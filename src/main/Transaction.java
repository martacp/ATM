package main;

public class Transaction {

	private String From;
	private String To;
	private double Amount;
	private String Currency;
	
	public Transaction(String from, String to, double amount, String currency) {
		From = from;
		To = to;
		Amount = amount;
		Currency = currency;
	}

	public void show(){
		System.out.println(From + " " + To + " " + Currency + " " + Amount);
	}

	public String getFrom() {
		return From;
	}

	public String getTo() {
		return To;
	}

	public double getAmount() {
		return Amount;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setFrom(String from) {
		From = from;
	}

	public void setTo(String to) {
		To = to;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

}
