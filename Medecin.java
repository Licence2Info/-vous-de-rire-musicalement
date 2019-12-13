
public class Medecin extends Individu {

	public Medecin(Piece piece) {
		super(piece);
	}

	public Medecin(Piece piece, int nbOpmax) {
		super(piece, nbOpmax);
	}

	@Override
	public void executeOp(Joueur j) {
		int defaultPtVie = j.getDefaultPtVie();
		if(this.getNbOpmax() > 0 && j.getPtVie() < defaultPtVie) {
			j.setPtVie(defaultPtVie);
			super.decrNbOpMax();
		}
	}

}
