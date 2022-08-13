package com.gestion.commande.commande_produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gestion.commande.commande_produit.fixtures.UserFixture;

@SpringBootApplication
public class CommandeProduitApplication implements CommandLineRunner {

	@Autowired
	private UserFixture userFixture;
	public static void main(String[] args) {
		SpringApplication.run(CommandeProduitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// userFixture.loadDefaultAdmin();
	}

}
