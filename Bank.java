import java.util.ArrayList;

public class Bank {
	ArrayList<BankAccount> accounts;
	
	Bank() {
		accounts = new ArrayList<BankAccount>();
	
	}

	int addAccount(String holderName, long idNr) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getHolder().getName().contentEquals(holderName) && accounts.get(i).getHolder().getIdNr() == idNr) {
				BankAccount account = new BankAccount(accounts.get(i).getHolder());
				accounts.add(account);
				return account.getAccountNumber();
			}
		}
		BankAccount account = new BankAccount(holderName, idNr);
		accounts.add(account);
		return account.getAccountNumber();
	}

	Customer findHolder(long idNr) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getHolder().getIdNr() == idNr) {
				return accounts.get(i).getHolder();
			}
		}
		return null;

	}

	boolean removeAccount(int number) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getHolder().getIdNr() == number) {
				return true;
			}
		}
		return false;

	}

	ArrayList<BankAccount> getAllAccounts() {
		ArrayList<BankAccount> accountsSorted = new ArrayList<BankAccount>();
		for (int i = 0; i < accounts.size(); i++) {
			String name = accounts.get(i).getHolder().getName();
			int pos = 0;

			while (pos < accountsSorted.size() && accountsSorted.get(pos).getHolder().getName().compareTo(name) < 0) {
				pos++;
			}
			accountsSorted.add(pos, accounts.get(i));
		}
		return accountsSorted;

	}

	BankAccount findByNumber(int accountNumber) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountNumber() == accountNumber) {
				return accounts.get(i);
			}
		}
		return null;
	}

	ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> holdersAccounts = new ArrayList<BankAccount>();
		for (int i = 0; i < accounts.size() ; i++) {
			if (accounts.get(i).getHolder().getIdNr() == idNr) {
				holdersAccounts.add(accounts.get(i));
			}
		}
		return holdersAccounts;

	}

	ArrayList<Customer> findbyPartofName(String namePart) {
		ArrayList<Customer> matchingNamePart = new ArrayList<Customer>();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getHolder().getName().toLowerCase().contains(namePart)) {
				matchingNamePart.add(accounts.get(i).getHolder());
			}
		}
		return matchingNamePart;

	}
	int getNbrOfAccounts() {
		return accounts.size();
	}
}