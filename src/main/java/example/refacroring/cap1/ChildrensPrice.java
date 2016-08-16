package example.refacroring.cap1;

public class ChildrensPrice extends Price{
	
	@Override
	public double getCharge(int aDaysRented) {
		double result = 1.5;
		if (aDaysRented > 3){
			result += (aDaysRented - 3) * 1.5;
		}
		return result;
	}

	@Override
	public int getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	public int getFrequentRenterPoints(int aDaysRented) {
		return 1;
	}
}