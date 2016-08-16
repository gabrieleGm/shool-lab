package example.refacroring.cap1;

public class Movie {

	static final int REGULAR = 0;
	static final int NEW_RELEASE = 1;
	static final int CHILDRENS = 2;
	private final String _title;
	private final Price _price;

	public Movie(String title, int moviePriceCode) {
		_price = setPriceCode(moviePriceCode);
		_title = title;
	}

	private Price setPriceCode(int aMoviePriceCode) {
		switch (aMoviePriceCode) {
			case Movie.REGULAR:
				return new RegularPrice();
			case Movie.NEW_RELEASE:
				return  new NewReleasePrice();
			case Movie.CHILDRENS:
				return  new ChildrensPrice();
		}
		throw new IllegalArgumentException("Incorrect Price Code");
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge(int aDaysRented) {
		return _price.getCharge(aDaysRented);
	}

	public int getFrequestnterRenterPoints(int aDaysRented) {
		return _price.getFrequentRenterPoints(aDaysRented);
	}
	

}
