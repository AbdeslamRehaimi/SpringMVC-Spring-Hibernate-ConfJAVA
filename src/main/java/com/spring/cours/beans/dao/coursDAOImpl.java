package com.spring.cours.beans.dao;

import com.spring.cours.beans.entities.Cours;
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
public class coursDAOImpl implements coursDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Cours> getAllCourses() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Cours> coursCriteriaQuery = criteriaBuilder.createQuery(Cours.class);
        Root<Cours> coursRoot = coursCriteriaQuery.from(Cours.class);
        coursCriteriaQuery.select(coursRoot);
        Query query = session.createQuery(coursCriteriaQuery);
        return query.getResultList();
    }

    @Override
    public void ajouteCoure(Cours c) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(c);
    }

    @Override
    public Cours getCours(int id) {
        Session session = sessionFactory.getCurrentSession();
        Cours cours = session.get(Cours.class, id);
        return cours;
    }

    @Override
    public void deleteCours(int id) {
        Session session = sessionFactory.getCurrentSession();
        Cours cours = session.byId(Cours.class).load(id);
        session.delete(cours);
    }
}
