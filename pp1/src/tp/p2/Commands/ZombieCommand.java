package tp.p2.Commands;

import tp.p2.Game.Game;
import tp.p2.Zombie.ZombieFactory;

public class ZombieCommand extends NoParamsCommand {
	
	static final String NAME = "zombieList";
	static final String CHAR = "Z";
	static final String DEF = "[Z]ombieList: print the list of available zombies.";
	
	public ZombieCommand() {
		super(NAME, CHAR, DEF);
	}

	public boolean execute(Game game) {
		System.out.println(ZombieFactory.listOfAvilableZombies());
		//controller.setNoPrintGameState();
		return false;
	}

}