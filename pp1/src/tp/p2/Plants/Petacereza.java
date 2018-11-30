package tp.p2.Plants;


public class Petacereza extends Plant{
	
	static final int COST = 50;
	static final int DAMAGE = 10;
	static final int STRENGHT = 2;
	static final char CHAR = 'C';
	static final String DEF = "Peta[c]ereza: Cost: 50 suncoins Harm : 10";
	private int instant;
	
	public Petacereza(){
		super(0, 0, STRENGHT, DAMAGE, COST,CHAR,DEF);
	}

	@Override
	public void update() {
		if(instant == 2){
			int[] incX = {1, -1, 0};
			int[] incY = {1, -1, 0};
			for(int iX : incX){
				for(int iY : incY){
					int x = this.x + iX;
					int y = this.y + iY;
					if(game.isZombie(x, y)) {
						game.restarVidaZombie(x, y, DAMAGE);
					}
				}
			}
			game.restarVidaPlant(this.x, this.y, this.hp); //explota
		}
		this.instant++;
	}

	@Override
	public int numcycles() {
		// TODO Auto-generated method stub
		return instant % 2;
	}
	

}
