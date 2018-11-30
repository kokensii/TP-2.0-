package tp.p2.Zombie;

public class ZombieComun extends Zombie{

	static final int STRENGHT = 5;
	static final int SPEED = 2;
	static final char CHAR = 'Z';
	static final String DEF = "Zombie comun";
	
	
	
	public ZombieComun(){
		super(0, 0, STRENGHT, SPEED,CHAR,DEF);
	}
	
}
