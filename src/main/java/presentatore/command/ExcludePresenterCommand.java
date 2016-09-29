package presentatore.command;

import java.util.List;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class ExcludePresenterCommand extends AbstractCommand {

	private final Fields _someFields;

	public ExcludePresenterCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		String name = anInput.firstValueFor("name");
		List<String> currentPresenters = _someFields.allValuesFor("name");
		currentPresenters.remove(name);
		_someFields.remove("name");
		for (String each : currentPresenters) {
			if(each.equals(name)) continue;
			_someFields.putMore("name", each);
		}
		return true;
	}
}
