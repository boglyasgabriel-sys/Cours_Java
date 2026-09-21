package exercice1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class MaFenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblRacine1;
	private JLabel lblRacine2;
	//private MonPanneau contentPane2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaFenetre frame = new MaFenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MaFenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Lancer le programme");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNewMenuItem.setBackground(new Color(0, 255, 0));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1. Instanciation et affichage de la boîte modale
				MonJDialog dialog = new MonJDialog();
				dialog.setVisible(true); // Bloque l'exécution ici tant que la boîte est ouverte

				// 2. Si l'utilisateur a cliqué sur OK (saisie valide)
				if (dialog.isValide()) {
				    // Récupération des coefficients
				    double a = dialog.getA();
				    double b = dialog.getB();
				    double c = dialog.getC();

				    // Calcul de l'équation
				    Eqdegre2 eq = new Eqdegre2(a, b, c);

				    // Affichage du résultat dans les deux JLabel de MaFenetre
				    lblRacine1.setText("Résultat : " + eq.toString());
				    lblRacine2.setText("Coefficients : a = " + a + ", b = " + b + ", c = " + c);
				}
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("aide");
		mntmNewMenuItem_1.setBackground(new Color(255, 255, 0));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MaFenetre.this, 
					    "Application de résolution d'équation du 2nd degré.", 
					    "Aide", 
					    JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Quitter");
		mntmNewMenuItem_2.setBackground(new Color(255, 0, 0));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblRacine1 = new JLabel("Racine 1 ");
		lblRacine1.setBounds(20, 160, 390, 20); // Largeur passée à 390 px
		contentPane.add(lblRacine1);
		
		lblRacine2 = new JLabel("Racine 2");
		lblRacine2.setBounds(20, 190, 390, 20);
		contentPane.add(lblRacine2);
		
		// 1. Chargement de l'image d'origine
		ImageIcon originalIcon = new ImageIcon(MaFenetre.class.getResource("/exercice1/meme.jpg"));
				
		//  Redimensionnement 
		java.awt.Image img = originalIcon.getImage();
		java.awt.Image resizedImg = img.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
				
		// 3. Application de l'image redimensionnée sur le JLabel
		JLabel image_test = new JLabel("");
		image_test.setIcon(new ImageIcon(resizedImg));
		image_test.setBounds(38, 10, 125, 125);
		contentPane.add(image_test);

	}

}
