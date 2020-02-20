import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		BankApplication instance = new BankApplication();
		instance.runApplication();

	}

	private void alternatives() {
		System.out.println("                                                                         ");
		System.out.println("What would you like us to do for you? ");
		System.out.println("1. Select account by using your social security number");
		System.out.println("2. Select account by using your name");
		System.out.println("3. Make a deposit");
		System.out.println("4. Make a withdrawal");
		System.out.println("5. Transfer assets");
		System.out.println("6. Create a new account");
		System.out.println("7. Remove an account");
		System.out.println("8. Account overview");
		System.out.println("9. Exit");
		System.out.println("Please enter the corresponding number: ");
	}

	private void runApplication() {
		Scanner scan = new Scanner(System.in);
		Bank bank = new Bank();
		long idNr;
		int customerNr;
		ArrayList<BankAccount> temp = null;
		alternatives();

		while (true) {

			int chosen = scan.nextInt();
			scan.nextLine();

			switch (chosen) {

			case 1:
				System.out.println("Please enter your social security number: ");
				idNr = scan.nextInt();
				if (bank.findHolder(idNr) != null) {
					for (int i = 0; i < bank.findAccountsForHolder(idNr).size(); i++) {
						System.out.println(bank.findAccountsForHolder(idNr).get(i));
					}
					alternatives();	
				}
				else
					System.out.println("There are no accounts with the Id:" + idNr + "!");
				break;

			case 2:
				System.out.println("Please enter your Name: ");
				String namePart = scan.nextLine();
				if (bank.findbyPartofName(namePart).size() != 0) {
					for (int i = 0; i < bank.findbyPartofName(namePart).size(); i++) {
						System.out.println(bank.findbyPartofName(namePart).get(i));
					}
					alternatives();
				} else
					System.out.println("There are no accounts under the Name:" + namePart + "!");
				break;

			case 3:
				System.out.println("Please enter your Account number: ");
				customerNr = scan.nextInt();
				if (bank.findByNumber(customerNr) != null) {
					System.out.println("Amount to deposit: ");

					double deposit = scan.nextDouble();

					if (deposit > 0) {
						bank.findByNumber(customerNr).deposit(deposit);
						System.out.println("AccountNbr " + customerNr + " (" + bank.findByNumber(customerNr) + ") : "
								+ bank.findByNumber(customerNr).getAmount());
						alternatives();
					} else
						System.out.println("Please enter a valid amount!");
				} else
					System.out.println("Please enter a valid account number");
				break;

			case 4:
				System.out.println("Please enter your Account Id: ");
				customerNr = scan.nextInt();
				if (bank.findByNumber(customerNr) != null) {
					System.out.println("Amount to withdraw: ");
					double withdraw = scan.nextDouble();

					if (withdraw > 0) {
						if (withdraw <= bank.findByNumber(customerNr).getAmount()) {
							bank.findByNumber(customerNr).withdraw(withdraw);
							System.out.println(bank.findByNumber(customerNr));

						} else
							System.out.println("The entered amount is not available");
						System.out.println("Current Balance: " + bank.findByNumber(customerNr).getAmount());
						alternatives();

					} else
						System.out.println("Please enter a valid amount!");

				} else
					System.out.println("Please enter a valid account number");
				break;

			case 5:
				System.out.println("Please enter the senders Account Id: ");
				customerNr = scan.nextInt();

				if (bank.findByNumber(customerNr) != null) {
					System.out.println("Please enter the recievers Account Id: ");
					int recieverNr = scan.nextInt();

					if (bank.findByNumber(recieverNr) != null) {
						System.out.println("Please enter the amount to transfer: ");
						double amount = scan.nextDouble();
						if (!(amount < 0)) {
							if (amount <= bank.findByNumber(customerNr).getAmount()) {
								bank.findByNumber(customerNr).withdraw(amount);
								bank.findByNumber(recieverNr).deposit(amount);
								System.out.println("AccountNbr " + customerNr + " (" + bank.findByNumber(customerNr)
								+ ") : " + bank.findByNumber(customerNr).getAmount());
								System.out.println("AccountNbr " + recieverNr + " (" + bank.findByNumber(recieverNr)
								+ ") : " + bank.findByNumber(recieverNr).getAmount());
							} else
								System.out.println("The entered amount is not available");
							alternatives();
						} else
							System.out.println("Please enter a valid amount!");
					} else
						System.out.println("Please enter a valid account number");
				} else
					System.out.println("Please enter a valid account number");
				break;

			case 6:
				System.out.println("Please enter your name: ");
				String name = scan.nextLine();
				System.out.println("Please enter your social security number: ");
				idNr = scan.nextLong();

				System.out.println("You now own the following accounts " + bank.addAccount(name, idNr));
				alternatives();
				break;

			case 7:
				System.out.println("Please enter your Account Id: ");
				customerNr = scan.nextInt();
				if (bank.findByNumber(customerNr) != null) {
					bank.removeAccount(customerNr);
					alternatives();
				} else
					System.out.println("Please enter a valid Account number");
				break;

			case 8:
				if (bank.getNbrOfAccounts() == 0) {
					System.out.println("There are no accounts");
					alternatives();
				} else
					temp = bank.getAllAccounts();
				for (int i = 0; i < temp.size(); i++) {
					System.out.println("AccountNbr " + temp.get(i).getAccountNumber() + "(" + temp.get(i) + "): "
							+ temp.get(i).getAmount());
					alternatives();
				}
				break;

			case 9:
				System.exit(0);
				break;

			default:
				System.out.println("Nonvalid input, please try again");
				break;
			}
		}
	}

}
