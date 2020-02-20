
public class Customer {
	private String name;
	private long idNr;
	private static int counter = 101;
	private int customerNr;

	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		customerNr = counter;
		counter++;
	}

	public String getName() {
		return name;
	}

	public long getIdNr() {
		return idNr;
	}

	public int getCustomerNr() {
		return customerNr;
	}

	public String toString() {
		return "Kundnamn:" + name + ", idNr: " + idNr + ", customerNr: " + customerNr ;

	}

}
