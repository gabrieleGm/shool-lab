package presentatore.start;

import java.util.ArrayList;
import java.util.List;

import presentatore.command.AddPresenterCommand;
import presentatore.command.ExcludePresenterCommand;
import presentatore.command.LoadPresentersCommand;
import presentatore.command.PullOutCommand;
import presentatore.command.SaveLogCommand;
import presentatore.command.ShowPresentersCommand;
import ch.gmtech.xremote.rmi.server.CreateRegistry;
import ch.gmtech.xremote.rmi.server.RmiServer;
import ch.gmtech.xutils.commands.MultiCommand;
import ch.gmtech.xutils.fields.Fields;
import ch.gmtech.xutils.system.CommandHandler;
import ch.gmtech.xutils.system.UnknownCommand;
import ch.gmtech.xutils.system.XSystem;

public class StartPresentatore {

	public static void main(String[] args) throws Exception {
		List<String> presenters = new ArrayList<String>();
		presenters.add("Gabriele");
		presenters.add("Massi");
		presenters.add("Franco");
		presenters.add("Pino");
		presenters.add("Matteo");
		presenters.add("Alessandro");
		presenters.add("Vacca");
		presenters.add("Enri");
		presenters.add("Manlio");
		presenters.add("Stefano");
		presenters.add("Dario");
		presenters.add("Gennaro");
		presenters.add("Valentino");
		presenters.add("Mattia");
		presenters.add("Chicco");
		
		Fields someFields = Fields.empty();
		
		MultiCommand multiCommand = new MultiCommand();
		multiCommand.add(new ExcludePresenterCommand(someFields)).add(new SaveLogCommand(Fields.single("filePath", "/Data/eiteam/demo/gabri/squola/notReadyPresenters.log")));
		
		CommandHandler commandHandler = new CommandHandler("presentatore", new UnknownCommand("response"));
		commandHandler.put("loadPresenters", new LoadPresentersCommand(presenters, new AddPresenterCommand(someFields)));
		commandHandler.put("addPresenter", new AddPresenterCommand(someFields));
		commandHandler.put("exclude", multiCommand);
		commandHandler.put("pullOut", new PullOutCommand(someFields));
		commandHandler.put("showPresenters", new ShowPresentersCommand(someFields));
		XSystem system = new XSystem(commandHandler);
		
		RmiServer server = new RmiServer(5544, new CreateRegistry());
		server.put("pullOut", system);
		server.start();
	}
}
