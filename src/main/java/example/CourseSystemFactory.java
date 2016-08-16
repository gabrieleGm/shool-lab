package example;

import ch.gmtech.xutils.fields.Fields;
import ch.gmtech.xutils.system.CommandHandler;
import ch.gmtech.xutils.system.UnknownCommand;
import ch.gmtech.xutils.system.XSystem;

public class CourseSystemFactory {

	public static XSystem create() {
		Fields coursInformations = Fields.empty();
		CommandHandler commandHandler = new CommandHandler("course manager", new UnknownCommand("unsupported"));
		XSystem courseManager = new XSystem(commandHandler);
		commandHandler.put("createCours", new CreateCoursCommand(coursInformations));
		commandHandler.put("signUp", new SignUpCommand(coursInformations));
		commandHandler.put("reportAsCsv", new ReportAsCsvCommand(coursInformations));
		commandHandler.put("reportAsHtml", new ReportAsHtmlCommand(coursInformations));
		return courseManager;
	}

}
