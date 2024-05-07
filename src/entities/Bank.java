package entities;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private String name;
	private List<Account> savingsAccounts;
	private List<Account> currentAccounts;
	
	public Bank(String name) {
		this.savingsAccounts = new ArrayList<Account>();
		this.currentAccounts = new ArrayList<Account>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getSavingsAccounts() {
		return savingsAccounts;
	}

	public void setSavingsAccounts(List<Account> savingsAccounts) {
		this.savingsAccounts = savingsAccounts;
	}

	public List<Account> getCurrentAccounts() {
		return currentAccounts;
	}

	public void setCurrentAccounts(List<Account> currentAccounts) {
		this.currentAccounts = currentAccounts;
	}
}
