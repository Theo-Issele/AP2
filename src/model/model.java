package model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class model {
private ArrayList<LIVRE> listLivre;
private ArrayList<AUTEUR> listAuteur;
private ArrayList<ADHERENT> listAdherent;
private Connection conn;

//variable BDD (à changer pour local à web) 
private String BDD = "ap2";
private String url= "jdbc:mysql://localhost:3306/"+BDD;
private String user="root";
private String passwd="";

public model() throws ClassNotFoundException, SQLException {
	listLivre = new ArrayList<LIVRE>();
	listAuteur = new ArrayList<AUTEUR>();
	listAdherent = new ArrayList<ADHERENT>();
	//Connexion à la base de donnée
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url,user,passwd);
}

public ArrayList<LIVRE> getListLivre() {
	return listLivre;
}

public void setListLivre(ArrayList<LIVRE> listLivre) {
	this.listLivre = listLivre;
}

public ArrayList<AUTEUR> getListAuteur() {
	return listAuteur;
}

public void setListAuteur(ArrayList<AUTEUR> listAuteur) {
	this.listAuteur = listAuteur;
}

public ArrayList<ADHERENT> getListAdherent() {
	return listAdherent;
}

public void setListAdherent(ArrayList<ADHERENT> listAdherent) {
	this.listAdherent = listAdherent;
}

public void getall() throws ClassNotFoundException, SQLException {
	//Chargement des listes avec la bdd, on clear et on recharge pour refresh
	listAdherent.clear();
	listAuteur.clear();
	listLivre.clear();
	listLivre=new ArrayList<LIVRE>();
	listAuteur=new ArrayList<AUTEUR>();
	listAdherent=new ArrayList<ADHERENT>();
	ResultSet resultats;
	String requete;
	Statement stmt = conn.createStatement();
	
	//Création des auteurs
	requete ="SELECT * FROM auteur"; 
	//Exécute la requete
	resultats = stmt.executeQuery(requete);
	//Exploite le résultat
	while (resultats.next()) {
		AUTEUR a =new AUTEUR(resultats.getString(1),resultats.getString(2),resultats.getString(3),resultats.getString(4),resultats.getString(5));
		listAuteur.add(a);
	}
	
	//Création des adherents  
	requete ="SELECT * FROM adherent";
	
	resultats = stmt.executeQuery(requete);
	
	while (resultats.next()) {
		ADHERENT ad =new ADHERENT(resultats.getString(1),resultats.getString(2),resultats.getString(3),resultats.getString(4), listLivre);
		
		listAdherent.add(ad);
	}
	
	//Création des livres
	requete ="SELECT * FROM livre";

	resultats = stmt.executeQuery(requete);

	while (resultats.next()) {
		LIVRE l =new LIVRE(resultats.getString(1),resultats.getString(2),resultats.getFloat(3), null, null);
		if (resultats.getString(5)!=null)
		{
			l.setAuteur(findauteur(resultats.getString(5)));
		}
		if (resultats.getString(4)!=null) {
			l.setEmprunteur(findadherent(resultats.getString(4)));
		}
		listLivre.add(l);
	}
	//Commande pour afficher le prenom de l'auteur du premier livre de la listeLivre
	//System.out.println(listLivre.get(0).getAuteur().getPrenom());
}

public AUTEUR findauteur(String num) 
{
	for (AUTEUR a : listAuteur) 
	{
		if (a.getNum().equals(num)) 
		{
			return a;
		}
	}
	return null;
}

public ADHERENT findadherent(String num) 
{
	for (ADHERENT ad : listAdherent) 
	{
		if (ad.getNum().equals(num)) 
		{
			return ad;
		}
	}
	return null;
}
}

