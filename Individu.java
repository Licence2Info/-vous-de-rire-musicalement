import java.awt.Font;
import java.awt.Graphics;

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
	
	public boolean estActif() {
		return nbOpmax > 0;
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font fonte = new Font("TimesRoman ",Font.BOLD,9);
		g.setFont(fonte);
		int x = this.maCase.getX();
    	int y = this.maCase.getY();
		g.drawString(Integer.toString(this.getNbOpmax()),61*x+9, 61*y+15);
    }
}
