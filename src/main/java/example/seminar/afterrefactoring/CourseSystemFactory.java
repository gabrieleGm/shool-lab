package example.seminar.afterrefactoring;

import ch.gmtech.gmcommonsxutils.fields.recogniser.AbstractFieldsRecogniser;
import ch.gmtech.gmcommonsxutils.fields.recogniser.FieldsContainsAllKeysRecogniser;
import ch.gmtech.xutils.fields.Fields;
import ch.gmtech.xutils.fields.modifier.FieldsPutAllOnModifier;
import ch.gmtech.xutils.system.CommandHandler;
import ch.gmtech.xutils.system.UnknownCommand;
import ch.gmtech.xutils.system.XSystem;

public class CourseSystemFactory {

	public static XSystem create() {
		AbstractFieldsRecogniser containsNumberRecognizer = new FieldsContainsAllKeysRecogniser("number","startDate");
		FieldsPutAllOnModifier ifKo = new FieldsPutAllOnModifier(Fields.single("result", "no registered courses"));
		
		Fields coursInformations = Fields.empty();
		CommandHandler commandHandler = new CommandHandler("course manager", new UnknownCommand("unsupported"));
		XSystem courseManager = new XSystem(commandHandler);
		commandHandler.put("createCours", new CreateSingleCoursCommand(coursInformations));
		commandHandler.put("signUp", new SignUpCommand(coursInformations));
		commandHandler.put("reportAsCsv", new ValidationCommand(coursInformations, containsNumberRecognizer, new ReportAsCsvCommand(coursInformations), ifKo));
		commandHandler.put("reportAsHtml", new ValidationCommand(coursInformations, containsNumberRecognizer,new ReportAsHtmlCommand(coursInformations), ifKo));
		return courseManager;
	}

}
