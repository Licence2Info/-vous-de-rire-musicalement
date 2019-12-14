import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		Labyrinthe l = new Labyrinthe(4,4,8,8); // Labyrinthe de 4x4 pièces, chaque pièce comprend 10x10 cases
//		System.out.println(l);
		for (int i = 0; i < l.getLargeur(); i++) {
			for (int j = 0; j < l.getLongueur(); j++) {
				Piece p = l.getPiece(i, j);
				System.out.println(p);
				for (int j2 = 0; j2 < p.getLargeur(); j2++) {
					for (int k = 0; k < p.getLongueur(); k++) {
						System.out.println(p.getCase(j2, k));
					}
				}
			}
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application(l);
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
