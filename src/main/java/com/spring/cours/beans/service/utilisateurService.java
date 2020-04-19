package com.spring.cours.beans.service;

import com.spring.cours.beans.entities.Utilisateur;

import java.util.List;

public interface utilisateurService {
    public List<Utilisateur> getAllUtilisateur();
    public void ajouteUtilisateur(Utilisateur u);
    public Utilisateur getUtilisateur(int id);
    public void deleteUtilisateur(int id);
}
