package com.gestion.commande.commande_produit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.commande.commande_produit.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByLibelle(String libelle);
}
