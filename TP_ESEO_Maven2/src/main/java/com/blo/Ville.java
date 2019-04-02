package com.blo;

public class Ville {
	public String code_communne_insee;
	public String nom_commune;
	public String code_postal;
	public String libelle_acheminement;
	public String ligne_5;
	public String latitude;
	public String longitude;

	public Ville(String code_communne_insee, String nom_commune, String code_postal, String libelle_acheminement,
			String ligne_5, String latitude, String longitude) {
		super();
		this.code_communne_insee = code_communne_insee;
		this.nom_commune = nom_commune;
		this.code_postal = code_postal;
		this.libelle_acheminement = libelle_acheminement;
		this.ligne_5 = ligne_5;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCode_communne_insee() {
		return code_communne_insee;
	}

	public void setCode_communne_insee(String code_communne_insee) {
		this.code_communne_insee = code_communne_insee;
	}

	public String getNom_commune() {
		return nom_commune;
	}

	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getLibelle_acheminement() {
		return libelle_acheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelle_acheminement = libelle_acheminement;
	}

	public String getLigne_5() {
		return ligne_5;
	}

	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
