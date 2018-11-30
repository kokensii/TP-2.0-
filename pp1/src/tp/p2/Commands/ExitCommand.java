package tp.p2.Commands;

import tp.p2.Game.Game;

public class ExitCommand extends NoParamsCommand{
	
	static final String NAME = "exit";
	static final String CHAR = "E";
	static final String DEF = "[E]xit: terminate the program.";
	
	public ExitCommand() {
		super(NAME, CHAR, DEF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.exit(); //Implementar en game
		//controller.setNoPrintGameState();
		return false;
	}
}
