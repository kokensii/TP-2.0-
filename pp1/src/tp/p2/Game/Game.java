package tp.p2.Game;

import java.util.Random;







import tp.p2.Manager.SuncoinManager;
import tp.p2.Manager.ZombieManager;
import tp.p2.Plants.Plant;
import tp.p2.Plants.PlantFactory;
import tp.p2.PlantsVsZombies.Level;
import tp.p2.Printer.DebugPrinter;
import tp.p2.Printer.GamePrinter;
import tp.p2.Printer.ReleasePrinter;
import tp.p2.Zombie.Zombie;
import tp.p2.Zombie.ZombieFactory;

public class Game {
	
	static final int DIMX = 4;
	static final int DIMY = 8; 
	static final int SUNFLOWER = 20;
	static final int PEASHOOTER = 50;
	
	private GameObjectList plantList;
	private GameObjectList zombieList;
	private SuncoinManager managerSuns;
	private ZombieManager managerZombie;
	private int contCycles;
	private Random aleatorio = new Random(System.currentTimeMillis());
	private Level level;
	private boolean end;
	private GamePrinter gp;
	private long seed;
	private String mode;
	
	public Game(Level level, Random rand, String modePrinter, long seed) {
		this.level = level;
		this.contCycles = 0;
		initZombieList();
		initPlantList();
		initSuncoinManager();
		initZombieManager();
		this.aleatorio = rand;
		this.end = false;
		this.seed = seed;
		
		//cambios 
		this.mode = modePrinter;
		
		if(modePrinter.equals("RELEASE")) {
			this.gp = new ReleasePrinter(this, DIMX, DIMY, managerSuns,managerZombie,seed);
		}
		else {
			this.gp = new DebugPrinter(this,DIMX,DIMY,managerSuns,managerZombie,seed, level.toString());
		}
	}
	
	public void exit(){
		end = true;
	}
	
	public boolean isFinished(){
		return end;
	}
	
	public void update() {

		plantList.update();
		zombieList.update();
		
		this.computerAction();
			
		this.contCycles++;
		
		if(this.winGame() || this.loseGame()) this.exit();
	}
	
	public int getContCycles() {
		return contCycles;
	}

	public void setContCycles(int contCycles) {
		this.contCycles = contCycles;
	}

	public Level getLevel() {
		return level;
	}
	
	public String getMode() {
		return mode;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	public String toString() {
		String cadena = "";
		if(mode.equals("RELEASE")) {
			if(this.contCycles == 0) {
				cadena = "Random seed used is: " + this.seed + "\n";
			}
			
			cadena += "Number of cycles: " + this.contCycles + "\n" +
					"Suns coins: " + managerSuns.getSunCoins() + "\n" + 
					"Remaining Zombies: " + managerZombie.getNumZombies() + "\n" +
			gp.printGame() + "\n";
			
		}
		else {
			cadena += "Number of cycles: " + this.contCycles + "\n" +
					"Suns coins: " + managerSuns.getSunCoins() + "\n" + 
					"Remaining Zombies: " + managerZombie.getNumZombies() + "\n" + 
					"Level: " + this.level + "\n" +
					"Seed: " + this.seed + "\n" + "\n" +
					gp.printGame() + "\n";
					
		}
		return cadena;
	}
	
	public boolean isEmpty(int x, int y) {
		boolean empty = false;
		if(plantList.getPersonaje(x, y) == null && zombieList.getPersonaje(x, y) == null) empty = true;
		return empty;
	}
	
	public boolean isZombie(int x, int y) {//Comprobamos si en la posicion x, y se encuentra un zombie
		return zombieList.getPersonaje(x, y) != null;
	}
	
	public boolean isPlant(int x, int y) {//Comprobamos si en la posicion x, y se encuentra un peashooter
		return plantList.getPersonaje(x, y) != null;
	}
	
	private void initPlantList() {
		this.plantList = new GameObjectList();
	}
	
	private void initZombieList() {
		this.zombieList = new GameObjectList();
	}
	
	private void initSuncoinManager() {
		this.managerSuns = new SuncoinManager();
	}
	
	private void initZombieManager() {
		this.managerZombie = new ZombieManager(level, this.aleatorio);
	}
	
	public void restarVidaPlant(int x, int y, int dmg){
		plantList.restarVidaPersonajes(x, y, dmg);
	}
	
	public void restarVidaZombie(int x, int y, int dmg){
		zombieList.restarVidaPersonajes(x, y, dmg);
	}
	
	public void sumarSoles(int suns){
		managerSuns.sumarSoles(suns);
	}
	
	public String drawPersonaje(int x, int y) {
		GameObject personaje = plantList.getPersonaje(x, y);
		String salida = "";
		if(personaje == null)
			personaje = zombieList.getPersonaje(x, y);
		
		if(personaje != null) salida = personaje.toString();
			
		return salida;
	}
	
	public String drawPlant(int x, int y) {
		GameObject personaje = plantList.getPersonaje(x, y);
		String salida = "";
		
		if(personaje != null) salida = personaje.toStringDebug();
			
		return salida;
	}

	public String drawZom(int x, int y) {
		GameObject personaje = zombieList.getPersonaje(x, y);
		String salida = "";
		
		if(personaje != null) salida = personaje.toStringDebug();
			
		return salida;
	}
	
	public boolean loseGame() {
		boolean fin = false;
		for(int i = 0; i < 4 && !fin ;i++) {
			if(isZombie(i,0)) {
				fin = true;
			}
		}
		return fin;
	}
	
	public boolean winGame() { 
		boolean fin = false;
		if(managerZombie.getNumZombies()== 0) {
			int numzombies = 0;
			for (int i = 0; i < DIMX; i++) {
				for(int j = 0; j < DIMY; j++) {
					if(isZombie(i, j)) {
						numzombies++;
					}
				}
			}
			fin = (numzombies == 0) ? true : false;
		}
		return fin;
	}
	
	public void resetGame() {
		initZombieList();
		initPlantList();
		initSuncoinManager();
		initZombieManager();
		this.contCycles = 0;
		System.out.println(toString());
	}
	
	
	public boolean comprobarSuns(int x, int y, Plant planta) {
		return planta.getCost() <= this.managerSuns.getSunCoins();
	}
	
	
	public void addPlantToGame(Plant planta, int x, int y){ 
		planta.setX(x);
		planta.setY(y);
		planta.setGame(this);
		plantList.add(planta);
		managerSuns.restarSoles(planta.getCost());
	}
	
	public void computerAction() {
		if(managerZombie.isZombieAdded()) {
			boolean added = false;
			do{
				int valorEntero = aleatorio.nextInt(DIMX);
				if(isEmpty(valorEntero, DIMY - 1)){
					Zombie z = ZombieFactory.getZombie(); //para que lo meta en la ultima fila
					z.setX(valorEntero);
					z.setY(DIMY - 1);
					z.setGame(this);
					this.zombieList.add(z);
					added = true;
				}
			}while(!added);
		}
	}
	
	public void setPrintMode(String mode){
		if (mode.equalsIgnoreCase("release")){
			this.gp = new ReleasePrinter(this, DIMX, DIMY,managerSuns,managerZombie,seed);
			this.mode = "RELEASE";
		}
		else{
			this.gp = new DebugPrinter(this,DIMX,DIMY,managerSuns,managerZombie,seed, level.toString());
			this.mode = "DEBUG";
		}
	}
}
