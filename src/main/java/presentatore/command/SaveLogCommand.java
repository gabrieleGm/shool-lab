package presentatore.command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;

public class SaveLogCommand extends AbstractCommand {
	
	private final Fields _someFields;

	public SaveLogCommand(Fields someFields) {
		_someFields = someFields;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		String filePath = _someFields.firstValueFor("filePath");
		Fields toSave = anInput.select("name");
		toSave.put("recordDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		try {
			FileWriter writer = new FileWriter(new File(filePath));
			writer.append(toSave.toRaw());
			writer.close();
		} catch (IOException e) {
			anOutput.put("outcome", "false").put("message", e.getMessage());
		}
		anOutput.put("outcome", "true");
		return true;
	}
}
