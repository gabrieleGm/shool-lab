package example.seminar.vacca;

import java.util.ArrayList;
import java.util.List;


@Deprecated
public class Seminar {
	private final Course _course;
	private final int _seatsLeft = 20;
	private final String _location;
	private final List<Student> _students = new ArrayList<Student>();

	public Seminar(String location, Course course) {
		_course = course;
		_location = location;
	}

	public Course getCourse() {
		return _course;
	}

	public String getLocation() {
		return _location;
	}

	public int getSeatsLeft() {
		return _seatsLeft - _students.size();
	}

	public void enroll(example.seminar.vacca.Student aStefano) {
		_students.add(aStefano);
	}

	public List<Student> students() {
		return _students;
	}
}