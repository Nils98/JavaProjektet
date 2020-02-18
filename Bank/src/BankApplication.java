
public class BankApplication {
	public static void main(String[] args ) {
		Customer c1 = new Customer("Nils", 19981012);
		System.out.println(c1);
		Customer c2 = new Customer("Tusj", 19981012);
		System.out.println(c2);
		BankAccount a1 = new BankAccount(c1);
		System.out.println(a1);
		BankAccount a2 = new BankAccount("Nil",19971012);
		System.out.println(a2);
	}
}
