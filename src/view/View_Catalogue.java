package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.mainMVC;
import model.LIVRE;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class View_Catalogue {

	private JFrame frame;
	private JTable table;

	/**
	 * Create the application.
	 */
	public View_Catalogue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CATALOGUE");
		lblNewLabel.setBounds(10, 11, 82, 14);
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
		btnNewButton.setBounds(693, 7, 89, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
		
        // --- TABLE ---
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 60, 762, 373);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        // Charger les livres
        loadLivres();
        frame.setVisible(true);
		
	}

    private void loadLivres() {
        try {
            // Récupération de la liste des livres via le contrôleur MVC
            ArrayList<LIVRE> livres = mainMVC.getM().getListLivre();

            // Création du modèle de tableau NON ÉDITABLE
            DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ISBN", "Titre", "Prénom Auteur", "Nom Auteur", "Prix €", "Disponibilité"}, 0
            ) {
                public boolean isCellEditable(int row, int column) {
                    return false; // empêche la modification de toutes les cellules
                }
            };
            // Ajout des données dans le tableau
            for (LIVRE l : livres) {
            	
                String dispo = (l.getEmprunteur() == null) ? "Disponible" : "Non disponible";
                model.addRow(new Object[]{
                    l.getISBN(),
                    l.getTitre(),
                    l.getAuteur().getPrenom(),
                    l.getAuteur().getNom(),
                    l.getPrix(),
                    dispo,
                });
            }
            table.setModel(model);
            table.getColumnModel().getColumn(0).setPreferredWidth(150);   // ISBN
            table.getColumnModel().getColumn(1).setPreferredWidth(280);  // Titre
            table.getColumnModel().getColumn(2).setPreferredWidth(160);  // Prénom auteur
            table.getColumnModel().getColumn(3).setPreferredWidth(160);  // Nom auteur
            table.getColumnModel().getColumn(4).setPreferredWidth(90);   // Prix
            table.getColumnModel().getColumn(5).setPreferredWidth(100);  // Disponibilité
            // Optionnel : activer le tri par colonne
            table.setAutoCreateRowSorter(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame,
                "Erreur lors du chargement du catalogue : " + e.getMessage(),
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
