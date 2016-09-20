package example.seminar.afterrefactoring;

import java.util.List;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class ReportAsCsvCommand extends AbstractCommand {

	private final Fields _someFields;

	public ReportAsCsvCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		String result = "\""+_someFields.firstValueFor("number") + "\"" + ";" + "\""+ _someFields.firstValueFor("name") + "\"" + ";" + "\"" + _someFields.firstValueFor("description") + "\""+ ";" + "\""+ _someFields.firstValueFor("atRoom") + "\"" + ";" + "\"" + _someFields.firstValueFor("seatsLeft") + "\"" +";" + "\"" + _someFields.firstValueFor("startDate") + "\"";
		
		List<String> allPartecipants = _someFields.allValuesFor("partecipants");
		for (String each : allPartecipants) {
			Fields current = Fields.fromRaw(each);
			if(current.isEmpty()){
				anOutput.put("result", result);
				return true;
			}
			result += "\n";
			result += "\""+ current.firstValueFor("firstName") + "\""+ ";" + "\""+ current.firstValueFor("lastName") + "\""+ ";";
		}
		anOutput.put("result", result);
		return true;
	}
}
