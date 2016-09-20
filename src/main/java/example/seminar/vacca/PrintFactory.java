package example.seminar.vacca;

@Deprecated
public class PrintFactory {
	private final Seminar _seminar;

	public PrintFactory(Seminar seminar) {
		_seminar = seminar;
	}

	public String printPlain() {
		if (_seminar.students().isEmpty()) {
			return "AL MOMENTO NON SONO PRESENTI ISCRIZIONI";
		}
		String studentList = "";
		for (Student student : _seminar.students()) {
			studentList += "			** " + student.getInfo() + " ** \n";
		}
		return studentList;
	}

	public String printHtml() {
		if (_seminar.students().isEmpty()) {
			return "AL MOMENTO NON SONO PRESENTI ISCRIZIONI";
		}
		String studentList = "<p><ul>";
		for (Student student : _seminar.students()) {
			studentList += "<li>" + student.getInfo() + "</li>";
		}
		return studentList + "</ul></p>";
	}
}