
public abstract class Objet extends Entite {
	
	private boolean estConsomme;

	public Objet(Piece piece) {
		super(piece);
		this.estConsomme = false;
	}

	public boolean estConsomme() {
		return estConsomme;
	}

	protected void addToPlayerObjects(Joueur j) {
		this.estConsomme = true;
		j.addToObjects(this);
	}
	
}
