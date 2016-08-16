package example.refacroring.cap1;

public class DefaultPrice extends Price {

	@Override
	public int getPriceCode() {
		return -1;
	}

	@Override
	public double getCharge(int aDaysRented) {
		return 0;
	}

	@Override
	public int getFrequentRenterPoints(int aDaysRented) {
		return 0;
	}
}