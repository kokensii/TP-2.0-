package tp.p2.Commands;

import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Game.Game;

public abstract class Command {

	private String helpText;
	private String helpInfo;
	protected final String commandName;
	
	public Command(String commandText, String commandTextMsg, String helpTextMsg){
		commandName = commandText;
		helpText = commandTextMsg;
		helpInfo = helpTextMsg;
	}
	
	public abstract boolean execute(Game game) throws CommandExecuteException;
	public abstract Command parse(String[] commandWords) throws CommandParseException;
	
	public String helpText(){return " " + helpText + ": " + helpInfo;}
}
