
public class Cuisinier extends Individu {

	public Cuisinier(Piece piece) {
		super(piece);
	}

	public Cuisinier(Piece piece, int nbOpmax) {
		super(piece, nbOpmax);
	}

	@Override
	public void executeOp(Joueur j) {
		int defaultPtForce = j.getDefaultPtForce();
		if(this.getNbOpmax() > 0 && j.getPtForce() < defaultPtForce) {
			j.setPtForce(defaultPtForce);
			this.decrNbOpMax();
		}
	}

}
