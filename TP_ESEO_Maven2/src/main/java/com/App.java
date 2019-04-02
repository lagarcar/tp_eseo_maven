package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
