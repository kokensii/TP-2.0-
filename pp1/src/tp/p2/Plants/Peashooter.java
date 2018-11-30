package tp.p2.Plants;

public class Peashooter extends Plant{
	
	static final int STRENGHT = 3;
	static final int FREQUENCY = 1;
	static final int DAMAGE = 1;
	static final int COST = 50;
	static final int DIMY = 8;
	static final char CHAR = 'P';
	static final String DEF = "[P]eashooter: Cost: 50 suncoins Harm: 1";
	
	public Peashooter(){
		super(0, 0, STRENGHT, DAMAGE, COST,CHAR,DEF);
	}
	
	@Override
	public void update() { 
		boolean disparo = false;
		int i = y + 1;
		while(i < DIMY && !disparo){
			if(game.isZombie(x, i)){
				game.restarVidaZombie(x, i, DAMAGE);
				disparo = true;
			}
			i++;
		}
	}

	@Override
	public int numcycles() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
