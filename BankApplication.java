import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		BankApplication instance = new BankApplication();
		instance.runApplication();

	}

	private void spacing() {
		System.out.println("                                                                                       ");
		System.out.println("***************************************************************************************");
	}

	private void alternatives() {
		System.out.println("                                                                         ");
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

	private void continueOrExit() {
		System.out.println("***************************************************************************************");
		System.out.println("                                                                                       ");
		System.out.println("Would you like to continue?");
		System.out.println("1. Main Menu");
		System.out.println("2. Exit");
		System.out.println("Please enter the corresponding number: ");

		Scanner scan2 = new Scanner(System.in);

		int chosen2 = scan2.nextInt();
		scan2.nextLine();

		switch (chosen2) {

		case 1:
			alternatives();
			break;

		case 2:
			System.exit(0);
			break;

		default:
			System.out.println("Nonvalid input, please try again");
			break;

		}

	}

	private void runApplication() {
		Scanner scan = new Scanner(System.in);
		Bank bank = new Bank();
		long idNr;
		int acNr;
		ArrayList<BankAccount> temp = null;
		alternatives();

		while (true) {

			int chosen = scan.nextInt();
			scan.nextLine();
			switch (chosen) {

			case 1:
				System.out.println("Please enter your social security number: ");
				idNr = scan.nextInt();
				spacing();
				if (bank.findHolder(idNr) != null) {
					for (int i = 0; i < bank.findAccountsForHolder(idNr).size(); i++) {
						System.out.println(bank.findAccountsForHolder(idNr).get(i));
					}
				} else
					System.out.println("There are no accounts with the Id:" + idNr + " ");
				continueOrExit();
				break;

			case 2:
				System.out.println("Please enter your Name: ");
				String nameChoice = scan.nextLine();
				String namePart = nameChoice.toLowerCase();
				if (bank.findbyPartofName(namePart).size() != 0) {
					for (int i = 0; i < bank.findbyPartofName(namePart).size(); i++) {
						spacing();
						System.out.println(bank.findbyPartofName(namePart).get(i));
					}
				} else
					spacing();
				System.out.println("There are no accounts under the Name:" + nameChoice + "!");
				continueOrExit();
				break;

			case 3:
				System.out.println("Please enter your Account number: ");
				acNr = scan.nextInt();
				if (bank.findByNumber(acNr) != null) {
					System.out.println("Amount to deposit: ");
//vi har ej öre längre
					int deposit = (int) Math.round(scan.nextDouble());

					if (deposit > 0) {
						bank.findByNumber(acNr).deposit(deposit);
						spacing();
						System.out.println("AccountNbr " + acNr + " (" + bank.findByNumber(acNr) + ") : "
								+ bank.findByNumber(acNr).getAmount());

					} else
						spacing();
					System.out.println("Please enter a valid amount!");
				} else
					spacing();
				System.out.println("Please enter a valid account number");
				continueOrExit();
				break;

			case 4:
				System.out.println("Please enter your Account Id: ");
				acNr = scan.nextInt();
				if (bank.findByNumber(acNr) != null) {
					System.out.println("Amount to withdraw: ");
					double withdraw = scan.nextDouble();

					if (withdraw > 0) {
						if (withdraw <= bank.findByNumber(acNr).getAmount()) {
							bank.findByNumber(acNr).withdraw(withdraw);
							spacing();
							System.out.println(bank.findByNumber(acNr));

						} else
							spacing();
						System.out.println("The entered amount is not available");
						System.out.println("Current Balance: " + bank.findByNumber(acNr).getAmount());

					} else
						spacing();
					System.out.println("Please enter a valid amount!");

				} else
					spacing();
				System.out.println("Please enter a valid account number");
				continueOrExit();
				break;

			case 5:
				System.out.println("Please enter the senders Account Id: ");
				acNr = scan.nextInt();

				if (bank.findByNumber(acNr) != null) {
					System.out.println("Please enter the recievers Account Id: ");
					int recieverNr = scan.nextInt();

					if (bank.findByNumber(recieverNr) != null) {
						System.out.println("Please enter the amount to transfer: ");
						double amount = scan.nextDouble();
						if (!(amount < 0)) {
							if (amount <= bank.findByNumber(acNr).getAmount()) {
								bank.findByNumber(acNr).withdraw(amount);
								bank.findByNumber(recieverNr).deposit(amount);
								spacing();
								System.out.println("AccountNbr " + acNr + " (" + bank.findByNumber(acNr) + "): "
										+ bank.findByNumber(acNr).getAmount());
								System.out.println("AccountNbr " + recieverNr + " (" + bank.findByNumber(recieverNr)
										+ ") : " + bank.findByNumber(recieverNr).getAmount());
							} else
								spacing();
							System.out.println("The entered amount is not available");
						} else
							spacing();
						System.out.println("Please enter a valid amount!");
					} else
						spacing();
					System.out.println("Please enter a valid account number");
				} else
					spacing();
				System.out.println("Please enter a valid account number");
				continueOrExit();
				break;

			case 6:
				System.out.println("Please enter your name: ");
				String name = scan.nextLine();
				System.out.println("Please enter your social security number: ");
				idNr = scan.nextLong();
				spacing();
				System.out.println("You now own the following accounts " + bank.addAccount(name, idNr));
				continueOrExit();
				break;

			case 7:
				System.out.println("Please enter your Account Id: ");
				acNr = scan.nextInt();
				if (bank.findByNumber(acNr) != null) {
					bank.removeAccount(acNr);
					spacing();
					System.out.println("Account " + acNr + " has been removed");

				} else
					spacing();
				System.out.println("Please enter a valid Account number");
				continueOrExit();
				break;

			case 8:
				if (bank.getNbrOfAccounts() == 0) {
					spacing();
					System.out.println("There are no accounts");
					continueOrExit();
					break;

				} else
					temp = bank.getAllAccounts();
				for (int i = 0; i < temp.size(); i++) {
					spacing();
					System.out.println("AccountNbr " + temp.get(i).getAccountNumber() + "(" + temp.get(i) + "): "
							+ temp.get(i).getAmount());

				}
				continueOrExit();
				break;

			case 9:
				System.exit(0);
				break;

			default:
				spacing();
				System.out.println("Nonvalid input, please try again");
				continueOrExit();
				break;
			}
		}
	}

}