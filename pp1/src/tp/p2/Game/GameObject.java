package tp.p2.Game;

public abstract class GameObject {
	
	protected int x, y, hp, damage;
	protected Game game;
	protected int cost;
	protected char letra;
	protected String definicion;
	
	public GameObject(int x, int y, int hp, int dmg,char letra,String definicion){
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.damage = dmg;
		this.letra = letra;
		this.definicion = definicion;
	}

	// sera sobreescrito en las clases hijas de plant 
	public abstract void update();
	
	// será implementada en las clases que heredan
	public abstract int numcycles();
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getDamage(){
		return this.damage;
	}
	
	public void setDamage(int dmg){
		this.damage = dmg;
	}
	
	public void setGame(Game game){
		this.game = game;
	}
		
	public String toString() {
		String personaje;
		personaje= letra + "[" + this.getHp() + "]";
		return personaje;
	}
	
	public String toStringDebug() {
		String personaje;
		personaje=  letra + "[L:" + this.getHp() + ",X:" + this.x + ",Y:" + this.y + ",T:" + numcycles() + "]";
		return personaje;
	}
	
	public void setCordenadas(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void restarLife(int damage) {
		this.hp -= damage;
	}
	
	public char letra() {
		return letra;
	}
	
	public String infoPersonaje() {
		return definicion;
	}
	
}
