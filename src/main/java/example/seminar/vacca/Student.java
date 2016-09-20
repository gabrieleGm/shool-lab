package example.seminar.vacca;

@Deprecated
public class Student {
	private final String _name;
	private final String _lastname;

	public Student(String name, String lastname) {
		_name = name;
		_lastname = lastname;
	}

	public String getInfo() {
		return _name + " " + _lastname;
	}
}