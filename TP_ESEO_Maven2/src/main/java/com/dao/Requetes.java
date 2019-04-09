package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.blo.Ville;

public class Requetes {

	public static final String requetep1 = "SELECT * FROM `ville_france` where ";
	public static final String requeteNom = "SELECT Nom_commune FROM `ville_france` WHERE 1";
	public static final String requeteCode = "SELECT Code_postal FROM `ville_france` WHERE 1";
	public Connexion co;

	
	protected static String initialisationRequetePreparee(String sql, Object... objets) {
		String[] listeSQL = (sql+" ").split("\\?");
		StringBuilder newSQL = new StringBuilder(listeSQL[0]);
		for(int i = 0; i<objets.length; i++) {
			newSQL.append("\"" + objets[i] + "\"" + listeSQL[i+1]);
		}
		return newSQL.toString().replaceAll("\"null\"", "null");
	}	
	
	
	public String getVilles(String pattern) {
		String res = "";
		this.co = new Connexion();
		this.co.connexionBDD();
		Statement stmt;
		try {
			stmt = this.co.getCo().createStatement();
			String requeteFinale = requetep1 + "Code_commune_INSEE LIKE \"" + pattern + "\" OR Nom_commune LIKE \""
					+ pattern + "\" OR Code_postal LIKE \"" + pattern + "\"OR Libelle_acheminement LIKE \"" + pattern
					+ "\"OR Ligne_5 LIKE \"" + pattern + "\"OR Latitude LIKE \"" + pattern + "\"OR Longitude LIKE \""
					+ pattern + "\"";
			System.out.println(requeteFinale);

			ResultSet rs = stmt.executeQuery(requeteFinale);

			while (rs.next())
				res += rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  "
						+ rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7) + "<BR>";
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
					+ rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public String getAllVilles() {
		String res = "";
		this.co = new Connexion();
		this.co.connexionBDD();
		Statement stmt;
		try {
			stmt = this.co.getCo().createStatement();
			String requeteFinale = requetep1 + "1";
			System.out.println(requeteFinale);

			ResultSet rs = stmt.executeQuery(requeteFinale);

			while (rs.next()) {
				res += rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  "
						+ rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7) + "<BR>";
			System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  "
					+ rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public ArrayList<Ville> getAllVillesObject() {
		this.co = new Connexion();
		this.co.connexionBDD();
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Statement stmt;
		try {
			stmt = this.co.getCo().createStatement();
			String requeteFinale = requetep1 + "1";
			System.out.println(requeteFinale);

			ResultSet rs = stmt.executeQuery(requeteFinale);

			while (rs.next()) {
			Ville ville = new Ville(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6), rs.getString(7));
			villes.add(ville);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}
	
	public void postVilles(String codeCommune, String nomCommune, String codePostal, String libelle, String ligne5, String latitude, String longitude) {
		
		this.co = new Connexion();
		this.co.connexionBDD();
		PreparedStatement stmt;

		String requete = "INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude)"
				+ "VALUES (?,?,?,?,?,?,?)";
		
		try {
			stmt = this.co.getCo().prepareStatement(initialisationRequetePreparee(requete,codeCommune,nomCommune,codePostal,libelle,ligne5,latitude,longitude));
			stmt.executeUpdate();
			System.out.println("insert effectué");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public void putVilles(String codeCommune, String nomCommune, String codePostal, String libelle, String ligne5, String latitude, String longitude) {
		
		this.co = new Connexion();
		this.co.connexionBDD();
		PreparedStatement stmt;

		String requete = "UPDATE ville_france SET Code_commune_INSEE = ?, Nom_commune=?, Code_postal=?, Libelle_acheminement=?, Ligne_5=?, Latitude=?, Longitude=?";
		
		try {
			stmt = this.co.getCo().prepareStatement(initialisationRequetePreparee(requete,codeCommune,nomCommune,codePostal,libelle,ligne5,latitude,longitude));
			stmt.executeUpdate();
			System.out.println("update effectuée");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


public void deleteVilles(String codeCommune) {
	
	this.co = new Connexion();
	this.co.connexionBDD();
	PreparedStatement stmt;

	String requete = "DELETE from ville_france where Code_commune_INSEE = ?";
	
	try {
		stmt = this.co.getCo().prepareStatement(initialisationRequetePreparee(requete,codeCommune));
		stmt.executeUpdate();
		System.out.println("delete effectué");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public String TriNom() {
		String res = "";
		this.co = new Connexion();
		this.co.connexionBDD();
		Statement stmt;
		try {
			stmt = this.co.getCo().createStatement();

			ResultSet rs = stmt.executeQuery(requeteNom);

			while (rs.next())
				res += rs.getString(1)+ "<BR>";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	public String TriCode() {
		String res = "";
		this.co = new Connexion();
		this.co.connexionBDD();
		Statement stmt;
		try {
			stmt = this.co.getCo().createStatement();

			ResultSet rs = stmt.executeQuery(requeteCode);

			while (rs.next())
				res += rs.getString(1)+ "<BR>";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
