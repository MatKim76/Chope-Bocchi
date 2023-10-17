package jeu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PanelBocchi extends PanelStarry 
{
    public PanelBocchi()
    {
        super( "./images/BlobBocchi.gif" );
        //this.setBackground(new Color(0,0,0,0));
    }

    
    /*@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

        Image img = getToolkit().getImage ( "./images/BlobBocchi.gif" );
        g.drawImage( img, 0, 0, 50, 50, this);
    }*/
}
