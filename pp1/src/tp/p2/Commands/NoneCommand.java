package tp.p2.Commands;

import tp.p2.Game.Game;

public class NoneCommand extends NoParamsCommand{
	
	static final String NAME = "none";
	static final String CHAR = "";
	static final String DEF = "skips cycle";
	
	public NoneCommand() {
		super(NAME, CHAR, DEF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		game.update();
		return true;
	} 
}
