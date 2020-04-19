package com.spring.cours.beans.service;

import com.spring.cours.beans.dao.utilisateurDAO;
import com.spring.cours.beans.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class utilisateurServiceImpl implements utilisateurService {
    @Autowired
    private utilisateurDAO utilisateurDAO;

    @Override
    @Transactional
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurDAO.getAllUtilisateur();
    }

    @Override
    @Transactional
    public void ajouteUtilisateur(Utilisateur u) {
        utilisateurDAO.ajouteUtilisateur(u);
    }

    @Override
    @Transactional
    public Utilisateur getUtilisateur(int id) {
        return utilisateurDAO.getUtilisateur(id);
    }

    @Override
    @Transactional
    public void deleteUtilisateur(int id) {
        utilisateurDAO.deleteUtilisateur(id);
    }
}
