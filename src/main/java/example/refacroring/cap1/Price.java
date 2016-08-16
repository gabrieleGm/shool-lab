package example.refacroring.cap1;

public abstract class Price {

	public abstract int getPriceCode();
	public abstract double getCharge(int aDaysRented);
	public abstract int getFrequentRenterPoints(int aDaysRented);
}
