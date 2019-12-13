import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Case extends JLabel {
//	Image
	private final static String IMG_CaseBleue_PATH = "/Images/caseBleue.png";
	private final static String IMG_CaseVerte_PATH = "/Images/caseVerte.png";
    private BufferedImage img;
//	Position dans la pièce
	private int x;
	private int y;
//	Entité (Individu ou Objet)
	private Entite entite;
	
//  Si le joueur est déjà passé par cette case
	boolean estParcourue;
	
//	Par défaut aucun objet et aucun individu n'est dans la case
	public Case(int x, int y) {
		this(x, y, null);
	}
	
	public Case(int x, int y, Entite entite) {
		this.x = x;
		this.y = y;
		this.entite = entite;
		this.estParcourue = false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Case other = (Case) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (entite == null)
			return "Case [x=" + x + ", y=" + y + ", objet= null]";
		else
			return "Case [x=" + x + ", y=" + y + ", objet=" + entite.getClass().getSimpleName() + "]";
	}
	
	public boolean estParcourue() {
		return estParcourue;
	}
	
	public void parcourir() {
		this.estParcourue = true ;
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

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite objet) {
		this.entite = objet;
	}

	public void resetObjet() {
		this.entite = null;
	}
	
	public Case getCaseNord(Piece p) {
		Case c = p.getCase(this.x, this.y-1);
		if(c == null) {
			return this;
		}
		else {
			return c;
		}
	}
	
	public Case getCaseSud(Piece p) {
		Case c = p.getCase(this.x, this.y+1);
		if(c == null) {
			return this;
		}
		else {
			return c;
		}
	}
	
	public Case getCaseEst(Piece p) {
		Case c = p.getCase(this.x+1, this.y);
		if(c == null) {
			return this;
		}
		else {
			return c;
		}
	}
	
	public Case getCaseOuest(Piece p) {
		Case c = p.getCase(this.x-1, this.y);
		if(c == null) {
			return this;
		}
		else {
			return c;
		}
	}
		
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//		Image
		try {
			URL imgUrl;
			if(!estParcourue)
				imgUrl = getClass().getResource(IMG_CaseBleue_PATH);
			else
				imgUrl = getClass().getResource(IMG_CaseVerte_PATH);
            img = ImageIO.read(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        if (img != null) {
            g.drawImage(img, 60*x, 60*y, this);
        }
    }
}
