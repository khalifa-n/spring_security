xx²package com.gestion.commande.commande_produit.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.gestion.commande.commande_produit.models.Admin;
import com.gestion.commande.commande_produit.models.Role;
import com.gestion.commande.commande_produit.models.User;
import com.gestion.commande.commande_produit.services.UserService;

@Component
public class UserFixture {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void loadDefaultAdmin() {
        User user = new Admin();
        user.setEmail("admin@mail.com");
        user.setNom("admin");
        user.setPrenom("admin");
        user.setPassword(encoder.encode("passer"));
        Role role = userService.findRoleByLibelle("ADMIN");
        user.setRole(role);
        userService.saveUser(user);
    }
}
