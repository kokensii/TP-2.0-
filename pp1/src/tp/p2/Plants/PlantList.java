package tp.p2.Plants;

public class PlantList {

	static final int MAX = 32;
	
	private Plant plantList[];
	private int cont;
	
	public PlantList() {
		plantList = new Peashooter[MAX];
		cont = 0;
	}
	
	public void add(Plant p) {
		if(cont < MAX){
			plantList[cont] = p;
			cont++;
		}
	}
	
	public void delete(int index) {
		for(int i = index; i < this.cont; ++i) this.plantList[i] = this.plantList[i + 1];
		this.cont--;
	}
	
	public int getSize() {
		return this.cont;
	}
	
	public boolean isEmpty() {
		return cont == 0;
	}
	
	public boolean isPlant(int x, int y) {
		boolean isP = false;
		int i = 0;
		while(i < cont && !isP){
			if(plantList[i].getX() == x && plantList[i].getY() == y) isP = true;
			i++;
		}
		return isP;
	}
	
	public void restarLife(int index, int dmg){
		plantList[index].restarLife(dmg);
	}
	
	public Plant getPlant(int index){
		return plantList[index];
	}
	
	public int indexPeashooter(int x, int y){
		int isP = -1;
		for(int i = 0; i < this.cont && isP == -1; ++i){
			if(plantList[i].getX() == x && plantList[i].getY() == y) isP = i;
		}
		return isP;
	}
	
	public void restarVidaPlant(int x, int y, int dmg){
		int iP = indexPeashooter(x, y);
		if(iP != -1) {
			this.restarLife(iP, dmg);
			if(plantList[iP].getHp()== 0) {
				delete(iP);
			}
		}
	}
	
	public void update(){
		for(int i = 0; i < this.cont; ++i){
			plantList[i].update();
		}
	}
}
