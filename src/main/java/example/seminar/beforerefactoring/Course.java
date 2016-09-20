package example.seminar.beforerefactoring;

public class Course {

	private final String _name;
	private final String _number;
	private final String _description;

	public Course(String name, String number, String description) {
		_name = name;
		_number = number;
		_description = description;
	}
	
	public String getName() {
		return _name;
	}

	public String getNumber() {
		return _number;
	}

	public String getDescription() {
		return _description;
	}
}
