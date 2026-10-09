package exercice1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MonJDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtC;
	private JTextField txtB;
	private JTextField txtA;
	
	private double a, b, c;
    private boolean valide = false;
    private JButton okButton;
    private JButton cancelButton;
    
    
    public boolean isValide() { return valide; }
    public double getA() { return a; }
    public double getB() { return b; }
    public double getC() { return c; }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MonJDialog dialog = new MonJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MonJDialog() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{190, 72, 96, 0};
		gbl_contentPanel.rowHeights = new int[]{31, 19, 51, 19, 67, 19, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel lblNewLabel = new JLabel("Valeur de a ?");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		{
			txtA = new JTextField();
			txtA.setText("1.0");
			GridBagConstraints gbc_txtA = new GridBagConstraints();
			gbc_txtA.anchor = GridBagConstraints.NORTHWEST;
			gbc_txtA.insets = new Insets(0, 0, 5, 0);
			gbc_txtA.gridx = 2;
			gbc_txtA.gridy = 1;
			contentPanel.add(txtA, gbc_txtA);
			txtA.setColumns(10);
		}
		
		JLabel lblValeurDeB = new JLabel("Valeur de b ?");
		GridBagConstraints gbc_lblValeurDeB = new GridBagConstraints();
		gbc_lblValeurDeB.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblValeurDeB.insets = new Insets(0, 0, 5, 5);
		gbc_lblValeurDeB.gridx = 1;
		gbc_lblValeurDeB.gridy = 3;
		contentPanel.add(lblValeurDeB, gbc_lblValeurDeB);
		{
			txtB = new JTextField();
			txtB.setText("2.0");
			txtB.setToolTipText("");
			GridBagConstraints gbc_txtB = new GridBagConstraints();
			gbc_txtB.anchor = GridBagConstraints.NORTHWEST;
			gbc_txtB.insets = new Insets(0, 0, 5, 0);
			gbc_txtB.gridx = 2;
			gbc_txtB.gridy = 3;
			contentPanel.add(txtB, gbc_txtB);
			txtB.setColumns(10);
		}
		
		JLabel lblValeurDeC = new JLabel("Valeur de c ?");
		GridBagConstraints gbc_lblValeurDeC = new GridBagConstraints();
		gbc_lblValeurDeC.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblValeurDeC.insets = new Insets(0, 0, 0, 5);
		gbc_lblValeurDeC.gridx = 1;
		gbc_lblValeurDeC.gridy = 5;
		contentPanel.add(lblValeurDeC, gbc_lblValeurDeC);
		{
			txtC = new JTextField();
			txtC.setText("3.0");
			GridBagConstraints gbc_txtC = new GridBagConstraints();
			gbc_txtC.anchor = GridBagConstraints.NORTHWEST;
			gbc_txtC.gridx = 2;
			gbc_txtC.gridy = 5;
			contentPanel.add(txtC, gbc_txtC);
			txtC.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        try {
				            a = Double.parseDouble(txtA.getText());
				            b = Double.parseDouble(txtB.getText());
				            c = Double.parseDouble(txtC.getText());
				            
				            valide = true; // Saisie réussie
				            dispose();     // Ferme la boîte de dialogue
				            
				        } catch (NumberFormatException ex) {
				            valide = false; // La saisie n'est pas valide
				            JOptionPane.showMessageDialog(
				                MonJDialog.this,
				                "Saisie invalide ! Vous devez saisir uniquement des chiffres.",
				                "Erreur de saisie", 
				                JOptionPane.ERROR_MESSAGE
				            );
				           
				        }
				    }
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						valide = false; // La saisie est annulée
				        dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			buttonPane.add(okButton);
			buttonPane.add(cancelButton);
		}
	}
}
