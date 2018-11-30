package tp.p2.Printer;

import tp.p2.Game.Game;

public abstract class BoardPrinter implements GamePrinter{
	
	protected Game game;
	
	public BoardPrinter(Game game){
		this.game = game;
	}
	//¿Pintar tablero no deberia de ser abstracta ya que se pinta de forma distinta?
	
	public abstract void encodeGame();
	//metodo print game abs
}
