package jeu;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FrameStarry extends JFrame implements ActionListener, MouseListener
{
    private PanelStarry panel;
    private int posX;
    private int posY;
    private int clickCount;
    
    private int screenWidth;
    private int screenHeight;
    
    private int dirX;
    private int dirY;
    
    Timer timer;
    
    private FrameCompteur compteur;
    private String nom;
	
	private int taille;
    private int vitesseMax;
    private int vitesseMin;

    private int point;
    private int survie;

    public FrameStarry(FrameCompteur compteur, String nom, int taille, int vitesseMin, int vitesseMax, int point, int survie)
	{
		this.compteur = compteur;
		this.nom = nom;
        this.taille = taille;
        this.vitesseMax = vitesseMax;
        this.vitesseMin = vitesseMin;//voir si utile
        this.point = point;
        this.survie = survie;

        this.clickCount = 0;

        this.panel = new PanelStarry("./images/" + this.nom + ".gif");
        this.add(this.panel);

        this.setSize(this.taille, this.taille);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setAlwaysOnTop(true);

        this.addMouseListener(this);

        this.setVisible(true);

        // Obtenir la taille de l'écran
        this.screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        // Init direction
        this.dirX = (int)(Math.random() * this.vitesseMax) - this.vitesseMax/2;
        this.dirY = (int)(Math.random() * this.vitesseMax) - this.vitesseMax/2;

        // Coordonnées initiales sur un côté de l'écran
        this.posX = (int)(Math.random() * this.screenWidth) ;
        this.posY = (int)(Math.random() * this.screenHeight) ;
        
        this.setLocation(posX, posY);

		timer = new Timer(10, this);
		
		timer.start();
		//timer.stop();
		
		//System.out.println(screenWidth + "   " + screenHeight );
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if( this.posX > screenWidth )
			this.dirX = -(int)(Math.random() * this.vitesseMax/2);
		
		if( this.posY > screenHeight - 50 )
			this.dirY = -(int)(Math.random() * this.vitesseMax/2);
		
		if( this.posX < 0 - 50 )
			this.dirX = (int)(Math.random() * this.vitesseMax/2);
		
		if( this.posY < 0 )
			this.dirY = (int)(Math.random() * this.vitesseMax/2);
		
		this.posX += this.dirX;
		this.posY += this.dirY;
		
        this.setLocation(posX, posY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (this.clickCount < this.survie)
        {
            this.clickCount++;
        }
        else
        {
        	if( this.compteur != null )
        		this.compteur.ajouterScore(this.point);
        	
            dispose();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e)
    {
    	//timer.start();
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
    	//timer.stop();
    }
}
