//import java.awt.EventQueue;
//import Images.hiclipart.com.png;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Application {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Application window = new Application();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Application(Labyrinthe l) {
		frame = new JFrame();
		initialize(l);
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Labyrinthe l) {
//		frame.setLocation(200, 20);
		Joueur joueur = l.getJoueur();
		frame.setBounds(100, 100, 900, 600);
//		frame.setBounds(100, 100, l.getLargPiece()*61, l.getLongPiece()*65);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Dessiner le joueur
		frame.getContentPane().add(joueur);
        frame.setVisible(true);
//      Dessiner les cases de la pièce où se trouve le joueur
        Piece pieceCourante = joueur.getPiece();
		for (int i = 0; i < pieceCourante.getLargeur(); i++) {
			for (int j = 0; j < pieceCourante.getLongueur(); j++) {
				Case caseCourante = pieceCourante.getCase(i,j);
				if(caseCourante.getEntite() != null && caseCourante.getEntite().estActif() && joueur.getMaCase() != caseCourante) {
					frame.getContentPane().add(caseCourante.getEntite());
	            	frame.setVisible(true);
				}
				frame.getContentPane().add(caseCourante);
	            frame.setVisible(true);
			}
		}
	
		frame.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				
			}
			
			public void keyTyped(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
			    switch( keyCode ) { 
			        case KeyEvent.VK_UP:
			            // handle up 
			        	for (Monstre monstre : pieceCourante.getMonstres()) {
							monstre.bouger();
						}
					    joueur.deplacerCaseN(l);
					    break;
			        case KeyEvent.VK_DOWN:
			            // handle down 
			        	for (Monstre monstre : pieceCourante.getMonstres()) {
							monstre.bouger();
						}
					    joueur.deplacerCaseS(l);
					    break;
			        case KeyEvent.VK_LEFT:
			            // handle left
			        	for (Monstre monstre : pieceCourante.getMonstres()) {
							monstre.bouger();
						}
					    joueur.deplacerCaseO(l);
					    break;
			        case KeyEvent.VK_RIGHT :
			            // handle right
			        	for (Monstre monstre : pieceCourante.getMonstres()) {
							monstre.bouger();
						}
					    joueur.deplacerCaseE(l);
					    break;
					default:
						return;
			     }
			    
			    frame.setVisible(false);
			    frame = new JFrame();
			    initialize(l);
			}
		});
		
	}
}
