package com.gestion.commande.commande_produit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.commande.commande_produit.models.Admin;
import com.gestion.commande.commande_produit.models.Role;
import com.gestion.commande.commande_produit.models.User;
import com.gestion.commande.commande_produit.repositories.AdminRepository;
import com.gestion.commande.commande_produit.repositories.RoleRepository;
import com.gestion.commande.commande_produit.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Admin findAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public Role findRoleByLibelle(String libelle) {
        return roleRepository.findByLibelle(libelle);
    }

    public User saveUser(User user) {
        try {
            userRepository.save(user);
            return user;
        } catch(Exception e) {
            throw e;
        }
    }
}
