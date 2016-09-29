package presentatore.command;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class AddPresenterCommand extends AbstractCommand {

	private final Fields _someFields;

	public AddPresenterCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		_someFields.putAllMore(anInput.select("name"));
		anOutput.put("outcome", "true");
		return true;
	}
}
