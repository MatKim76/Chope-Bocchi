package jeu;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;

public class FrameCompteur extends JFrame
{
	private JLabel lblScore;
	private int score;
	
	private ArrayList<Doritos> lstDoritos;
	
	public FrameCompteur()
	{
		this.lblScore = new JLabel("SCORE : 0");
		this.lblScore.setFont(new Font("Serif", Font.BOLD, 20));
		
		this.add(this.lblScore);
		
		this.score = 0;
		lstDoritos = new ArrayList<Doritos>();
		
		this.setSize(200, 100);
		//this.setUndecorated(true);
		//this.setBackground(new Color(0, 0, 0, 0));
		this.setAlwaysOnTop(true);
		
		this.setVisible(true);
	}
	
	public void ajouterScore(int s)
	{
		this.score += s;
		this.lblScore.setText("SCORE : " + this.score + "");
	}
	
	public boolean aDoritos()
	{
		return !lstDoritos.isEmpty();
	}
	
	public Doritos getDoritos(int i)
	{
		return this.lstDoritos.get(i);
	}
	
	public void newDoritos(Doritos d)
	{
		this.lstDoritos.add(d);
	}
	
	public void delDoritos(Doritos d)
	{
		this.lstDoritos.remove(d);
	}
}
