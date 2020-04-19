package com.spring.cours.beans.dao;

import com.spring.cours.beans.entities.Utilisateur;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class utilisateurDAOImpl implements utilisateurDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> utilisateurCriteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
        Root<Utilisateur> utilisateurRoot = utilisateurCriteriaQuery.from(Utilisateur.class);
        utilisateurCriteriaQuery.select(utilisateurRoot);
        Query query = session.createQuery(utilisateurCriteriaQuery);
        return query.getResultList();
    }

    @Override
    public void ajouteUtilisateur(Utilisateur u) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(u);
    }

    @Override
    public Utilisateur getUtilisateur(int id) {
        Session session = sessionFactory.getCurrentSession();
        Utilisateur utilisateur = session.get(Utilisateur.class, id);
        return utilisateur;
    }

    @Override
    public void deleteUtilisateur(int id) {
        Session session = sessionFactory.getCurrentSession();
        Utilisateur utilisateur = session.byId(Utilisateur.class).load(id);
        session.delete(utilisateur);
    }
}
