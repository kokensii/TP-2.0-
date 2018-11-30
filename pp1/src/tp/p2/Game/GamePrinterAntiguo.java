package tp.p2.Game;

import tp.p2.util.MyStringUtils;

public class GamePrinterAntiguo{
	private int dimX; 
	private int dimY;
	private String[][] board;
	final String space = " ";
	
	public GamePrinterAntiguo(Game game, int dimX, int dimY) {
		this.dimX = dimX;
		this.dimY = dimY;
		encodeGame(game);
	}
	
	private void encodeGame(Game game) {
		board = new String[dimX][dimY];
		for(int i = 0; i < dimX; i++) {
			for(int j = 0; j < dimY; j++) {
				board[i][j] =  game.drawPersonaje(i, j);
			}
		}
	}
	
	public String toString() {

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
	
	public int getX(){
		return this.dimX;
	}
	
	public int getY(){
		return this.dimY;
	}
	
	public String[][] getBoard(){
		return this.board;
	}
}
