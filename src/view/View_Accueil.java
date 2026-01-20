package view;

import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import controller.mainMVC;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class View_Accueil {

	private JFrame frame;


	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public View_Accueil() throws ClassNotFoundException, SQLException {
		mainMVC.getM().getall();
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCUEIL");
		lblNewLabel.setBounds(10, 11, 67, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INFORMATION PERSO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					View_Infoperso vi = new View_Infoperso();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(123, 54, 179, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCatalogue = new JButton("CATALOGUE");
		btnCatalogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new View_Catalogue();
			}
		});
		btnCatalogue.setBounds(140, 108, 135, 23);
		frame.getContentPane().add(btnCatalogue);
		
		JButton btnE = new JButton("EMPRUNTER");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new View_Emprunt();
			}
		});
		btnE.setBounds(58, 156, 135, 23);
		frame.getContentPane().add(btnE);
		
		JButton btnRestituer = new JButton("RESTITUER");
		btnRestituer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				try {
					new View_Restitue();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRestituer.setBounds(221, 156, 135, 23);
		frame.getContentPane().add(btnRestituer);
	}
}
