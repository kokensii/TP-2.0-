package tp.p2.Zombie;

import java.util.Calendar;
import java.util.Random;

public class ZombieFactory {

	private static Random aleatorio = new Random(Calendar.getInstance().getTimeInMillis()); // Para que tenga una semilla distinta
	private static String[] names = {"z", "x", "w"};

	private static Zombie[] availableZombies = { new Caracubo(),
			new Deportista(), new ZombieComun(), };

	public static Zombie getZombie() {
		int numZombieType = aleatorio.nextInt(availableZombies.length);
		return getZombie(names[numZombieType]);
	}

	public static Zombie getZombie(String ZombieName) {
		Zombie z = null;

		switch (ZombieName.toLowerCase()) {
		case "zombie comun":
		case "z":
			z = new ZombieComun();
			break;
		case "zombie deportista":
		case "x":
			z = new Deportista();
			break;
		case "zombie caracubo":
		case "w":
			z = new Caracubo();
		}

		return z;
	}

	public static String listOfAvilableZombies() {
		String salida = " The available zombies are: \n";
		for (Zombie z : availableZombies)
			salida += z.infoPersonaje() + "\n";
		return salida;
	}
}
