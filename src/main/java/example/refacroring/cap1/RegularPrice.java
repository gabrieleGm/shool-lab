package example.refacroring.cap1;

public class RegularPrice extends Price{
	
	@Override
	public double getCharge(int aDaysRented) {
		double result = 2;
		if (aDaysRented > 2){
			result += (aDaysRented - 2) * 1.5;
		}
		return result;
	}

	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}

	@Override
	public int getFrequentRenterPoints(int aDaysRented) {
		return 1;
	}
}