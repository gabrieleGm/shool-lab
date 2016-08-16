package example.refacroring.cap1;

public class Rental {

	private final Movie _movie;
	private final int _daysRented;

	public Rental(int daysRented, Movie movie) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	public int getDaysRented() {
		return _daysRented;
	}
	
	public double getCharge(){
		return _movie.getCharge(_daysRented);
	}

	public int getFrequentRenterPoints() {
		return _movie.getFrequestnterRenterPoints(_daysRented);
	}
}