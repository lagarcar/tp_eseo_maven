package com.TP_ESEO_Maven2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		try {
			SpringApplication.run(App.class, args);
			System.out.println("appli démarrée");
		} catch (Exception e) {
			System.out.println("Appli erreur \n" + e);
		}
	}
		
}
