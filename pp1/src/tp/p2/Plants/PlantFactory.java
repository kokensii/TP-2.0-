package tp.p2.Plants;

public class PlantFactory {

	private static Plant[] availablePlants = {
		new Peashooter(),
		new Sunflower(),
		new Petacereza(),
		new Nuez()
	};
	
	public static Plant getPlant(String plantName){
		Plant p = null;
		
		switch(plantName.toLowerCase()){
			case "peashooter":
			case "p":
				p = new Peashooter();
			break;
			case "sunflower":
			case "s":
				p = new Sunflower();
			break;
			case "petacereza":
			case "c":
				p = new Petacereza();
			break;
			case "nuez":
			case "n":
				p = new Nuez();
		}
		
		return p;
	}
	
	public static String listOfAvilablePlants() {
		String salida = " The available plants are: \n";
		for(Plant p : availablePlants) salida += p.infoPersonaje() +  "\n";
		return salida;
	}
}
