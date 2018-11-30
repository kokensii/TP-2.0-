package tp.p2.Commands;

import tp.p2.Game.Game;
import tp.p2.Plants.PlantFactory;

public class ListCommand extends NoParamsCommand{
	
	static final String NAME = "list";
	static final String CHAR = "L";
	static final String DEF = "[L]ist: print the list of available plants.";
	
	public ListCommand() {
		super(NAME, CHAR, DEF);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		System.out.println(PlantFactory.listOfAvilablePlants());
		//controller.setNoPrintGameState();
		return false;
	}

}
