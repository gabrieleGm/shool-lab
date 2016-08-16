package example;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class ReportAsHtmlCommand extends AbstractCommand {

	private final Fields _someFields;

	public ReportAsHtmlCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		String result = "no registered courses";
		if(!_someFields.containsKey("number")) { 
			anOutput.put("result", result);
			return true;
		}
		result = ""
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
					+ "</ul>";
		Fields partecipants = Fields.fromRaw(_someFields.firstValueFor("partecipants"));
		if(partecipants.isEmpty()){
			result +=""
			+ "</body>"
			+ "</html>";
			anOutput.put("result", result);
			return true;
		}
		result += "<div>partecipanti:</div>"
					+ "<ul>"
						+ "<li>" + partecipants.firstValueFor("firstName") + " " + partecipants.firstValueFor("lastName") + "</li>"
					+ "</ul>"
				+ "</body>"
				+ "</html>";
		result += "\n";
		anOutput.put("result", result);
		return true;
	}
}