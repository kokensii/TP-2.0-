package tp.p2.Game;

public class GameObjectList {
	
	static final int MAX = 32;
	
	private GameObject personajes[];
	private int cont;
	
	public GameObjectList() {
		personajes = new GameObject[MAX];
		cont = 0;
	}
	
	public void add(GameObject go) {
		if(cont < MAX){
			personajes[cont] = go;
			cont++;
		}
	}
	
	public void delete(int index) {
		for(int i = index; i < this.cont; ++i) this.personajes[i] = this.personajes[i + 1];
		this.cont--;
	}
	
	public int getSize() {
		return this.cont;
	}
	
	public boolean isEmpty() {
		return cont == 0;
	}
	
	private void restarLife(int index, int dmg){
		personajes[index].restarLife(dmg);
	}
	
	private int indexPersonaje(int x, int y){
		int isP = -1;
		for(int i = 0; i < this.cont && isP == -1; ++i){
			if(personajes[i].getX() == x && personajes[i].getY() == y) isP = i;
		}
		return isP;
	}
	
	public GameObject getPersonaje(int x , int y){
		GameObject salida = null;
		int index = indexPersonaje(x, y);
		if(index > -1) salida = this.personajes[index];
		return salida;
	}
	
	public void restarVidaPersonajes(int x, int y, int dmg){
		int iP = indexPersonaje(x, y);
		if(iP != -1) {
			this.restarLife(iP, dmg);
			if(personajes[iP].getHp()<= 0) {
				delete(iP);
			}
		}
	}
	
	public void update(){
		for(int i = 0; i < this.cont; ++i){
			personajes[i].update();
		}
	}

}
