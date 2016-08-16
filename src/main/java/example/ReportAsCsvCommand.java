package example;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class ReportAsCsvCommand extends AbstractCommand {

	private final Fields _someFields;

	public ReportAsCsvCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		String result = "no registered courses";
		if(!_someFields.containsKey("number")) { 
			anOutput.put("result", result);
			return true;
		}
		result = "\""+_someFields.firstValueFor("number") + "\"" + ";" + "\""+ _someFields.firstValueFor("name") + "\"" + ";" + "\"" + _someFields.firstValueFor("description") + "\""+ ";" + "\""+ _someFields.firstValueFor("atRoom") + "\"" + ";" + "\"" + _someFields.firstValueFor("seatsLeft") + "\"" +";";
		Fields partecipants = Fields.fromRaw(_someFields.firstValueFor("partecipants"));
		if(partecipants.isEmpty()){
			anOutput.put("result", result);
			return true;
		}
		result += "\n";
		result += "\""+ partecipants.firstValueFor("firstName") + "\""+ ";" + "\""+ partecipants.firstValueFor("lastName") + "\""+ ";";
		anOutput.put("result", result);
		return true;
	}
}
