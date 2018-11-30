package tp.p2.Plants;

public class Sunflower extends Plant{
	
	static final int STRENGHT = 1;
	static final int FREQUENCY = 2;
	static final int DAMAGE = 0;
	static final int COST = 20;
	static final int INCREMENT = 10;
	static final char CHAR = 'S';
	static final String DEF= "[S]unflower: Cost: 20 suncoins Harm: 0";
	
	private int instant;
	
	public Sunflower(){
		super(0, 0, STRENGHT, DAMAGE, COST,CHAR,DEF);
	}
	
	@Override
	public void update(){
		this.instant++;
		if(instant % FREQUENCY == 0) game.sumarSoles(INCREMENT);
	}

	@Override
	public int numcycles() {
		// TODO Auto-generated method stub
		return instant % FREQUENCY;
	}
	

}
