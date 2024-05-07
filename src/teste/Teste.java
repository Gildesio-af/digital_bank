package teste;

import entities.Bank;
import entities.CurrentAccount;

public class Teste {
	public static void main(String[] args) {
		Bank oneBank = new Bank("One Bank");
		CurrentAccount current = new CurrentAccount("g", 1, 500);
		CurrentAccount current2 = new CurrentAccount("f", 2, 100);
		current.setBalance(500.00);
		current.withdraw(1000.00);
		current.deposit(20.00);
		current.printExtract();
		current2.printExtract();
		
		
		oneBank.getCurrentAccounts().add(current);
		
		
		
	}
}
