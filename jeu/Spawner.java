package jeu;

public class Spawner
{
	private FrameCompteur compteur;
	
	public Spawner()
	{
		
		this.compteur = new FrameCompteur();
		
		while(true)
		{
			int test = (int)(Math.random() * 10);

			switch( test )
			{
				case 0  : 
				case 1  : new FrameStarry(this.compteur, "BlobNijika", 50, 0, 20, 2, 1); break;

				case 3  : new FrameStarry(this.compteur, "BlobRyo", 50, 0, 20, 2, 1); break;

				default : new FrameStarry(this.compteur, "BlobBocchi", 50, 0, 10, 1, 1);
			}
		
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
