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
				case 0, 1  : new FrameStarry(this.compteur, "BlobKita", 50, 0, 7, 2, 3); break;
				case 2, 3  : new FrameStarry(this.compteur, "BlobRyo", 50, 0, 20, 2, 1); break;
				case 4, 5  : new FrameStarry(this.compteur, "BlobNijika", 50, 0, 15, 2, 1); break;
				
				case 6  : new FrameStarry(this.compteur, "BlobBocchi", 200, 0, 5, 1, 10, true); break;
				case 7  : new FrameStarry(this.compteur, "BlobHiroi", 50, 0, 5, 3, 1); break;
				case 8  : 

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
