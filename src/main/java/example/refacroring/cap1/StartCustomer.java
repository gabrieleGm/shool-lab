package example.refacroring.cap1;

public class StartCustomer {

	public static void main(String[] args) {
		Customer customer = new Customer("Gabriele", "Izzo");
		String result = customer.statement();
		System.out.println(result);
	}
}
