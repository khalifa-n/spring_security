package com.gestion.commande.commande_produit.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("CLIENT")
@Getter
@Setter
public class Client extends User{

    @Embedded
    private Adresse adresse;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes  = new ArrayList<>(); 

    
}
