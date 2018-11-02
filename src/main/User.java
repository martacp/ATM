package main;

public class User {

	private String name;
	private String password;
	private boolean isActive;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
