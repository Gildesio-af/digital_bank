package entities;

import entities.interfaces.AccountInterface;

public final class CurrentAccount extends Account implements AccountInterface{
	private Double overdraft;
	private Double userOverdraft;

	public CurrentAccount(String holder, int password, double overdraft) {
		super(holder, password);
		this.overdraft = overdraft;
	}
	
	@Override
	public boolean withdraw(Double value) {
		if (!this.login()) {
			System.out.println("Usuario ou senha errada.");
			return false;
		}
		if(value > balance) {
			if(value <= balance + overdraft) {
				userOverdraft = value - balance;
				balance = 0.0;
				System.out.println("Saque realizado com sucesso utilizando o cheque especial.");
			}else
				System.out.println("Valor indiponivel para saque");
			return false;
		}else {
			balance -= value;
			System.out.println("Saque realizado com sucesso.");
		}
		return true;
	}

	@Override
	public void deposit(Double value) {
		balance += value;
		System.out.println("Dinheiro depositado com sucesso");
	}

	@Override
	public void transfer(Double value, AccountInterface account) {
		if(this.withdraw(value)) {
			account.deposit(value);
		}
	}

	@Override
	public void printExtract() {
		System.out.println(String.format("Titular da conta: %s", this.client.getName()));
		System.out.println(String.format("Agencia: %d", this.agency));
		System.out.println(String.format("Numerod da conta: %d", this.number));
		System.out.println(String.format("Saldo atual: %.2f", this.balance));
	}

	
	public Double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(Double overdraft) {
		this.overdraft = overdraft;
	}

	public Double getUserOverdraft() {
		return userOverdraft;
	}

	public void setUserOverdraft(Double userOverdraft) {
		this.userOverdraft = userOverdraft;
	}
}
