package tp.p2.Printer;

import tp.p2.Game.Game;
import tp.p2.Manager.SuncoinManager;
import tp.p2.Manager.ZombieManager;
import tp.p2.util.MyStringUtils;

public class DebugPrinter extends BoardPrinter{
	
	static final int MAX = 32;
	final String space = " ";
	private int x,y;
	private String debugEncode[];
	private int contDebugEncode;

	public DebugPrinter(Game game,int x,int y, SuncoinManager managerSuns,ZombieManager managerZombie,long seed,String level) {
		super(game);
		this.x = x;
		this.y = y;
		this.debugEncode = new String[MAX]; // inicializo a MAX para cargarlo en el encode y para darle formato en el printGame
		this.contDebugEncode = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void encodeGame() {
		
			// Primero obtenemos las listas de plantas y zombies por separado
			// para despues unirlas en el array debugEncode que
			// utilizaré para escribir la salida del método PrintGame
			String auxPlan[] = new String[MAX];	
			int contPlan = 0;	
			for(int i = 0; i < this.x; i++) {
				for(int j = 0; j < this.y; j++) {
					String temp = game.drawPlant(i, j);
					if(temp.length() > 0) {
						auxPlan[contPlan] = temp; // Solo guardamos las plantas
						contPlan++;
					}
				}
			}
			
			
			String auxZom[] = new String[MAX];
			int contZom = 0;	
			for(int i = 0; i < this.x; i++) {
				for(int j = 0; j < this.y; j++) {
					String temp = game.drawZom(i, j);
					if(temp.length() > 0) {
						auxZom[contZom] = temp; // Solo guardamos los zombies
						contZom++;
					}
				}
			}
			
			
			// las unimos en el array de salida
			// Primero plantas, después zombies
			contDebugEncode = 0;
			for(int i = 0; i < (contPlan + contZom); i++) {
				if(i < contPlan) {
					debugEncode[i] = auxPlan[i];
					contDebugEncode++;
				} else {
					debugEncode[i] = auxZom[i - contPlan];
					contDebugEncode++;
				}
			}
		}
		

	@Override
	public String printGame() {
		encodeGame();
		String vDelimiter = "|";
		String hDelimiter = "-";
		
		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (19 * (contDebugEncode) - 1));
		
		StringBuilder str = new StringBuilder();
		str.append(rowDelimiter);
		str.append("\n");
		
			for(int i = 0; i < contDebugEncode; i++) {
				str.append("|" + debugEncode[i]);
			}
			
			if(contDebugEncode>0) {
				str.append(vDelimiter);
			}
			
			str.append("\n");
			str.append(rowDelimiter);
		return str.toString();
		// TODO Auto-generated method stub
	}

}
