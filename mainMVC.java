package controler;

import java.sql.SQLException;
import View.View_Accueil;
import model.model;

public class mainMVC {
	private static model m;
 
	public static model getM() {
	 return m;
 }
 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("lancement de mon programme");
		m=new model(); 
		View_Accueil va = new View_Accueil();


	}
}
