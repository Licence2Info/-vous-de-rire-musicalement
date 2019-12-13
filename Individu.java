
public abstract class Individu extends Entite {
	
	private int nbOpmax; // Nombre maximal d'opérations que cet individu peut effectuer pour le joueur
	
	public Individu(Piece piece) {
		super(piece);
		this.nbOpmax = 3; // par défaut ce nombre est de 3
	}
	
	public Individu(Piece piece, int nbOpmax) {
		super(piece);
		this.nbOpmax = nbOpmax;
	}

	public int getNbOpmax() {
		return nbOpmax;
	}

	protected void decrNbOpMax() {
		this.nbOpmax--;
	}
	
}
