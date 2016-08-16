package example.refacroring.cap1;

public class NewReleasePrice extends Price{

	@Override
	public double getCharge(int aDaysRented) {
		return aDaysRented * 3;
	}

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	@Override
	public int getFrequentRenterPoints(int aDaysRented) {
		if (aDaysRented >1) return 2;
		return 1;
	}
}