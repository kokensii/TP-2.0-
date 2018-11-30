//PlanstVsZombies HECHA POR JAVIER NAVARRO Y JORGE FAJARDO

package tp.p2.PlantsVsZombies;

import java.util.Random;

import tp.p2.Controller.Controller;
import tp.p2.Exceptions.CommandExecuteException;
import tp.p2.Game.Game;

public class PlantsVsZombies {

	public static void main(String[] args) throws CommandExecuteException {
		Level level = null;
		Random rand;
		long seed = 0; //Mirar bien
		String modePrinter = "";
		Game game;
		Controller controller;
		
		if((args.length < 1) || (args.length > 3)){
			System.out.println("Usage: plantsVsZombies <EASY|HARD|INSANE> [seed]");
			System.exit(1);
		}
		else{
			if(args[0].equals("EASY")) level = Level.EASY;
			else if(args[0].equals("HARD")) level = Level.HARD;
			else if(args[0].equals("INSANE")) level = Level.INSANE;
			else{
				System.out.println("Usage: plantsVsZombies <EASY|HARD|INSANE> [seed]: level must be one of: EASY, HARD, INSANE");
				System.exit(1);
			}
			
			if(args.length == 3) {
				try{
					seed = Integer.parseInt(args[1]);
					modePrinter = args[2];
				}catch(NumberFormatException e){
					System.out.println("Usage: plantsVsZombies <EASY|HARD|INSANE> [seed]: the seed must be a number");
					System.exit(1); //Salir del programa
				}
			}
			else {
				seed = new Random().nextInt(1000);
				modePrinter = args[1];
			}
			
			rand = new Random(seed);
			game = new Game(level, rand, modePrinter,seed);
			controller = new Controller(game);
			controller.run();
		}
	}
}
