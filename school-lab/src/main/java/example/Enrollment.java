package example;

import java.util.ArrayList;
import java.util.List;

public class Enrollment {

	private final Student _student;

	public Enrollment(Student student) {
		_student = student;
	}

	public List<String> getInfo() {
		ArrayList<String> result = new ArrayList<String>();
		result.add(_student.getInfo());
		return result;
	}
}
