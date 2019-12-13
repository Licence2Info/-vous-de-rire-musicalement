
public class Medicament extends Objet {

	private int ptVieRendus;

	public Medicament(Piece piece, int ptVieRendus) {
		super(piece);
		this.ptVieRendus = ptVieRendus;
	}
	
	public Medicament(Piece piece) {
		super(piece);
		int ptVR = (int) (Math.random()*5 + 1); // Valeur choisie aléatoirement entre 1 et 5
		this.ptVieRendus = ptVR;
	}

	public int getPtVieRendus() {
		return ptVieRendus;
	}
	
	@Override
	public void executeOp(Joueur j) {
		if(!this.estConsomme()) {
			super.addToPlayerObjects(j);
			j.incrPtVie(this.ptVieRendus);
		}
	}
	

}
