



// Attention cette Cette Classe n'est pas terminer elle possede des methodes Vide aussi.


public class Joueur extends Individu {

    public final int DEBUT = 10;
    public int force;
    public int vie;
    public static Objet[] a;
    int i = 0;

    public Joueur(Piece p) {
        super(p);
        force = DEBUT;
        vie = DEBUT;
        a = new Objet[4];
    }

    public void deplacer(char r) {
       super.deplacer(r);
    }

    public void affiche() {
        System.out.println();
        System.out.println("JOUEUR force : " + force + " et de point de vie : " + vie);
        int nbobj = 0;
        // objet du joueur
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                System.out.print("Objet en " + i + " : ");
                a[i].affiche();
                nbobj++;
            }
        }
        if (nbobj == 0) {
            System.out.println("pas d'objet sur le joueur");
        }
        // piece
        System.out.println("Dans la piece du joueur");
        super.affiche();
    }

   
    public Objet[] getObjets() {
        return a;
    }

    public void manger(Nourriture n) {
    	
    }

    public void soigner(Medicament m) {
    	
    }

    public boolean combat(Monstre m) {
    	
            {
                
                MessageService.message += "Joueur gagne";  
                c = true;
            } else // si tirage compris entre force et (force + force du monstre) le monstre gagne
            {
                MessageService.message += "Monstre gagne";
                this.vie--;
            }
            
        }
        return c;
    } 
//pour combatre le monstre
    public void comb(Monstre m){
       
    }
// 
    public void guerir() {
       
    }
// s'il c nourri
    public void nourrir() {
        
    }

    public int getForce() {
        return force;
    }

    public int getVie() {
        return vie;
    }
//pour ouvrire la porte
    public boolean peutOuvrir(Porte p){
    	
    	boolean open = false;
    	if (p.getFerme() == false) {
    		open = true;
    	}
    	else{
    		for(int i=0; i<a.length;i++){
    			if(a[i] instanceof Cle){
    				if(a[i].getNumero() == p.getNumero()){
    					open = true;
    					break;
    				}
    			}
    		}
    	}
    	return open;
    }
   
    
    public void setForce(int force) {
		this.force = force;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
// Attention cette Cette Classe n'est pas terminer elle possede des methodes Vide aussi.
	
