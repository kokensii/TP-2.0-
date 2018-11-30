package tp.p2.Zombie;

import tp.p2.Game.GameObject;

public class Zombie extends GameObject{

	static final int DAMAGE = 1;
	protected int instant;
	protected int speed;
	protected char letra;
	
	public Zombie(int x, int y, int hp, int speed, char letra,String definicion) {
		super(x, y, hp, DAMAGE,letra,definicion);
		this.speed = speed;
		this.instant = 0;
	}
	
	@Override
	public void update(){ // Cuando el zombie llegue al final de la fila la partida se acabará
		//Comprobamos si es turno de que el zombie se mueva y que no haya ninguna planta delante
		if(this.instant % speed == 0 && !game.isPlant(x, y - 1) && !game.isZombie(x, y-1)) this.y--;
		else{
			//Si hay alguna planta cerca le restamos vida
			if(game.isPlant(x, y - 1)){
				game.restarVidaPlant(x, y - 1, getDamage());
			}
		}
		this.instant++;
	}

	@Override
	public int numcycles() {
		// TODO Auto-generated method stub
		return instant % speed;
	}
	
}
