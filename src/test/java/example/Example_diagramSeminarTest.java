package example;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ch.gmtech.xutils.fields.Fields;
import ch.gmtech.xutils.system.XSystem;
import example.seminar.afterrefactoring.CourseSystemFactory;

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
		_course.execute(Fields.fromRaw("commandName=createCours|number=AA123456|name=ComputerScience|description=Collaboration Diagram 1|atRoom=ROOM 123|maxPartecipants=5|startDate=2016-09-20 14:30:00"), Fields.empty());
		Fields result = Fields.empty();
		_course.execute(Fields.fromRaw("commandName=reportAsCsv"), result);
		assertEquals("\"AA123456\";\"ComputerScience\";\"Collaboration Diagram 1\";\"ROOM 123\";\"5\";\"2016-09-20 14:30:00\"" , result.firstValueFor("result"));
	}
	
	@Test
	public void signUp() {
		_course.execute(Fields.fromRaw("commandName=createCours|number=AA123456|name=ComputerScience|description=Collaboration Diagram 1|atRoom=ROOM 123|maxPartecipants=5|startDate=2016-09-20 14:30:00"), Fields.empty());
		Fields result = Fields.empty();
		_course.execute(Fields.fromRaw("commandName=signUp|number=AA123456|firstName=Gabriele|lastName=Izzo"), Fields.empty());
		_course.execute(Fields.fromRaw("commandName=reportAsCsv"), result);
		String expected = "\"AA123456\";\"ComputerScience\";\"Collaboration Diagram 1\";\"ROOM 123\";\"4\";\"2016-09-20 14:30:00\"";
		expected += "\n\"Gabriele\";\"Izzo\";";
		assertEquals(expected, result.firstValueFor("result"));
	}
	
	@Test
	public void showReportAsHtml() {
		_course.execute(Fields.fromRaw("commandName=createCours|number=AA123456|name=ComputerScience|description=Collaboration Diagram 1|atRoom=ROOM 123|maxPartecipants=5|startDate=2016-09-22 14:30:00"), Fields.empty());
		Fields result = Fields.empty();
		_course.execute(Fields.fromRaw("commandName=signUp|number=AA123456|firstName=Gabriele|lastName=Izzo"), Fields.empty());
		_course.execute(Fields.fromRaw("commandName=reportAsHtml"), result);
		String expected = "<html><head><title>ComputerScience</title></head><body><div>ComputerScience</div><ul><li>Collaboration Diagram 1</li><li>ROOM 123</li><li>4</li><li>2016-09-22 14:30:00</li></ul><div>partecipanti:</div><ul><li>Gabriele Izzo</li></ul></body></html>";
		assertEquals(expected, result.firstValueFor("result"));
	}
	
	@Test
	public void showReportAsCsv_MultiPartecipant(){
		_course.execute(Fields.fromRaw("commandName=createCours|number=AA123456|name=ComputerScience|description=Collaboration Diagram 1|atRoom=ROOM 123|maxPartecipants=5|startDate=2016-09-20 14:30:00"), Fields.empty());
		Fields result = Fields.empty();
		_course.execute(Fields.fromRaw("commandName=signUp|number=AA123456|firstName=Gabriele|lastName=Izzo"), Fields.empty());
		_course.execute(Fields.fromRaw("commandName=signUp|number=AA123456|firstName=Ciccio|lastName=Pasticcio"), Fields.empty());
		_course.execute(Fields.fromRaw("commandName=reportAsCsv"), result);
		String expected = "\"AA123456\";\"ComputerScience\";\"Collaboration Diagram 1\";\"ROOM 123\";\"3\";\"2016-09-20 14:30:00\"";
		expected += "\n\"Gabriele\";\"Izzo\";";
		expected += "\n\"Ciccio\";\"Pasticcio\";";
		assertEquals(expected, result.firstValueFor("result"));
	}
	
	@Test
	public void showReportAsHtml_MultiPartecipant(){
		_course.execute(Fields.fromRaw("commandName=createCours|number=AA123456|name=ComputerScience|description=Collaboration Diagram 1|atRoom=ROOM 123|maxPartecipants=5|startDate=2016-09-20 14:30:00"), Fields.empty());
		Fields result = Fields.empty();
		_course.execute(Fields.fromRaw("commandName=signUp|number=AA123456|firstName=Gabriele|lastName=Izzo"), Fields.empty());
		_course.execute(Fields.fromRaw("commandName=signUp|number=AA123456|firstName=Ciccio|lastName=Pasticcio"), Fields.empty());
		_course.execute(Fields.fromRaw("commandName=reportAsHtml"), result);
		String expected = "<html><head><title>ComputerScience</title></head><body><div>ComputerScience</div><ul><li>Collaboration Diagram 1</li><li>ROOM 123</li><li>3</li><li>2016-09-20 14:30:00</li></ul><div>partecipanti:</div><ul><li>Gabriele Izzo</li></ul><ul><li>Ciccio Pasticcio</li></ul></body></html>";
		assertEquals(expected , result.firstValueFor("result"));
	}
}