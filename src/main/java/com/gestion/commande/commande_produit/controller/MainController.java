package com.gestion.commande.commande_produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestion.commande.commande_produit.repositories.UserRepository;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping({"/", "/index"})
    public String index(Model model) {
        System.out.println(userRepository.findByEmail("admin@mail.com").getEmail());
        model.addAttribute("message", "A E221");
        return "index";
    }
    
}
