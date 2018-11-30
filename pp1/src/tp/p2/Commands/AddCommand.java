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
	static final String INCNUMARGUMENTS = "Incorrect number of arguments for add command: [A]dd <plant> <x> <y>";
	static final String UNKPLANTS = "Unknown plant name: ";
	static final String INVARGS = "Invalid argument for add command, number expected: [A]dd <plant> <x> <y>";

	public AddCommand() {
		super(NAME, CHAR, DEF);
		x = -1;
		y = -1;
		planta = null;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		String name = Character.toString(planta.letra());
		Plant plant = PlantFactory.getPlant(name);
		boolean ex = false;
		if (game.addPlantToGame(plant, x, y)) {
			ex = true;
			game.update();
		}
		return ex;
	}

	public Command parse(String[] commandWords) throws CommandParseException {
		AddCommand salida = null;
		if (commandWords[0].equalsIgnoreCase(this.commandName)
				|| commandWords[0]
						.equalsIgnoreCase(commandName.substring(0, 1))) {
			salida = new AddCommand();
			if (commandWords.length != 4)
				throw new CommandParseException(INCNUMARGUMENTS);
			else {

				salida.planta = PlantFactory.getPlant(commandWords[1]);
				if (salida.planta == null) {
					throw new CommandParseException(UNKPLANTS + commandWords[1]);
				}
				try {
					salida.x = Integer.parseInt(commandWords[2]);
					salida.y = Integer.parseInt(commandWords[3]);
				} catch (NumberFormatException e) {
					throw new CommandParseException(INVARGS);
				}

				if (salida.x >= 4 || salida.y >= 7) { // Preguntar si podemos
														// poner un getName en
														// Plant
					throw new CommandParseException("Failed to add "
							+ salida.planta + ": (" + salida.x + ", "
							+ salida.y + ") is an invalid position");
				}

			}
		}
		return salida;
	}

}
