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
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JMenu;
import java.awt.Toolkit;

public class MaFenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblRacine1;
	private JLabel lblRacine2;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MaFenetre.class.getResource("/exercice1/meme.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menutp = new JMenu("Menu principal");
		menutp.setBackground(SystemColor.info);
		menuBar.add(menutp);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Lancer le programme");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonJDialog dialog = new MonJDialog();
				dialog.setVisible(true);

				if (dialog.isValide()) {
				    double a = dialog.getA();
				    double b = dialog.getB();
				    double c = dialog.getC();

				    Eqdegre2 eq = new Eqdegre2(a, b, c);

				    lblRacine1.setText("Résultat : " + eq.toString());
				    lblRacine2.setText("Coefficients : a = " + a + ", b = " + b + ", c = " + c);
				}
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNewMenuItem_3.setBackground(Color.GREEN);
		menutp.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("aide");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MaFenetre.this, 
					    "Application de résolution d'équation du 2nd degré.", 
					    "Aide", 
					    JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmNewMenuItem_1_1.setBackground(Color.YELLOW);
		menutp.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Quitter");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_2_1.setBackground(Color.RED);
		menutp.add(mntmNewMenuItem_2_1);

		// --- CONTENEUR PRINCIPAL (BorderLayout) ---
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 10));

		// 1. PANNEAU IMAGE (Au centre)
		ImageIcon originalIcon = new ImageIcon(MaFenetre.class.getResource("/exercice1/meme.jpg"));
		Image img = originalIcon.getImage();

		JPanel panelImage = new JPanel() {
			private static final long serialVersionUID = 1L;
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (img != null) {
					// Dessine l'image en s'adaptant exactement à la taille du panneau
					g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};
		panelImage.setBackground(Color.WHITE);
		contentPane.add(panelImage, BorderLayout.CENTER);

		// 2. PANNEAU RÉSULTATS (En bas avec ton GridLayout)
		JPanel panelResultats = new JPanel();
		panelResultats.setBackground(Color.WHITE);
		panelResultats.setLayout(new GridLayout(2, 1, 0, 5)); // 2 lignes, 1 colonne

		lblRacine1 = new JLabel("Racine 1 ");
		panelResultats.add(lblRacine1);

		lblRacine2 = new JLabel("Racine 2");
		panelResultats.add(lblRacine2);

		contentPane.add(panelResultats, BorderLayout.SOUTH);
	}
}