package tp.p2.Commands;

import tp.p2.Exceptions.CommandParseException;

public abstract class NoParamsCommand extends Command {

	public NoParamsCommand(String commandText, String commandTextMsg,
			String helpTextMsg) {
		super(commandText, commandTextMsg, helpTextMsg);
	}

	
	public Command parse(String[] commandWords) throws CommandParseException {
		Command c = null;
		if (commandWords[0].equalsIgnoreCase("")) commandWords[0] = "none";
		if ((commandWords[0].equalsIgnoreCase(commandName)
			|| commandWords[0].equalsIgnoreCase(commandName.substring(0,1))))
			if (commandWords.length == 1)
				c = this;
			else
				throw new CommandParseException(commandWords[0] + " command has no arguments");
		return c;
	}
}
