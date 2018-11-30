package tp.p2.Zombie;

public class Deportista extends Zombie{
	
	static final int SPEED = 1;
	static final int STRENGHT = 2;
	static final String DEF = "Zombie deportista";
	static final char CHAR = 'X';
	
	public Deportista(){
		super(0, 0, STRENGHT, SPEED,CHAR,DEF);
	}
}
