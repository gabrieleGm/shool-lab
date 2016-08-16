package example.refacroring.cap1;

import java.util.ArrayList;
import java.util.List;


public class Customer {

	private final String _firstName;
	private final String _lastName;
	private final List<Rental> _rentals = new ArrayList<Rental>();
	
	public Customer(String firstName, String lastName) {
		_firstName = firstName;
		_lastName = lastName;
	}
	
	public String statement() {
        double totalAmount = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : _rentals) {
        	result += "\t" + each.getMovie().getTitle()+ "\t" +  String.valueOf(getTotalCharged()) + "\n";
        	totalAmount += each.getCharge();
        }
        //add footer lines
        result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }
	
	public String htmlStatement(){
		double totalAmount = 0;
        String result = "<H1>Rentals for<EM>"+ getName() + "</EM></H1><P>\n";
        for (Rental each : _rentals) {
        	result += "\t" + each.getMovie().getTitle()+ ": " +  String.valueOf(getTotalCharged()) + "<BR>\n";
        	totalAmount += each.getCharge();
        }
        //add footer lines
        result +=  "<P>You owe <EM>" + String.valueOf(totalAmount) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		 for (Rental each : _rentals) {
	        	result += each.getFrequentRenterPoints();
	        }
		 return result;
	}

	private double getTotalCharged() {
		double result = 0;
		 for (Rental each : _rentals) {
	        	result += each.getCharge();
	        }
		 return result;
	}

	private String getName() {
		return _firstName + " "+ _lastName;
	}

	public void add(Rental aRental) {
		_rentals.add(aRental);
	}
}