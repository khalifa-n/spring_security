package com.gestion.commande.commande_produit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.commande.commande_produit.models.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    
}
