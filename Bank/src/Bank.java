import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> accounts;

	Bank() {

	}

	int addAccount(String holderName, long idNr) {
			for (int i = 0; i < accounts.size() - 1; i++) {
				if (accounts.get(i).getHolder().getName() == holderName && accounts.get(i).getHolder().getIdNr() == idNr) {
					BankAccount account = new BankAccount(accounts.get(i).getHolder());
					accounts.add(account);
					return BankAccount.getAccountNumber();
				}
			}
			BankAccount account = new BankAccount(holderName, idNr);
			accounts.add(account);
			return BankAccount.getAccountNumber();
		}
	Customer findHolder(long idNr) {
		for (int i = 0; i < accounts.size() - 1; i++) {
			if (accounts.get(i).getHolder().getIdNr() == idNr) {
				return accounts.get(i).getHolder();
			}
		}
		return null;
		
	}
	boolean removeAccount(int number) {
		
	}
}
