package example.seminar.vacca;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {
	private Course course;

	@Before
	public void setUp() throws Exception {
		course = new Course("courseName", 123, "description");
	}

	@Test
	public void testGetDescription() {
		assertEquals("description", course.getDescription());
	}

	@Test
	public void testGetDetails() {
		assertEquals("courseName (123)", course.getDetails());
	}
}