package exercice1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MonPanneau extends JPanel { // Définition d’une classe étendant JPanel

    private static final long serialVersionUID = 1L;
    
    // Données membres pour stocker les textes à afficher
    private String texte1 = "";
    private String texte2 = "";

    // Constructeur
    public MonPanneau() {
        // Les initialisations...
        setBackground(Color.LIGHT_GRAY); // Modif couleur de fond
    }

    // Méthode pour mettre à jour les données à afficher depuis la JFrame
    public void setTexte(String t1, String t2) {
        this.texte1 = t1;
        this.texte2 = t2;
        repaint();
    }

    // Surcharge de la méthode de peinture et ajout du code de dessin...
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Font f = new Font("TimesRoman", Font.BOLD, 16); // Modif de la fonte
        g.setFont(f);
        g.setColor(Color.BLACK);
        
        // Affichage du texte des résultats dans le panneau
        g.drawString(texte1, 10, 70);
        g.drawString(texte2, 10, 100);
    }
}