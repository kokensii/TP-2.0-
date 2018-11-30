package tp.p2.Commands;

import tp.p2.Exceptions.CommandParseException;

public class CommandParser {
	
	private static Command[] availableCommands = {
		new AddCommand(),
		new HelpCommand(),
		new ResetCommand(),
		new ExitCommand(),
		new ListCommand(),
		new NoneCommand(),
		new ZombieCommand(),
		new PrintModeCommand(),
	};
	
	public static Command parserCommand(String[] commandWords) throws CommandParseException{
		for(Command c : availableCommands){
			Command com = c.parse(commandWords);
			if(com != null) return com;
		}
		throw new CommandParseException("Unknown command. Use ’help’ to see the available commands");
	}
	
	public static String commandHelp(){
		String salida = " The available commands are: \n";
		for(Command c : availableCommands) salida += c.helpText() + "\n";
		return salida;
	}
}
