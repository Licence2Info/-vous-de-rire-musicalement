import java.util.Arrays;

public class Labyrinthe {
	private int longueur;
	private int largeur;
	private int longPiece; // Longueur des pièces du labyrinthe
	private int largPiece; // Largeur des pièces du labyrinthe
	private Piece[][] pieces;
	private Tresor tresor;
	private Joueur joueur;
	
//	Ici les pièces sont générées aléatoirement
	public Labyrinthe(int longueur, int largeur, int longPiece, int largPiece) {
		this(longueur, largeur, longPiece, largPiece, null);
		pieces = new Piece[largeur][longueur];
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				pieces[i][j] = new Piece(i, j, longPiece, largPiece);
			}
		}
//		Création du trésor (dans le labyrinthe se trouve un et un seul trésor)
		this.tresor = new Tresor(this);
//		Création du Joueur (on le positionne dans la case[0][0] de la piece[0][0]
		this.joueur = new Joueur(this.getPiece(0, 0).getCase(0, 0), this.getPiece(0, 0));
	}

	public Labyrinthe(int longueur, int largeur, int longPiece, int largPiece, Piece[][] pieces) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.longPiece = longPiece;
		this.largPiece = largPiece;
		this.pieces = pieces;
	}

	@Override
	public String toString() {
		return "Labyrinthe [longueur=" + longueur + ", largeur=" + largeur + ", pieces=" + Arrays.toString(pieces)
				+ "]";
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getLongPiece() {
		return longPiece;
	}

	public int getLargPiece() {
		return largPiece;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public Piece[][] getPieces() {
		return pieces;
	}

	public void setPieces(Piece[][] pieces) {
		this.pieces = pieces;
	}

	public Piece getPiece(int i, int j) {
		if(i<0 || i>=this.largeur || j<0 || j>=this.longueur) {
			return null;
		}
		else {
			return pieces[i][j];
		}
	}
	
	
	

}
