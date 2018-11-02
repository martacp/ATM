package main;

public class Transaction {

	private String from;
	private String to;
	private int amount;
	private String currency;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public int getAmount() {
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
