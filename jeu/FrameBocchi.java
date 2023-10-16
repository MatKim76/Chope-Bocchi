package jeu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FrameBocchi extends JFrame implements ActionListener, MouseListener
{
    private PanelBocchi panel;
    private int posX;
    private int posY;
    private int clickCount;

    public FrameBocchi()
    {
        this.panel = new PanelBocchi();
        this.clickCount = 0;

        this.add(this.panel);

        this.setSize(50, 50);
        this.setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));

        // Ajout du MouseListener à la frame
        this.addMouseListener(this);

        this.setVisible(true);

        // Obtenir la taille de l'écran
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        // Coordonnées initiales sur un côté de l'écran
        posX = screenWidth;
        posY = screenHeight / 2 - getHeight() / 2;

        Timer timer = new Timer(10, this);
        timer.start();
    }

    public static void main(String[] args) 
    {
        new FrameBocchi();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        // Déplacez la frame vers le centre
        if (posX > screenWidth / 2 - getWidth() / 2) {
            posX--;
        }

        this.setLocation(posX, posY);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (clickCount < 5) {
            clickCount++;
        } else {
            dispose();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
