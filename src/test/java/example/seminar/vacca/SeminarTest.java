package example.seminar.vacca;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SeminarTest {
	private Seminar seminar;
	private Course course;

	@Before
	public void setUp() throws Exception {
		course = new Course("courseName", 123, "description");
		seminar = new Seminar("Lugano", course);
	}

	@Test
	public void testGetCourse() {
		assertEquals(course, seminar.getCourse());
	}

	@Test
	public void testGetLocation() {
		assertEquals("Lugano", seminar.getLocation());
	}

	@Test
	public void testEnrollAndGetSeatsLeft() {
		assertEquals(20, seminar.getSeatsLeft());
		seminar.enroll(new Student("Stefano", "Coluccia"));
		assertEquals(19, seminar.getSeatsLeft());
		seminar.enroll(new Student("Pippo", "Pluto"));
		assertEquals(18, seminar.getSeatsLeft());
	}

	@Test
	public void testStudents() {
		assertEquals(0, seminar.students().size());
		seminar.enroll(new Student("Pippo", "Pluto"));
		assertEquals(1, seminar.students().size());
	}
}