package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Requetes {

	public  static final String requetep1 = "SELECT * FROM `ville_france` where "; 
			//\\r\\n\" + \"";
	public Connexion co;
	
	
	public void getVilles(String pattern) {
		this.co = new Connexion();
		this.co.connexionBDD();
		Statement stmt;
		try {
			stmt = this.co.getCo().createStatement();
			ResultSet rs = stmt.executeQuery(requetep1+ "Code_commune_INSEE LIKE "+ pattern 
													  + " OR Nom_commune LIKE " + pattern
													  + " OR Code_postal LIKE " + pattern
													  + " OR Libelle_acheminement LIKE " + pattern 
													  + " OR Ligne_5 LIKE " + pattern
													  + " OR Latitude LIKE " + pattern
													  + " OR Longitude LIKE " + pattern
													  + "\r\n" + "");
			while (rs.next())
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
						+ rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}