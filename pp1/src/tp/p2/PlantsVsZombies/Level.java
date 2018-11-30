package tp.p2.PlantsVsZombies;

public enum Level{
	EASY, HARD, INSANE;
	
	public int getNumZombies(){
		int n;
		if(this == EASY) n = 3;
		else if(this == HARD) n = 5;
		else n = 10;
		return n;
	}
	
	public double getFrequency(){
		double f;
		if(this == EASY) f = 0.1;
		else if(this == HARD) f = 0.2;
		else f = 0.3;
		return f;
	}
}
