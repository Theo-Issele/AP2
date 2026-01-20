package model;

public class LIVRE {

	
	private String ISBN;
	private String titre;
	private float prix;
	private AUTEUR auteur;
	private ADHERENT Emprunteur;

	
	public LIVRE(String iSBN, String titre, float prix, AUTEUR auteur, ADHERENT emprunteur) {

		ISBN = iSBN;
		this.titre = titre;
		this.prix = prix;
		this.auteur = auteur;
		Emprunteur = emprunteur;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public AUTEUR getAuteur() {
		return auteur;
	}
	public void setAuteur(AUTEUR auteur) {
		this.auteur = auteur;
	}
	public ADHERENT getEmprunteur() {
		return Emprunteur;
	}
	public void setEmprunteur(ADHERENT emprunteur) {
		Emprunteur = emprunteur;
	}
	
	
}
