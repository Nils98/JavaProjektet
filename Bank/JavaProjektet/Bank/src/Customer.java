
public class Customer {
	private String name;
	private long idNr;
	private static int customerNr = 1000;

	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		customerNr++;
	}

	public String getName() {
		return name;
	}

	public long getIdNr() {
		return idNr;
	}

	public static int getCustomerNr() {
		return customerNr;
	}

	public String toString() {
		return name + " " + idNr + " " + customerNr;

	}

}
