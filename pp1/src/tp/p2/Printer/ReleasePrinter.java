package tp.p2.Printer;

import tp.p2.Game.Game;
import tp.p2.Manager.SuncoinManager;
import tp.p2.Manager.ZombieManager;
import tp.p2.util.MyStringUtils;

public class ReleasePrinter extends BoardPrinter{
	
	private String[][] board;
	private int dimX, dimY;
	final String space = " ";
	
	public ReleasePrinter(Game game, int x, int y, SuncoinManager managerSuns,ZombieManager managerZombie,long seed) {
		super(game);
		dimX = x;
		dimY = y;
		board = new String[dimX][dimY];
	}

	@Override
	public void encodeGame() {
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {
				board[i][j] =  game.drawPersonaje(i, j);
			}
		}
	}

	@Override
	public String printGame() {
		// TODO Auto-generated method stub
		encodeGame();
		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (dimY * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
		
		StringBuilder str = new StringBuilder();
		
		str.append(lineDelimiter);
		
		for(int i=0; i<dimX; i++) {
				str.append(margin).append(vDelimiter);
				for (int j=0; j<dimY; j++) {
					str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
				}
				str.append(lineDelimiter);
		}
		return str.toString();
	}

}
