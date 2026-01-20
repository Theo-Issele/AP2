package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;

import javax.swing.JList;
import java.awt.List;

public class View_Infoperso {

	private JFrame frame;
	private JTextField textField_nom;
	private JTextField textField_prenom;
	private JTextField textField_email;
	private JTextField textField_num;

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public View_Infoperso() throws ClassNotFoundException, SQLException {
		mainMVC.getM().getall();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INFORMATION PERSO");
		lblNewLabel.setBounds(10, 11, 162, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ACCUEIL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				  try {
					new View_Accueil();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(56, 76, 312, 174);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		
		JLabel lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setBounds(10, 40, 46, 14);
		panel.add(lblNewLabel_1);
		
		textField_nom = new JTextField();
		textField_nom.setBounds(66, 37, 86, 20);
		panel.add(textField_nom);
		textField_nom.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prénom :");
		lblNewLabel_1_1.setBounds(10, 79, 56, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email :");
		lblNewLabel_1_2.setBounds(10, 121, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		textField_prenom = new JTextField();
		textField_prenom.setColumns(10);
		textField_prenom.setBounds(66, 76, 86, 20);
		panel.add(textField_prenom);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(53, 118, 177, 20);
		panel.add(textField_email);
		
		JLabel lblNewLabel_3 = new JLabel("Liste Livre :");
		lblNewLabel_3.setBounds(200, 11, 86, 14);
		panel.add(lblNewLabel_3);
		
		List list = new List();
		list.setBounds(170, 31, 132, 81);
		panel.add(list);
		
		JLabel lblNewLabel_4 = new JLabel("Mise à jour effectuée");
		lblNewLabel_4.setBounds(170, 153, 132, 14);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		
		
		JButton btnNewButton_2 = new JButton("Mettre à jour");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = textField_nom.getText();
				String num = textField_num.getText();
				String prenom = textField_prenom.getText();
				String email = textField_email.getText();
				try {
					mainMVC.getM().update_adherentnom(nom, num);
					mainMVC.getM().update_adherentprenom(prenom, num);
					mainMVC.getM().update_adherentemail(email, num);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblNewLabel_4.setVisible(true);
		        // Crée un timer qui s’exécute après 3 secondes (3000 ms)
		        Timer timer = new Timer(3000, new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                lblNewLabel_4.setVisible(false); // Cache le label après 3 secondes
		            }
		        });
		        timer.setRepeats(false); // Exécute une seule fois
		        timer.start();
			}
		});
		btnNewButton_2.setBounds(36, 149, 124, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Numéro de compte :");
		lblNewLabel_2.setBounds(43, 36, 142, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_num = new JTextField();
		textField_num.setBounds(169, 33, 86, 20);
		frame.getContentPane().add(textField_num);
		textField_num.setColumns(10);
		
		JLabel message_error = new JLabel("Ce numéro de compte n'éxiste pas");
		message_error.setBounds(56, 61, 199, 14);
		frame.getContentPane().add(message_error);
		message_error.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField_num.getText();
				ADHERENT ad = mainMVC.getM().findadherent(num);
				if (ad!=null) {
					//
					message_error.setVisible(false);
					textField_num.setEditable(false);
					panel.setVisible(true);
					textField_nom.setText(ad.getNom());
					textField_prenom.setText(ad.getPrenom());
					textField_email.setText(ad.getEmail());
					for(LIVRE l : ad.getListLivre()) {
						list.add(l.getISBN()+"   "+l.getTitre()+"   "+l.getAuteur().getNom());
					}
				}else {
					message_error.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(265, 32, 63, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		frame.setVisible(true);
	}
}
