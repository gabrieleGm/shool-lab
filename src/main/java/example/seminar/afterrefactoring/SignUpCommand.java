package example.seminar.afterrefactoring;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class SignUpCommand extends AbstractCommand {

	private final Fields _someFields;

	public SignUpCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		_someFields.put("seatsLeft", String.valueOf(_someFields.firstIntValueFor("seatsLeft") - 1));
		_someFields.putMore("partecipants", anInput.select("firstName", "lastName").toRaw());
		return true;
	}
}