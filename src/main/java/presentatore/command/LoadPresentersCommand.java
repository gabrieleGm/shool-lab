package presentatore.command;

import java.util.List;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class LoadPresentersCommand extends AbstractCommand {

	private final List<String> _presenters;
	private final AddPresenterCommand _addPresenterCommand;

	public LoadPresentersCommand(List<String> somePresenters, AddPresenterCommand addPresenterCommand) {
		_presenters = somePresenters;
		_addPresenterCommand = addPresenterCommand;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		for (String each : _presenters) {
			_addPresenterCommand.execute(Fields.single("commandName", "addPresenter").put("name", each), Fields.empty());
		}
		anOutput.put("outcome", "true");
		return true;
	}
}
