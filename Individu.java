package modele;

public abstract class Individu {

    private Piece position;

    public Individu(Piece p) {
        position = p;
    }

    public void affiche() {
        position.affiche();
    }

    public void setPosition(Piece position) {
		this.position = position;
	}

	public void deplacer(char r) {
    	position = position.pieceVoisine(r);
    }

    public Piece getPosition() {
        return position;
    }
}
