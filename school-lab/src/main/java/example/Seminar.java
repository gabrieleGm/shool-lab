package example;

import java.util.List;

public class Seminar {

	private final Course _course;
	private final String _location;
	private final String _seatsLeft;
	private final Enrollment _enrollment;

	public Seminar(String location, String seatsLeft, Course course, Enrollment enrollment) {
		_location = location;
		_seatsLeft = seatsLeft;
		_course = course;
		_enrollment = enrollment;
	}

	public String getName() {
		return _course.getName() +"/"+ _course.getNumber();
	}

	public String getDescription() {
		return _course.getDescription();
	}

	public String getLocation() {
		return _location;
	}

	public String getSeatsLeft() {
		return _seatsLeft;
	}

	public List<String> getStudentList() {
		return _enrollment.getInfo();
	}
}