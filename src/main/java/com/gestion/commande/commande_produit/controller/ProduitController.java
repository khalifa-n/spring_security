package com.gestion.commande.commande_produit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestion.commande.commande_produit.models.Categorie;
import com.gestion.commande.commande_produit.models.Produit;
import com.gestion.commande.commande_produit.services.ProduitService;

@Controller
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    


    @GetMapping("/categorie")
    public String getViewAddCategorie(Model model) {
        Categorie categorie = new Categorie();
        
        model.addAttribute("categorie", categorie);
        return "categorie/categorie-add";
    }

    @GetMapping("/categorie/delete/{id}")
    public String getViewAddCategorie(@PathVariable Long id, Model model) {
        Categorie categorie = produitService.findCategorieById(id);
        if(categorie == null) {
            model.addAttribute("error", "Categorie introuvable");
            return "categorie/categorie";
        }

        produitService.deleteCategorie(categorie);
        model.addAttribute("succes", "Operation effectuer avec succes");
        return "redirect:/categorie-list";
    }

    @GetMapping("/categorie-list")
    public String getViewListCategorie(Model model) {
        List<Categorie> categories = produitService.getAllCategorie();

        model.addAttribute("categories", categories);
        return "categorie/categorie";
    }

    @PostMapping("/categorie")
    public String addCategorie(@ModelAttribute("categorie") Categorie categorie,Model model) {
        if(categorie == null || categorie.getNom() == null || categorie.getNom().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "categorie/categorie-add";
        }
        produitService.addCategorie(categorie);
        if (categorie.getId() != null) {
            return "redirect:/categorie-list";
        } else {
            model.addAttribute("error", "Echec de l'operation");
            return "categorie/categorie-add";
        }
        
    }


    //###########produit endpoint ###########
    @GetMapping("/produit-add")
    public String getViewAddProduit(Model model) {
        Produit produit = new Produit();
        List<Categorie> categories = produitService.getAllCategorie();

        model.addAttribute("categories", categories);
        model.addAttribute("produit", produit);
        return "produit/produit-add";
    }

    @GetMapping("/produit")
    public String getViewListProduit(Model model) {
        
        List<Produit> produits = produitService.getAllProduits();

        model.addAttribute("produits", produits);
        return "produit/produit";
    }

    @PostMapping("/produit-add")
    public String addProduit(@ModelAttribute("produit") Produit produit,Model model) {
        if(produit == null) {
            model.addAttribute("error", "produit incorrect ");
            return "produit/produit-add"; 
        }

        boolean valide = true;

        if (produit.getNom() == null || produit.getNom().equals("")) {
            model.addAttribute("errorNom", "Nom obligatoire ");
            valide = false;
        }

        if (produit.getPrix() == 0) {
            model.addAttribute("errorPrix", "prix obligatoire ");
            valide = false;
        }

        if (produit.getCategorie() == null || produit.getCategorie().getId() == null) {
            model.addAttribute("errorCategorie", "categorie obligatoire ");
            valide = false;
        }

        if (valide) {
            produit.setNumero(1);
            produitService.addProduit(produit);
            return "redirect:/produit";
        }
        return "produit/produit-add";
    }
}
