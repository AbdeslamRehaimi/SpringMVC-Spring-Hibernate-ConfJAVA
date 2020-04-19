package com.spring.cours.beans.dao;

import com.spring.cours.beans.entities.Utilisateur;

import java.util.List;

public interface utilisateurDAO {
    public List<Utilisateur> getAllUtilisateur();
    public void ajouteUtilisateur(Utilisateur u);
    public Utilisateur getUtilisateur(int id);
    public void deleteUtilisateur(int id);
}
