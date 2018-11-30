package tp.p2.Commands;

import tp.p2.Game.Game;

public class ResetCommand extends NoParamsCommand{
	
	static final String NAME = "reset";
	static final String CHAR = "R";
	static final String DEF = "[R]eset: resets games.";
	
	public ResetCommand() {
		super(NAME, CHAR, DEF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.resetGame();
		return true;
	}

}
