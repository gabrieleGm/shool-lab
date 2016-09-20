package example.seminar.vacca;

import java.util.Arrays;
import java.util.List;

@Deprecated
public class SeminarDetails {
	/** * @param args */
	public static void main(String[] args) {
		new SeminarDetails().start();
	}

	private void start() {
		Seminar matematica = new Seminar("Lugano", new Course("Fondamenti di matematica", 1, "Aritmetica di base"));
		Student stefano = new Student("Stefano", "Coluccia");
		matematica.enroll(stefano);
		matematica.enroll(new Student("ValentN-ANO", "Decarli"));
		matematica.enroll(new Student("Manlio", "VaccaLuzzo"));
		Seminar informatica = new Seminar("Manno", new Course("informatica", 2, "Sequence diagrams"));
		informatica.enroll(stefano);
		Seminar chimica = new Seminar("Bioggio", new Course("Chimica", 3, "Ossidoriduzioni"));
		List<Seminar> seminars = Arrays.asList(matematica, informatica, chimica);
		for (Seminar seminar : seminars) {
			System.out.println("***************************************************************************************************************\n");
			System.out.println("Seminario di "
					+ seminar.getCourse().getDetails() + " su "
					+ seminar.getCourse().getDescription() + "\n");
			System.out.println("Il seminario si terra' presso "
					+ seminar.getLocation()
					+ " e al momento sono ci sono ancora "
					+ seminar.getSeatsLeft() + " disponibili \n");
			System.out
					.println("***************************************************************************************************************"
							+ "\n\nGli studenti attualmente iscritti sono: \n");
			System.out.println(new PrintFactory(seminar).printPlain());
//			System.out.println(new PrintFactory(seminar).printHtml());
		}
	}
}
