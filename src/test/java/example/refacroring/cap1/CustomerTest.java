package example.refacroring.cap1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void noRentals() {
		Customer customer = new Customer("Gabriele", "Izzo");
		String actual = customer.statement();
		assertEquals(
				"Rental Record for Gabriele Izzo\n"+
				"Amount owed is 0.0\n"+
				"You earned 0 frequent renter points", actual);
	}
	
	@Test
	public void noSupportedRental() {
		try{
			Customer customer = new Customer("Gabriele", "Izzo");
			customer.add(new Rental(1, new Movie("not supported movie", 123)));
			String actual = customer.statement();
		}catch(Exception e){
			assertTrue(true);
			return;
		}
		assertFalse(true);
	}
	
	@Test
	public void zeroDaysRented() {
		Customer customer = new Customer("Gabriele", "Izzo");
		customer.add(new Rental(0, new Movie("The jungle book", Movie.REGULAR)));
		String actual = customer.statement();
		assertEquals(
				"Rental Record for Gabriele Izzo\n"+
				"\tThe jungle book	2.0\n"+
				"Amount owed is 2.0\n"+
				"You earned 1 frequent renter points", actual);
	}
	
	@Test
	public void newMovieAndNegativeRentedDay() {
		Customer customer = new Customer("Gabriele", "Izzo");
		customer.add(new Rental(-1, new Movie("The jungle book", Movie.NEW_RELEASE)));
		String actual = customer.statement();
		assertEquals(
				"Rental Record for Gabriele Izzo\n"+
				"\tThe jungle book	-3.0\n"+
				"Amount owed is -3.0\n"+
				"You earned 1 frequent renter points", actual);
	}
	
	@Test
	public void rentRegularMovie() {
		Customer customer = new Customer("Gabriele", "Izzo");
		customer.add(new Rental(1, new Movie("The jungle book", Movie.REGULAR)));
		String actual = customer.statement();
		assertEquals(
				"Rental Record for Gabriele Izzo\n"+
				"\tThe jungle book	2.0\n"+
				"Amount owed is 2.0\n"+
				"You earned 1 frequent renter points", actual);
	}
	
	@Test
	public void rentRegularMovieWithOvercharge() {
		Customer customer = new Customer("Gabriele", "Izzo");
		customer.add(new Rental(3, new Movie("The jungle book", Movie.REGULAR)));
		String actual = customer.statement();
		assertEquals(
				"Rental Record for Gabriele Izzo\n"+
				"\tThe jungle book	3.5\n"+
				"Amount owed is 3.5\n"+
				"You earned 1 frequent renter points", actual);
	}
	
	@Test
	public void newReleaseMovie() {
		Customer customer = new Customer("Gabriele", "Izzo");
		customer.add(new Rental(1, new Movie("The jungle book", Movie.NEW_RELEASE)));
		String actual = customer.statement();
		assertEquals(
				"Rental Record for Gabriele Izzo\n"+
				"\tThe jungle book	3.0\n"+
				"Amount owed is 3.0\n"+
				"You earned 1 frequent renter points", actual);
	}
	
	@Test
	public void newReleaseMovieWithDoubledPoints() {
		Customer customer = new Customer("Gabriele", "Izzo");
		customer.add(new Rental(3, new Movie("The jungle book", Movie.NEW_RELEASE)));
		String actual = customer.statement();
		assertEquals(
				"Rental Record for Gabriele Izzo\n"+
				"\tThe jungle book	9.0\n"+
				"Amount owed is 9.0\n"+
				"You earned 2 frequent renter points", actual);
	}
	
	@Test
	public void childrensMovie() {
		Customer customer = new Customer("Gabriele", "Izzo");
		customer.add(new Rental(1, new Movie("The jungle book", Movie.CHILDRENS)));
		String actual = customer.statement();
		assertEquals(
				"Rental Record for Gabriele Izzo\n"+
				"\tThe jungle book	1.5\n"+
				"Amount owed is 1.5\n"+
				"You earned 1 frequent renter points", actual);
	}
	
	@Test
	public void childrensMovieWithOvercharge() {
		Customer customer = new Customer("Gabriele", "Izzo");
		customer.add(new Rental(4, new Movie("The jungle book", Movie.CHILDRENS)));
		String actual = customer.statement();
		assertEquals(
				"Rental Record for Gabriele Izzo\n"+
				"\tThe jungle book	3.0\n"+
				"Amount owed is 3.0\n"+
				"You earned 1 frequent renter points", actual);
	}
}
