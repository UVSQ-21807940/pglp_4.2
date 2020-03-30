package uvsq21807940;

public enum CaculatriceRPN{
	ENVIRONNEMENT;
	
	public void run( String[] args) throws Exception {
		SaisieRPN saisie = new SaisieRPN();
		saisie.calcul();
	}
	
	public static void main( String[] args ) throws Exception {
		ENVIRONNEMENT.run(args);
		
	}
}