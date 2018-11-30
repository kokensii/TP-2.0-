package tp.p2.Controller;

import java.util.Scanner;

import tp.p2.Commands.Command;
import tp.p2.Commands.CommandParser;
import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Exceptions.CommandParseException;
import tp.p2.Game.Game;

public class Controller {

	public static final String prompt = "Command > ";
	public static final String unknownCommandMsg = "Comando no válido";

	private Game game;
	private Scanner in;
	private boolean noPrint;
	private boolean exit;

	public Controller(Game game) {
		this.game = game;
		this.in = new Scanner(System.in);
		this.noPrint = false;
		this.exit = false;
	}

	public void setNoPrintGameState() {
		noPrint = true;
	}

	public void printGame() {
		if (!noPrint)
			System.out.println(game.toString());
	}

	public void run() { // solicitar ordenes al usuario y ejecutarlas
		printGame();
		while (!game.isFinished() && !exit && !game.winGame()) {
			noPrint = false;

			System.out.println(prompt);
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command;
			try {
				command = CommandParser.parserCommand(words);
				if (command != null) {
					if (command.execute(game)) printGame();
				}
				else{
					System.out.println(unknownCommandMsg);
				}
			} catch (CommandParseException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
				setNoPrintGameState();
			} catch (CommandExecuteException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				setNoPrintGameState();
			}
		}
		if (game.isFinished()) {
			//System.out.println(game);
			System.out.println("Game over");
		}
		if (game.winGame()) {
			System.out.println(game);
			System.out.println("You Win");
		}
	}
}