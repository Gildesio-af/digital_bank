package entities.interfaces;

public interface AccountInterface {
	public boolean withdraw(Double value);
	public void deposit(Double value);
	public void transfer(Double value, AccountInterface account);
	public void printExtract();
}
