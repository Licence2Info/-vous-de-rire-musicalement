import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public abstract class Entite extends JLabel{
//	Image
    private BufferedImage img;
	
	protected Case maCase;
	protected Piece piece;
	
//  Constructeur qui positionne l'Entite dans une case choisie aléatoirement d'une pièce donnée
	public Entite(Piece piece) {
		this.piece = piece;
		Case caseAleatoire;
		do {
			int i = (int) (Math.random()*piece.getLargeur());
			int j = (int) (Math.random()*piece.getLongueur());
			caseAleatoire = piece.getCase(i, j);				
		} while(caseAleatoire.getEntite() != null);
		this.setMaCase(caseAleatoire);
	}
	
//	Constructeur qui choisit une pièce du labyrinthe aléatoirement, et pose l'entité dans une case choisie aléatoirement de cette pièce
	public Entite(Labyrinthe l) {
		Case caseAleatoire;
		do {
			int i = (int) (Math.random()*l.getLargeur());
			int j = (int) (Math.random()*l.getLongueur());
			Piece piece = l.getPiece(i, j);
			int m = (int) (Math.random()*piece.getLargeur());
			int n = (int) (Math.random()*piece.getLongueur());
			caseAleatoire = piece.getCase(i, j);				
		} while(caseAleatoire.getEntite() != null);
		this.setMaCase(caseAleatoire);
	}

	public Case getMaCase() {
		return maCase;
	}

	public void setMaCase(Case maCase) {
		maCase.setEntite(this);
		this.maCase = maCase;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public abstract void executeOp(Joueur j);

	@Override
	public String toString() {
		return " [maCase=" + maCase + ", piece=" + piece + "]";
	}

	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//		Image
		try {
			URL imgUrl = getClass().getResource("/Images/"+getClass().getName()+".png");
            img = ImageIO.read(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        if (img != null) {
        	int x = this.maCase.getX();
        	int y = this.maCase.getY();
            g.drawImage(img, 61*x+9, 61*y+9, this);
        }
    }
	
}
