package tp.p2.Plants;

public class Nuez extends Plant{
	
	static final int DAMAGE = 0;
	static final int COST = 50;
	static final int STRENGHT = 10;
	static final char CHAR = 'N';
	static final String DEF = "[N]uez: Cost 50 suncoins Harm: 0";
	
	public Nuez(){
		super(0, 0, STRENGHT, DAMAGE, COST,CHAR,DEF);
	}
	
	@Override
	public void update() {
	}

	@Override
	public int numcycles() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
