package example.seminar.afterrefactoring;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class CreateSingleCoursCommand extends AbstractCommand{

	private final Fields _someFields;

	public CreateSingleCoursCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		_someFields.putAll(anInput.reject("commandName"));
		int maxPartecipants = _someFields.firstIntValueFor("maxPartecipants");
		if(!_someFields.containsKey("seatsLeft")){
			_someFields.put("seatsLeft", String.valueOf(maxPartecipants));
		}
		return true;
	}
}
