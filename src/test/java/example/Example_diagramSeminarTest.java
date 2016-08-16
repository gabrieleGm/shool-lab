package example;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ch.gmtech.xutils.fields.Fields;
import ch.gmtech.xutils.system.XSystem;

public class Example_diagramSeminarTest {

	private XSystem _course;

	@Before
	public void setUp(){
		_course = CourseSystemFactory.create();
	}
	
	@Test
	public void showReportAsCsv_noCourse() {
		Fields result = Fields.empty();
		_course.execute(Fields.fromRaw("commandName=reportAsCsv"), result);
		assertEquals("no registered courses", result.firstValueFor("result"));
	}
	
	@Test
	public void createCours() {
		_course.execute(Fields.fromRaw("commandName=createCours|number=AA123456|name=ComputerScience|description=Collaboration Diagram 1|atRoom=ROOM 123|maxPartecipants=5"), Fields.empty());
		Fields result = Fields.empty();
		_course.execute(Fields.fromRaw("commandName=reportAsCsv"), result);
		assertEquals("\"AA123456\";\"ComputerScience\";\"Collaboration Diagram 1\";\"ROOM 123\";\"5\";", result.firstValueFor("result"));
	}
	
	@Test
	public void signUp() {
		_course.execute(Fields.fromRaw("commandName=createCours|number=AA123456|name=ComputerScience|description=Collaboration Diagram 1|atRoom=ROOM 123|maxPartecipants=5"), Fields.empty());
		Fields result = Fields.empty();
		_course.execute(Fields.fromRaw("commandName=signUp|firstName=Gabriele|lastName=Izzo"), Fields.empty());
		_course.execute(Fields.fromRaw("commandName=reportAsCsv"), result);
		String expected = "\"AA123456\";\"ComputerScience\";\"Collaboration Diagram 1\";\"ROOM 123\";\"4\";";
		expected += "\n\"Gabriele\";\"Izzo\";";
		assertEquals(expected, result.firstValueFor("result"));
	}
	
	@Test
	public void showReportAsHtml() {
		_course.execute(Fields.fromRaw("commandName=createCours|number=AA123456|name=ComputerScience|description=Collaboration Diagram 1|atRoom=ROOM 123|maxPartecipants=5"), Fields.empty());
		Fields result = Fields.empty();
		_course.execute(Fields.fromRaw("commandName=signUp|firstName=Gabriele|lastName=Izzo"), Fields.empty());
		_course.execute(Fields.fromRaw("commandName=reportAsHtml"), result);
		String expected = "<html><head><title>ComputerScience</title></head><body><div>ComputerScience</div><ul><li>Collaboration Diagram 1</li><li>ROOM 123</li><li>4</li></ul><div>partecipanti:</div><ul><li>Gabriele Izzo</li></ul></body></html>";
		assertEquals(expected, result.firstValueFor("result"));
	}
	
//	@ multi partecipante
//	@ multi corso
}