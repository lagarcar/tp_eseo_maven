package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {

	Connection co;
	
	public Connection getCo() {
		return this.co;
	}
	
	public void connexionBDD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.co = DriverManager.getConnection("jdbc:mysql://localhost:3306/maven?serverTimezone = GMT ", "root", "");
	}catch (Exception e) {}
	}
}
