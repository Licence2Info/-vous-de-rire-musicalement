import java.util.ArrayList;
import java.util.List;

public class Monstre extends Individu {
	private int forceMonstre;
	
	public Monstre(Piece piece, int forceMonstre) {
		super(piece);
		this.forceMonstre = forceMonstre;
	}
	
	public Monstre(Piece piece) {
		this(piece, (int)(Math.random()*5+1)); // Ici forceMonstre est un nombre choisi aléatoirement entre 1 et 5
	}

	public void bouger() {
		List<Case> casesPossibles = new ArrayList<Case>();
		Case caseN = this.getMaCase().getCaseNord(this.getPiece());
		if(caseN != this.getMaCase() && caseN.getEntite() == null) {
			casesPossibles.add(caseN);
		}
		Case caseS = this.getMaCase().getCaseSud(this.getPiece());
		if(caseS != this.getMaCase() && caseS.getEntite() == null) {
			casesPossibles.add(caseS);
		}
		Case caseE = this.getMaCase().getCaseEst(this.getPiece());
		if(caseE != this.getMaCase() && caseE.getEntite() == null) {
			casesPossibles.add(caseE);
		}
		Case caseO = this.getMaCase().getCaseOuest(this.getPiece());
		if(caseO != this.getMaCase() && caseO.getEntite() == null) {
			casesPossibles.add(caseO);
		}
		if(casesPossibles.size() > 0) {
			int i = (int)(Math.random() * casesPossibles.size());
			this.getMaCase().setEntite(null);
			this.setMaCase(casesPossibles.get(i));
		}
	}

	@Override
	public void executeOp(Joueur j) {
		if(this.getNbOpmax()>0) {
			j.decrPtForce(forceMonstre);
			this.decrNbOpMax();
//			Après avoir donné des coups au Joueur, le monstre diparaît:
//			this.getMaCase().resetObjet();
		}
	}

}
