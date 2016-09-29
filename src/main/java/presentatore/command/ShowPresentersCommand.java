package presentatore.command;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class ShowPresentersCommand extends AbstractCommand {

	private final Fields _someFields;

	public ShowPresentersCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		anOutput.putAll(_someFields.select("name"));
		return true;
	}
}
