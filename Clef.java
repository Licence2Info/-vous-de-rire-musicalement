
public class Clef extends Objet {
	
	public Clef(Piece piece) {
		super(piece);
	}
	
	@Override
	public void executeOp(Joueur j) {
		super.addToPlayerObjects(j);
		this.piece.setOuvertN(true);
		this.piece.setOuvertS(true);
		this.piece.setOuvertE(true);
		this.piece.setOuvertO(true);
	}

}
