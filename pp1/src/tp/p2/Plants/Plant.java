package tp.p2.Plants;

import tp.p2.Game.*;

public abstract class Plant extends GameObject{
	
	private int cost; 
	
	public Plant(int x, int y, int hp, int dmg, int cost, char letra, String definicion) {
		super(x, y, hp, dmg, letra, definicion);
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}
	
}
