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

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;

public class View_Emprunt {
	private JFrame frame;
	private JTextField textField_num;
	private JTextField textField_isbn;
	/**
	 * Create the application.
	 */
	public View_Emprunt() {
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
		
		JLabel lblNewLabel = new JLabel("EMPRUNTER");
		lblNewLabel.setBounds(10, 11, 71, 14);
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
		btnNewButton.setBounds(335, 7, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(66, 94, 315, 156);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("ISBN :");
		lblNewLabel_3.setBounds(10, 55, 68, 27);
		panel.add(lblNewLabel_3);
		
		textField_isbn = new JTextField();
		textField_isbn.setBounds(62, 56, 93, 24);
		panel.add(textField_isbn);
		textField_isbn.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Entrez l'ISBN du livre que vous souhaitez emprunter !");
		lblNewLabel_4.setBounds(10, 22, 305, 14);
		panel.add(lblNewLabel_4);
		
		JLabel isbn_inconnu = new JLabel("L'ISBN entré n'éxiste pas !");
		isbn_inconnu.setBounds(62, 93, 148, 14);
		panel.add(isbn_inconnu);
		isbn_inconnu.setVisible(false);
		
		JLabel livre_emprunter = new JLabel("Le livre a bien été emprunté !");
		livre_emprunter.setBounds(62, 107, 169, 14);
		panel.add(livre_emprunter);
		livre_emprunter.setVisible(false);
		
		JLabel livre_pasdispo = new JLabel("Le livre n'est pas disponible !");
		livre_pasdispo.setBounds(62, 118, 181, 14);
		panel.add(livre_pasdispo);
		livre_pasdispo.setVisible(false);
		
		JButton btn_emprunter = new JButton("Emprunter");
		btn_emprunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String isbn = textField_isbn.getText();
		        String num = textField_num.getText();
		        boolean trouve = false;
		        // On parcourt la liste de livres pour trouver celui qui correspond à l'ISBN
		        for (LIVRE l : mainMVC.getM().getListLivre()) 
		        {
		            if (l.getISBN().equals(isbn)) 
		            {
		            	trouve = true;
		            	if(l.getEmprunteur() == null) 
		            	{
		            		try {
		                    mainMVC.getM().emprunter(isbn,num);           
		                    livre_emprunter.setVisible(true);
		                    isbn_inconnu.setVisible(false);
		                    livre_pasdispo.setVisible(false);
		                	} catch (SQLException e1) {
		                    e1.printStackTrace();
		                	}
		                break; // on sort de la boucle une fois trouvé
		            	}
		            	else 
		            	{
		            	livre_emprunter.setVisible(false);
		            	livre_pasdispo.setVisible(true);
		            	isbn_inconnu.setVisible(false);
		            	}
		            }
		        }
		        if (!trouve) {
		            isbn_inconnu.setVisible(true);
		            livre_emprunter.setVisible(false);
		            livre_pasdispo.setVisible(false);
		        } 
			}
		});
		btn_emprunter.setBounds(175, 57, 111, 23);
		panel.add(btn_emprunter);	
		
		JLabel lblNewLabel_1 = new JLabel("Numéro de Compte :");
		lblNewLabel_1.setBounds(55, 44, 115, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_num = new JTextField();
		textField_num.setBounds(180, 41, 86, 20);
		frame.getContentPane().add(textField_num);
		textField_num.setColumns(10);
		
		JLabel message_error = new JLabel("Ce numéro de compte n'éxiste pas, veuillez réessayer");
		message_error.setBounds(55, 69, 326, 14);
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
				}else {
					message_error.setVisible(true);
				}
			}
		});
		btnNewButton_1.setBounds(273, 40, 54, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(121, 69, 145, 14);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setVisible(true);
	}
}
