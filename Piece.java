import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Piece {
//	Position dans le labyrinthe
	private int x;
	private int y;	
//	Dimensions de la pièce 
	private int longueur;
	private int largeur;
//	Cases
	private Case[][] cases;
//	Portes Nord, Sud, Est, Ouest (true si la porte est ouverte, false sinon)
	private boolean ouvertN;
	private boolean ouvertS;
	private boolean ouvertE;
	private boolean ouvertO;
//	Liste des monstres se trouvant dans la pièce
	private List<Monstre> monstres;
	
	public Piece(int x, int y, int longueur, int largeur, Case[][] cases, boolean ouvertN, boolean ouvertS,
			boolean ouvertE, boolean ouvertO) {
		this.x = x;
		this.y = y;
		this.longueur = longueur;
		this.largeur = largeur;
		this.cases = cases;
		this.ouvertN = ouvertN;
		this.ouvertS = ouvertS;
		this.ouvertE = ouvertE;
		this.ouvertO = ouvertO;
		monstres = new ArrayList<Monstre>();

	}
	
//	Les portes sont toutes fermées par défaut
	public Piece(int x, int y, int longueur, int largeur, Case[][] cases) {
		this(x, y, longueur, largeur, cases, false, false, false, false);
	}
	

	//	Ici les cases sont générée aléatoirement et les portes sont toutes fermées
	public Piece(int x, int y, int longueur, int largeur) {
		this(x, y, longueur, largeur, null);
//		Création des cases
		cases = new Case[largeur][longueur];
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < longueur; j++) {
				cases[i][j] = new Case(i, j);
			}
		}
		
//		Création des Entités (Individus et objets) :
		
//		Dans une pièce il y a une clef qui permet d'ouvrir les portes
		Clef clef = new Clef(this);
		
//		Dans une pièce il y a au plus un Medecin
		if(boolAleatoire()) {
			Medecin medecin = new Medecin(this);
		}
		
//		Dans une pièce il y a au plus un Cuisinier
		if(boolAleatoire()) {
			Cuisinier cuisinier = new Cuisinier(this);
		}
		
//		Dans une pièce il y a au plus un Medicament
		if(boolAleatoire()) {
			Medicament medicament = new Medicament(this);
		}
		
//		Dans une pièce il y a au plus une Nourriture
		if(boolAleatoire()) {
			Nourriture nourriture = new Nourriture(this);
		}
		
//		Dans une pièce il y a au plus "largeur" Monstres
		for(int i = 0; i < largeur; i++) {
			if(boolAleatoire()) {
				Monstre monstre = new Monstre(this);
				this.monstres.add(monstre);
			}
		}
	}
	
//	Boolean généré aléatoirement
	private boolean boolAleatoire() {
		return ((int)(Math.random()*2) == 1);
	}
	
	public List<Monstre> getMonstres() {
		return monstres;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Piece [x=" + x + ", y=" + y + ", cases=" + Arrays.toString(cases) + ", ouvertN=" + ouvertN
				+ ", ouvertS=" + ouvertS + ", ouvertE=" + ouvertE + ", ouvertO=" + ouvertO + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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

	public Case[][] getCases() {
		return cases;
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}

	public boolean isOuvertN() {
		return ouvertN;
	}

	public void setOuvertN(boolean ouvertN) {
		this.ouvertN = ouvertN;
	}

	public boolean isOuvertS() {
		return ouvertS;
	}

	public void setOuvertS(boolean ouvertS) {
		this.ouvertS = ouvertS;
	}

	public boolean isOuvertE() {
		return ouvertE;
	}

	public void setOuvertE(boolean ouvertE) {
		this.ouvertE = ouvertE;
	}

	public boolean isOuvertO() {
		return ouvertO;
	}

	public void setOuvertO(boolean ouvertO) {
		this.ouvertO = ouvertO;
	}
	
	public Piece getPieceNord(Labyrinthe l) {
		if(!this.ouvertN)
			return this;
		Piece p = l.getPiece(this.x, this.y-1);
		if(p == null) {
			return this;
		}
		else {
			return p;
		}
	}
	
	public Piece getPieceSud(Labyrinthe l) {
		if(!this.ouvertS)
			return this;
		Piece p = l.getPiece(this.x, this.y+1);
		if(p == null) {
			return this;
		}
		else {
			return p;
		}
	}
	
	public Piece getPieceEst(Labyrinthe l) {
		if(!this.ouvertE)
			return this;
		Piece p = l.getPiece(this.x+1, this.y);
		if(p == null) {
			return this;
		}
		else {
			return p;
		}
	}
	
	public Piece getPieceOuest(Labyrinthe l) {
		if(!this.ouvertO)
			return this;
		Piece p = l.getPiece(this.x-1, this.y);
		if(p == null) {
			return this;
		}
		else {
			return p;
		}
	}
	
	public Case getCase(int i, int j) {
		if(i<0 || i>=this.largeur || j<0 || j>=this.longueur) {
			return null;
		}
		else {
			return cases[i][j];
		}
	}
}
