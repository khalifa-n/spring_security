package com.gestion.commande.commande_produit.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Embedded
    private Adresse adresseLiv;

    private String numCommande;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "client" , referencedColumnName = "id")
    private Client client ;

    @OneToMany(mappedBy = "commande")
    private List<CommandeProduit> commandeProduits = new ArrayList<>();
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(String numCommande) {
        this.numCommande = numCommande;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<CommandeProduit> getCommandeProduits() {
        return commandeProduits;
    }

    public void setCommandeProduits(List<CommandeProduit> commandeProduits) {
        this.commandeProduits = commandeProduits;
    }

    public Adresse getAdresseLiv() {
        return adresseLiv;
    }

    public void setAdresseLiv(Adresse adresseLiv) {
        this.adresseLiv = adresseLiv;
    }

   
}
