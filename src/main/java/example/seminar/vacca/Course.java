package example.seminar.vacca;

@Deprecated
public class Course {
	private final String _name;
	private final Integer _number;
	private final String _description;

	public Course(String courseName, Integer courseNumber, String description) {
		_name = courseName;
		_number = courseNumber;
		_description = description;
	}

	public String getDescription() {
		return _description;
	}

	public String getDetails() {
		return _name + " (" + _number + ")";
	}
}