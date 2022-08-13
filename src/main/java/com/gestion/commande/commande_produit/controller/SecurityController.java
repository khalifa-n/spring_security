package com.gestion.commande.commande_produit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestion.commande.commande_produit.models.User;
import com.gestion.commande.commande_produit.services.UserService;

@Controller
public class SecurityController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginView() {
        return "security/login";
    }

    @GetMapping("/admin/home")
    public String home(Model model){
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttribute("msg", "Bonjour " + user.getNom() + " " + user.getPrenom());
        return "admin/commande";
    }
}
