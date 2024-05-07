package entities;

import entities.interfaces.AccountInterface;

public class SavingsAccount extends Account implements AccountInterface{
	private Double interestRate;
	private Double income;
	
	public SavingsAccount(String holder, int password) {
		super(holder, password);
		this.interestRate = 5.0;
	}

	@Override
	public boolean withdraw(Double value) {
		if (!this.login()) {
			System.out.println("Usuario ou senha errada.");
			return false;
		}
		if(value > balance) {
			System.out.println("Saldo insuficiente.");
			return false;
		}
		else {
			balance -= value;
			System.out.println("Saque realizado com sucesso.");
		}
		return true;
	}

	@Override
	public void deposit(Double value) {
		balance += value * (1+ interestRate / 100);
		income = balance - value;
		System.out.println("Deposito realizado com sucesso.");
	}

	@Override
	public void transfer(Double value, AccountInterface account) {
		if(this.withdraw(value)) {
			account.deposit(value);
			System.out.println("Transferencia realizada com sucesso.");
		}
		
	}

	@Override
	public void printExtract() {
		System.out.println(String.format("Titular da conta: %s", this.client.getName()));
		System.out.println(String.format("Agencia: %d", this.agency));
		System.out.println(String.format("Numero da conta: %d", this.number));
		System.out.println(String.format("Saldo atual: %.2f", this.balance));
		System.out.println(String.format("Rendimento total: %.2f", this.income));
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}
}
