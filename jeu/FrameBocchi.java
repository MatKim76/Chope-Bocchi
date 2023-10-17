package jeu;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FrameBocchi extends JFrame implements ActionListener, MouseListener
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
	
	
	
	public FrameBocchi(FrameCompteur compteur/*, PanelStarry panel*/)
	{
		this();
		this.compteur = compteur;
		//this.panel = panel;
	}

    public FrameBocchi()
    {
        this.panel = new PanelBocchi();
        this.clickCount = 0;

        this.add(this.panel);

        this.setSize(50, 50);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setAlwaysOnTop(true);

        this.addMouseListener(this);

        this.setVisible(true);

        // Obtenir la taille de l'écran
        this.screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
        this.screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        
        // Init direction
        this.dirX = (int)(Math.random() * 10) - 5;
        this.dirY = (int)(Math.random() * 10) - 5;

        // Coordonnées initiales sur un côté de l'écran
        this.posX = (int)(Math.random() * this.screenWidth) ;
        this.posY = (int)(Math.random() * this.screenHeight) ;
        
        this.setLocation(posX, posY);

		timer = new Timer(10, this);
		
		timer.start();
		//timer.stop();
		
		//System.out.println(screenWidth + "   " + screenHeight );
	}

	public static void main(String[] args) 
	{
		new FrameBocchi();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if( posX > screenWidth )
			this.dirX = (int)(Math.random() * 5) - 5;
		
		if( posY > screenHeight - 50 )
			this.dirY = (int)(Math.random() * 5) - 5;
		
		if( posX < 0 )
			this.dirX = (int)(Math.random() * 5);
		
		if( posY < 0 + 50 )
			this.dirY = (int)(Math.random() * 5);
		
		this.posX += this.dirX;
		this.posY += this.dirY;
		
        this.setLocation(posX, posY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (clickCount < 1)
        {
            clickCount++;
        }
        else
        {
        	if( this.compteur != null )
        		this.compteur.ajouterScore(1);
        	
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
