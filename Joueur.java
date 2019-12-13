import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Joueur extends JLabel {
//	Image
    private BufferedImage img;
	
	private Case maCase;
	private Piece piece;
	
	private int ptForce;
	private int ptVie;
	
	private final int defaultPtForce = 10;
	private final int defaultPtVie = 10;
	
	private List<Objet> objets;
	
	public Joueur(Case maCase, Piece piece) {
		this.setMaCase(maCase);
		this.piece = piece;
		this.ptForce = defaultPtForce; // Valeur par défaut
		this.ptVie = defaultPtVie; // Valeur par défaut
		objets = new ArrayList<Objet>();
	}

	public Case getMaCase() {
		return maCase;
	}

	public void setMaCase(Case maCase) {
		maCase.parcourir();
		this.maCase = maCase;
		if(this.maCase.getEntite() != null) {
			this.maCase.getEntite().executeOp(this);
		}
		System.out.println(this);
	}
	
	public void setMaCase(Piece p, int i, int j) {
		setMaCase(p.getCase(i, j));
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public int getDefaultPtForce() {
		return defaultPtForce;
	}

	public int getDefaultPtVie() {
		return defaultPtVie;
	}

	public int getPtForce() {
		return ptForce;
	}

	public void setPtForce(int ptForce) {
		this.ptForce = ptForce;
	}
	
	public void incrPtForce(int val) {
		this.ptForce += val;
	}
	
	public void decrPtForce(int val) {
		if (this.ptForce < val) {
			this.decrPtVie(val - this.ptForce);
			this.ptForce = 0;
		}
		else {
			this.ptForce -= val;
		}
	}

	public int getPtVie() {
		return ptVie;
	}

	public void setPtVie(int ptVie) {
		this.ptVie = ptVie;
	}
	
	public void incrPtVie(int val) {
		this.ptVie += val;
	}
	
	public void decrPtVie(int val) {
		if (this.ptVie < val) {
			this.ptVie= 0;
			System.out.println("Game Over");
			System.exit(1);
		}
		else {
			this.ptVie -= val;
		}
	}
	
	public void addToObjects(Objet o) {
		this.objets.add(o);
	}

	@Override
	public String toString() {
		return "Joueur [maCase=" + maCase + ", piece=" + piece + ", ptForce=" + ptForce + ", ptVie=" + ptVie + "]";
	}

	public void deplacerCaseN(Labyrinthe l) {
		if (this.maCase.getY() == 0) {
			deplacerPieceN(l);
		}
		else {
			this.setMaCase(maCase.getCaseNord(this.piece));			
		}
	}
	
	public void deplacerCaseS(Labyrinthe l) {
		if (this.maCase.getY() == this.piece.getLongueur()-1) {
			deplacerPieceS(l);
		}
		else {
			this.setMaCase(maCase.getCaseSud(this.piece));			
		}
	}
	
	public void deplacerCaseE(Labyrinthe l) {
		if (this.maCase.getX() == this.piece.getLargeur()-1) {
			deplacerPieceE(l);
		}
		else {
			this.setMaCase(maCase.getCaseEst(this.piece));
		}
	}
	
	public void deplacerCaseO(Labyrinthe l) {
		if (this.maCase.getX() == 0) {
			deplacerPieceO(l);
		}
		else {
			this.setMaCase(maCase.getCaseOuest(this.piece));			
		}
	}
	
	private void deplacerPieceN(Labyrinthe l) {
		Piece p = this.piece.getPieceNord(l);
		if(p != this.piece) {
			this.piece = p;
			this.setMaCase(p.getCase(this.maCase.getX(), p.getLongueur()-1));
		}
	}
	
	private void deplacerPieceS(Labyrinthe l) {
		Piece p = this.piece.getPieceSud(l);
		if(p != this.piece) {
			this.piece = p;
			this.setMaCase(p.getCase(this.maCase.getX(), 0));
		}
	}
	
	private void deplacerPieceE(Labyrinthe l) {
		Piece p = this.piece.getPieceEst(l);
		if(p != this.piece) {
			this.piece = p;
			this.setMaCase(p.getCase(0, this.maCase.getY()));
		}
	}
	
	private void deplacerPieceO(Labyrinthe l) {
		Piece p = this.piece.getPieceOuest(l);
		if(p != this.piece) {
			this.piece = p;
			this.setMaCase(p.getCase(p.getLargeur()-1, this.maCase.getY()));
		}
	}
	
	public void executeOp() {
		if (this.maCase.getEntite() != null) {
			this.maCase.getEntite().executeOp(this);
		}
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
//            g.drawImage(img, 60*x+2, 60*y+2, this);
            g.drawImage(img, 61*x+9, 61*y+9, this);

        }
    }
	
	
}


