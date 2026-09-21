package exercice1;
import java.io.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.Graphics;
import java.awt.Image;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		/* methode 1
		System.out.println("Veuillez saisir les coefs a, b, c au clavier !");
		// Pour une saisie des paramètres au clavier
		BufferedReader clavier=new BufferedReader(new InputStreamReader(System.in));
		String chaine1=clavier.readLine();
		String chaine2=clavier.readLine();
		String chaine3=clavier.readLine();

		// Conversion de chaine vers double
		double a=Double.parseDouble(chaine1) ;
		double b=Double.parseDouble(chaine2) ;
		double c=Double.parseDouble(chaine3) ;
		// Déclaration d'une instance de la classe Eqdegre2, appel au constructeur
		
		*/
		
		//methode 2
		/*
		String chaine1=JOptionPane.showInputDialog("Coef. a");
		String chaine2=JOptionPane.showInputDialog("Coef. b");
		String chaine3=JOptionPane.showInputDialog("Coef. c");
		double a=Double.parseDouble(chaine1) ;
		double b=Double.parseDouble(chaine2) ;
		double c=Double.parseDouble(chaine3) ;
		*/

		
		//methode 3 avec un seul panneau
		Object[] message = new Object[6];
		message[0] = "valeur de a ?";
		message[1] = new JTextField("1.0");
		message[2] = "valeur de b ?";
		message[3] = new JTextField("2.0");
		message[4] = "valeur de c ?"; // Correction du libellé "c"
		message[5] = new JTextField("3.0");
		
		String[] options = {"OK", "Annuler"};
		
		// ajout de l'image 
		ImageIcon iconOriginale = new ImageIcon("meme.jpg"); 
		Image imageRedim = iconOriginale.getImage().getScaledInstance(80, 100, Image.SCALE_SMOOTH);
		ImageIcon iconeFinale = new ImageIcon(imageRedim);
		
		double a = 0, b = 0, c = 0;
		boolean saisieValide = false;

		// Boucle de contrôle de la saisie
		while (!saisieValide) {
			int option = JOptionPane.showOptionDialog(
					new JFrame(),
					message, // the dialog message array
					"Ma jolie boite de dialogue", // the title of the dialog window
					JOptionPane.DEFAULT_OPTION, // option type
					JOptionPane.INFORMATION_MESSAGE, // message type
					iconeFinale, // optional icon, use null to use the default icon
					options, // options string array, will be made into buttons
					options[0] // option that should be made into a default button
					);

			// Quitter si l'utilisateur ferme la boîte ou clique sur Annuler
			if (option != 0) {
				System.exit(0);
			}

			String chaine1 = ((JTextComponent) message[1]).getText();
			String chaine2 = ((JTextComponent) message[3]).getText();
			String chaine3 = ((JTextComponent) message[5]).getText();

			// Capture de l'erreur de saisie
			try {
				a = Double.parseDouble(chaine1);
				b = Double.parseDouble(chaine2);
				c = Double.parseDouble(chaine3);
				saisieValide = true; // Si aucune exception n'est levée, la saisie est correcte
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Saisie invalide ! Vous devez saisir uniquement des chiffres (pas de lettres).",
						"Erreur de saisie", 
						JOptionPane.ERROR_MESSAGE );
			}
		}

		Eqdegre2 eq = new Eqdegre2(a, b, c);
		
		// eq.résoudre(a,b,c);
		//Affichage du résultat
		
		System.out.println("Le resultat est : " + eq.toString());
		// Arrêt de l’application
		System.exit(0);    
	}
}