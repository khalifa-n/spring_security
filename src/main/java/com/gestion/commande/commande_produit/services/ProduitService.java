package com.gestion.commande.commande_produit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.commande.commande_produit.models.Categorie;
import com.gestion.commande.commande_produit.models.Produit;
import com.gestion.commande.commande_produit.repositories.CategorieRepository;
import com.gestion.commande.commande_produit.repositories.ProduitRepository;

import lombok.extern.java.Log;

@Service
@Log
public class ProduitService {
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private ProduitRepository produitRepository;

    // ##################service categorie ############
    public Categorie addCategorie(Categorie categorie) {
        try {
            categorieRepository.save(categorie);
            return categorie;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }

    public Categorie findCategorieById(Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public Categorie findCategorieByNom(String nom) {
        return categorieRepository.findByNom(nom).orElse(null);
    }

    public boolean deleteCategorie(Categorie categorie) {
        try {
            categorieRepository.delete(categorie);
            return true;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }


    // ################ service produit ###########

    public Produit addProduit(Produit produit) {
        try {
            produitRepository.save(produit);
            return produit;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }
}
