package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import controller.mainMVC;
import model.ADHERENT;
import model.LIVRE;

public class View_Restitue {

	private JFrame frame;
	private JTextField textField_isbn;

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public View_Restitue() throws ClassNotFoundException, SQLException {
		mainMVC.getM().getall();;
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
		
		JLabel lblNewLabel = new JLabel("RESTITUER");
		lblNewLabel.setBounds(10, 11, 79, 14);
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
		
		JLabel lblNewLabel_1 = new JLabel("ISBN :");
		lblNewLabel_1.setBounds(66, 136, 64, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_isbn = new JTextField();
		textField_isbn.setBounds(130, 133, 86, 20);
		frame.getContentPane().add(textField_isbn);
		textField_isbn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Insérer l'ISBN du livre que vous voulez restituer");
		lblNewLabel_2.setBounds(49, 97, 283, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel isbn_introuvable = new JLabel("ISBN introuvable dans la liste !");
		isbn_introuvable.setBounds(84, 176, 198, 14);
		frame.getContentPane().add(isbn_introuvable);
		isbn_introuvable.setVisible(false);
		
		JLabel livre_rendu = new JLabel("Votre livre a bien été rendu !");
		livre_rendu.setBounds(84, 190, 198, 14);
		frame.getContentPane().add(livre_rendu);
		livre_rendu.setVisible(false);
		
		JLabel livre_pasemprunte = new JLabel("Le livre n'est pas emrunté !");
		livre_pasemprunte.setBounds(84, 206, 198, 14);
		frame.getContentPane().add(livre_pasemprunte);
		livre_pasemprunte.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Restituer");
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String isbn = textField_isbn.getText();
		        boolean trouve = false;
		        // On parcourt la liste de livres pour trouver celui qui correspond à l'ISBN
		        for (LIVRE l : mainMVC.getM().getListLivre()) 
		        {
		            if (l.getISBN().equals(isbn)) 
		            {
		            	trouve = true;
		            	if(l.getEmprunteur()!= null) 
		            	{
		            		try {
		                    mainMVC.getM().restituer(isbn);           
		                    livre_rendu.setVisible(true);
		                    livre_pasemprunte.setVisible(false);
		                    isbn_introuvable.setVisible(false);
		                	} catch (SQLException e1) {
		                    e1.printStackTrace();
		                	}
		                break; // on sort de la boucle une fois trouvé
		            	}
		            	else 
		            	{
		            	livre_pasemprunte.setVisible(true);
		            	livre_rendu.setVisible(false);
		            	isbn_introuvable.setVisible(false);
		            	}
		            }
		        }
		        if (!trouve) {
		            isbn_introuvable.setVisible(true);
		            livre_rendu.setVisible(false);
		            livre_pasemprunte.setVisible(false);
		        }  
		    }
		});
		btnNewButton_1.setBounds(247, 132, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
	}
}
