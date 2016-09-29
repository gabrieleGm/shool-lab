package presentatore.command;

import java.util.List;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class PullOutCommand extends AbstractCommand {

	private final Fields _someFields;

	public PullOutCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		List<String> name = _someFields.allValuesFor("name");
		int randomNum = 0 + (int)(Math.random() * name.size());
		anOutput.put("outcome", "true");
		anOutput.put("theWinnerIs", name.get(randomNum));
		return true;
	}
}