package com.gestion.commande.commande_produit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.commande.commande_produit.models.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>  {

    // @Query("SELECT c FROM Categorie c WHERE c.nom=:nom")
    Optional<Categorie> findByNom(String nom);
}
