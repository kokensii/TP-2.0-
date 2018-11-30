package tp.p2.Commands;

import tp.p2.Exceptions.CommandParseException;
import tp.p2.Game.Game;

public class PrintModeCommand extends Command {
	
	private String mode;
	static final String NAME = "printMode";
	static final String CHAR = "P";
	static final String DEF = "[P]rintMode <mode>: change print mode [Realese|Debug].";
	
	public PrintModeCommand() {
		super(NAME, CHAR, DEF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game){
		// TODO Auto-generated method stub
		game.setPrintMode(this.mode);
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		// TODO Auto-generated method stub
		PrintModeCommand c = null;
		if(commandWords[0].equalsIgnoreCase(this.commandName) 
				|| commandWords[0].equalsIgnoreCase(commandName.substring(0,1))){
			c = new PrintModeCommand();
			if(commandWords.length != 2)
				throw new CommandParseException("Incorrect number of arguments for printmode command: [P]rintMode release|debug");
			else{
				c.mode = commandWords[1];
				if(!((commandWords[0].equalsIgnoreCase(commandName)
						|| commandWords[0].equalsIgnoreCase(commandName.substring(0,1)))
						&& c.mode.equalsIgnoreCase("release") || c.mode.equalsIgnoreCase("debug"))){
					throw new CommandParseException("Unknown print mode: " + c.mode);
				}
			}
		}
		return c;
	}

}
