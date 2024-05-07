package entities;

import java.util.Scanner;

public abstract class Account{
	private static final int AGENCY = 0001;
	private static int initial = 0;
	
	protected int agency;
	protected int number = 1000;
	protected Client client;
	protected Double balance;
	
	public Account(String name, int password) {
		
		this.agency = Account.AGENCY;
		this.number += generateNumber();
		this.client = new Client(name, password);
	}
	
	protected boolean login() {
		Scanner scan = new Scanner(System.in);
		int password;
		String name;
		System.out.print("Digite seu nome: ");
		name = scan.nextLine();
		System.out.print("Digite sua senha: ");
		password = Integer.parseInt(scan.nextLine());
		
		scan.close();
		
		if(password == this.client.getPassword() && name.equalsIgnoreCase(this.client.getName()))
			return true;
		
		return false;
	}
	
	 private static synchronized int generateNumber() {
	        return ++initial;
	 }

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
