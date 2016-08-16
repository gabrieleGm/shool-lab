package example;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class SeatsLeftCommand extends AbstractCommand {

	public boolean execute(Fields anInput, Fields anOutput) {
		return true;
	}
}