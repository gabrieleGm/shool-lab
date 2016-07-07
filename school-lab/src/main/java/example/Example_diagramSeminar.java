package example;

import java.util.List;

public class Example_diagramSeminar {

	public static void main(String[] args) {
		Seminar seminar = new Seminar("ROOM 123", "5", new Course("Computer Science", "AA123456", "Collaboration Diagram 1"), new Enrollment(new Student("Gabriele")));
		String name = seminar.getName();
		String description = seminar.getDescription();
		String location = seminar.getLocation();
		String seatsLeft = seminar.getSeatsLeft();
		List<String> studentList = seminar.getStudentList();
		System.out.println(name);
		System.out.println(description);
		System.out.println(location);
		System.out.println(seatsLeft);
		System.out.println(studentList.toString());
	}
}
