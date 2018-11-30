package tp.p2.Commands;

import tp.p2.Game.Game;

public class HelpCommand extends NoParamsCommand{
	
	static final String NAME = "help";
	static final String CHAR = "H";
	static final String DEF = "[H]elp: print this help message.";
	
	public HelpCommand() {
		super(NAME, CHAR, DEF);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		System.out.println(CommandParser.commandHelp());
		//controller.setNoPrintGameState();
		return false;
	}

}

	
