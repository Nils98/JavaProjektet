
public class BankAccount {
	private String holderName;
	private long holderId;
	private static int accountNumber = 1001;
	private int acNr;
	private double amount = 0;
	private Customer holder;

	public BankAccount(String holderName, long holderId) {
		holder = new Customer(holderName, holderId);
		this.holderName = holder.getName();
		this.holderId = holder.getIdNr();
		this.acNr = accountNumber;
		accountNumber++;
	}

	public BankAccount(Customer holder) {
		this.holder = holder;
		this.holderName = holder.getName();
		this.holderId = holder.getIdNr();
		this.acNr = accountNumber;
		accountNumber++;
	}

	public Customer getHolder() {
		return holder;
	}

	public int getAccountNumber() {
		return acNr;
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
		return "BankAccount: " +holderName + ", holderId: " + holderId + ", accountNumber: " + acNr;
	}
}
