
public class BankAccount {
	private String holderName;
	private long holderId;
	private static int accountNumber = 0;
	private double amount = 0;
	private Customer holder;

	public BankAccount(String holderName, long holderId) {
		this.holderName = holderName;
		this.holderId = holderId;
		accountNumber++;
	}

	public BankAccount(Customer holder) {
		this.holderName = holder.getName();
		this.holderId = holder.getIdNr();
		accountNumber++;
	}

	public Customer getHolder() {
		return holder;
	}

	public static int getAccountNumber() {
		return accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void deposit(double amount) {
		this.amount += amount;
	}

	public void withdraw(double amount) {
		this.amount -= amount;
	}

	public String toString() {
		return holderName + " " + holderId + " " + accountNumber;
	}
}
