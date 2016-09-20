package example.seminar.afterrefactoring;

import java.util.List;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class ReportAsHtmlCommand extends AbstractCommand {

	private final Fields _someFields;

	public ReportAsHtmlCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		String result = ""
				+ "<html>"
				+ "<head>"
					+ "<title>"+ _someFields.firstValueFor("name")  +"</title>"
				+ "</head>"
				+ "<body>"
					+ "<div>"+ _someFields.firstValueFor("name") +"</div>"
					+ "<ul>"
						+ "<li>"+ _someFields.firstValueFor("description")+"</li>"
						+ "<li>" +_someFields.firstValueFor("atRoom") +"</li>"
						+ "<li>"+_someFields.firstValueFor("seatsLeft") +"</li>"
						+ "<li>"+_someFields.firstValueFor("startDate") +"</li>"
					+ "</ul>";
		
		List<String> allPartecipants = _someFields.allValuesFor("partecipants");
		result += "<div>partecipanti:</div>";
		for (String each : allPartecipants) {
			Fields current = Fields.fromRaw(each);
			if(current.isEmpty()){
				result +=""
						+ "</body>"
						+ "</html>";
				anOutput.put("result", result);
				return true;
			}
			result +=
					  "<ul>"
					+ "<li>" + current.firstValueFor("firstName") + " " + current.firstValueFor("lastName") + "</li>"
					+ "</ul>";
		}
		result +=
				"</body>"
				+ "</html>";
		anOutput.put("result", result);
		return true;
	}
}