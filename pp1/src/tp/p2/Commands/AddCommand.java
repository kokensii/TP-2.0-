package tp.p2.Commands;

import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Game.Game;
import tp.p2.Plants.*;

public class AddCommand extends Command {

	private int x;
	private int y;
	private Plant planta;
	static final String NAME = "add";
	static final String CHAR = "A";
	static final String DEF = "[A]dd <plant> <x> <y>: adds a plant in position x, y.";

	public AddCommand() {
		super(NAME, CHAR, DEF);
		x = -1;
		y = -1;
		planta = null;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		
		boolean ex = false;
		if (game.isEmpty(x, y)) {
			if (game.comprobarSuns(x, y, planta)) {
				game.addPlantToGame(this.planta, x, y);
				ex = true;
				game.update();
			} else {
				throw new CommandExecuteException("Failed to add " + this.planta + ": not enough suncoins to buy it");
			}
		}else{
			throw new CommandExecuteException("Failed to add " + this.planta + ": position (" + this.x + ", " + this.y + ") is already occupied");
		}
		return ex;
	}

	
	public Command parse(String[] commandWords) throws CommandParseException {
		AddCommand salida = null;
		if(commandWords[0].equalsIgnoreCase(this.commandName) 
				|| commandWords[0].equalsIgnoreCase(commandName.substring(0,1))){
			salida = new AddCommand();
			if (commandWords.length != 4)
				throw new CommandParseException("Incorrect number of arguments for add command: [A]dd <plant> <x> <y>");
			else {	

				salida.planta = PlantFactory.getPlant(commandWords[1]);
				if(salida.planta == null){
					throw new CommandParseException("Unknown plant name: " + commandWords[1]);
				}
				try{
					salida.x = Integer.parseInt(commandWords[2]);
					salida.y = Integer.parseInt(commandWords[3]);
				}
				catch(NumberFormatException e){
					throw new CommandParseException("Invalid argument for add command, number expected: [A]dd <plant> <x> <y>");
				}
				
				if (salida.x >= 4|| salida.y >= 7) { //Preguntar si podemos poner un getName en Plant
					throw new CommandParseException("Failed to add " + salida.planta + ": (" + salida.x + ", " + salida.y + ") is an invalid position");
				}
				
				
			}
		}
		return salida;
	}

}
