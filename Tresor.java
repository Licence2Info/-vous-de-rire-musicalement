
public class Tresor extends Entite {

	public Tresor(Labyrinthe l) {
		super(l);
	}

	@Override
	public void executeOp(Joueur j) {
		System.out.println("Félicitations vous avez trouvé le trésor !");
		System.exit(1);		
	}

}
