package jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Doritos extends JFrame implements ActionListener
{
	private JPanel panel;
	
	private int x;
	private int y;
	
	private Timer timer;
	
	private FrameCompteur compteur;
	
	public Doritos(FrameCompteur compteur, int x, int y)
	{
		this.compteur = compteur;
		this.x = x;
		this.y = y;
		
		this.compteur.newDoritos(this);
		
		this.setLocation(x,y);
		this.setSize(25,25);
		
		this.panel = new PanelStarry("./images/Doritos.gif");
		this.add(this.panel);
		//this.setBackground(Color.YELLOW);
		
		this.setUndecorated(true);
		this.setBackground(new Color(0, 0, 0, 0));
		
		this.setAlwaysOnTop(true);
		
		this.setVisible(true);
		
		this.timer = new Timer(5000, this);
		
		this.timer.start();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		this.compteur.delDoritos(this);
		this.timer.stop();
		this.dispose();
	}
	
	public Timer getTimer()
	{
		return this.timer;
	}
}
