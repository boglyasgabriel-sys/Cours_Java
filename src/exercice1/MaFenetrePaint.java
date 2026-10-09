package exercice1;

import java.awt.EventQueue;
import javax.swing.JFrame;
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
import java.awt.BorderLayout;

public class MaFenetrePaint extends JFrame {

	private static final long serialVersionUID = 1L;
	private MonPanneau contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaFenetrePaint frame = new MaFenetrePaint();
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
	public MaFenetrePaint() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// 1. Initialisation avec MonPanneau au lieu du JPanel standard
		contentPane = new MonPanneau();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Barre de menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Lancer le programme");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNewMenuItem.setBackground(new Color(0, 255, 0));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonJDialog dialog = new MonJDialog();
				dialog.setVisible(true);
				if (dialog.isValide()) {
					double a = dialog.getA();
					double b = dialog.getB();
					double c = dialog.getC();

					Eqdegre2 eq = new Eqdegre2(a, b, c);

					// Transmission des données à MonPanneau qui gère le dessin dans paintComponent
					contentPane.setTexte(
						"Résultat : " + eq.toString(), 
						"Coefficients : a = " + a + ", b = " + b + ", c = " + c
					);
				}
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("aide");
		mntmNewMenuItem_1.setBackground(new Color(255, 255, 0));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MaFenetrePaint.this, 
					"Application de résolution d'équation du 2nd degré (Version Custom Paint).", 
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
		
		/*
		// 3. Image
		ImageIcon originalIcon = new ImageIcon(MaFenetrePaint.class.getResource("/exercice1/meme.jpg"));
		java.awt.Image img = originalIcon.getImage();
		java.awt.Image resizedImg = img.getScaledInstance(125, 125, java.awt.Image.SCALE_SMOOTH);
				
		JLabel image_test = new JLabel("");
		image_test.setIcon(new ImageIcon(resizedImg));
		image_test.setBounds(280, 10, 125, 125);
		contentPane.add(image_test); */
	}
}