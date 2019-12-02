


public class Objet {
	
	Piece position;
	int numero;
	
	public Objet(Piece p)
	{
		position = p;
	}
	
	public void affiche()
	{
		position.affiche();
	}

	public Piece getPosition()
	{
		return position;
	}
	
	public void setPosition(Piece p)
	{
		position = p;
	}
	
	public void pris()
	{
		position = null;
	}
	
	public int getNumero(){
		return numero;
	}
}
