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

public class MonJDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtC;
	private JTextField txtB;
	private JTextField txtA;
	
	private double a, b, c;
    private boolean valide = false;
    
    
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
		contentPanel.setLayout(null);
		{
			txtA = new JTextField();
			txtA.setBounds(272, 31, 96, 19);
			txtA.setText("1.0");
			contentPanel.add(txtA);
			txtA.setColumns(10);
		}
		{
			txtB = new JTextField();
			txtB.setBounds(272, 101, 96, 19);
			txtB.setText("2.0");
			txtB.setToolTipText("");
			contentPanel.add(txtB);
			txtB.setColumns(10);
		}
		{
			txtC = new JTextField();
			txtC.setBounds(272, 187, 96, 19);
			txtC.setText("3.0");
			contentPanel.add(txtC);
			txtC.setColumns(10);
		}
		
		JLabel lblNewLabel = new JLabel("Valeur de a ?");
		lblNewLabel.setBounds(190, 34, 72, 12);
		contentPanel.add(lblNewLabel);
		
		JLabel lblValeurDeB = new JLabel("Valeur de b ?");
		lblValeurDeB.setBounds(190, 104, 72, 12);
		contentPanel.add(lblValeurDeB);
		
		JLabel lblValeurDeC = new JLabel("Valeur de c ?");
		lblValeurDeC.setBounds(190, 190, 72, 12);
		contentPanel.add(lblValeurDeC);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						valide = false; // La saisie est annulée
				        dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
