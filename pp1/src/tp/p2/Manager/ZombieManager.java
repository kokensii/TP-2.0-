package tp.p2.Manager;

import java.util.Random;

import tp.p2.PlantsVsZombies.Level;

public class ZombieManager { // clase que lleva el control del numero de zombies que quedan por salir
	
	private Level level;
	private int numZombies;
	private Random rand;
	
	public ZombieManager(Level level, Random rand) {
		this.level = level;
		this.rand = rand;
		initZombies();
	}
	
	public void initZombies() { //Inicializamos el numero de zombies segun la dificultad
		this.numZombies = level.getNumZombies();
	}

	public boolean isZombieAdded() { 
		boolean zombie = false;
		double num = rand.nextDouble();
		if(num <= level.getFrequency() && numZombies > 0){
			zombie = true;
			this.numZombies--;
		}
		return zombie;
	}
	
	public int getNumZombies(){
		return this.numZombies;
	}
}
