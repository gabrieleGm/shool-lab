package example.seminar.afterrefactoring;

import ch.gmtech.gmcommonsxutils.fields.recogniser.AbstractFieldsRecogniser;
import ch.gmtech.xutils.commands.AbstractCommand;
import ch.gmtech.xutils.fields.Fields;
import ch.gmtech.xutils.fields.modifier.FieldsModifier;

public class ValidationCommand extends AbstractCommand {

	private final AbstractFieldsRecogniser _recognizer;
	private final AbstractCommand _reportAsCsvCommand;
	private final FieldsModifier _ifKo;
	private final Fields _someFields;

	public ValidationCommand(Fields someFields, AbstractFieldsRecogniser recognizer, AbstractCommand aReportAsCsvCommand, FieldsModifier ifKo) {
		_someFields = someFields;
		_recognizer = recognizer;
		_reportAsCsvCommand = aReportAsCsvCommand;
		_ifKo = ifKo;
	}

	public boolean execute(Fields anInput, Fields anOutput) {
		if(!_recognizer.recognise(_someFields)) {
			anOutput.putAll(_ifKo.applyTo(anOutput)); 
			return true;
		}
		_reportAsCsvCommand.execute(anInput, anOutput);
		return true;
	}
}
