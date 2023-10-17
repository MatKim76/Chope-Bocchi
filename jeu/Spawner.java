package jeu;

public class Spawner
{
	private FrameCompteur compteur;
	
	public Spawner()
	{
		this.compteur = new FrameCompteur();
		
		while(true)
		{
			new FrameBocchi(this.compteur/*, new PanelBocchi()*/ ); //faire un truc qui prend un String ou une image ?
			try{
				Thread.sleep(5000);
			}catch(Exception e){}
		}
	}
	
	public static void main(String[] args)
	{
		new Spawner();
	}
}
