package tp.p2.Zombie;

public class ZombieList {
	
	static final int MAX = 32;
	
	private Zombie[] zombieList;
	private int cont;
	
	public ZombieList() {
		zombieList = new Zombie[MAX];
		cont = 0;
	}
	
	public void add(Zombie z) {
		if(cont < MAX){
			zombieList[cont] = z;
			this.cont++;
		}
	}
	
	public void delete(int index) {
		for(int i = index; i < this.cont; ++i) this.zombieList[i] = this.zombieList[i + 1];
		this.cont--;
	}
	
	public int getSize() {
		return this.cont;
	}
	
	public Zombie getZombie(int index){
		return zombieList[index];
	}
	
	public boolean isEmpty() {
		return cont == 0;
	}
	
	public boolean isZombie(int x, int y) {
		boolean isZ = false;
		int i = 0;
		while(i < cont && !isZ){
			if(zombieList[i].getX() == x && zombieList[i].getY() == y) isZ = true;
			i++;
		}
		return isZ;
	}
	
	public int indexZombie(int x, int y){
		int isZ = -1;
		for(int i = 0; i < this.cont && isZ == -1; ++i){
			if(zombieList[i].getX() == x && zombieList[i].getY() == y) isZ = i;
		}
		return isZ;
	}
	
	public void restarVidaZombie(int x, int y, int dmg) {
		int iZ = indexZombie(x, y);
		if(iZ != -1) {
			this.zombieList[iZ].restarLife(dmg);
			if(zombieList[iZ].getHp()== 0) {
				delete(iZ);
			}
		}
	}
	
	public void update(){
		for(int i = 0; i < this.cont; ++i){
			zombieList[i].update();
		}
	}

}
