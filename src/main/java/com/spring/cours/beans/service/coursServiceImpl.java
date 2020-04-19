package com.spring.cours.beans.service;

import com.spring.cours.beans.dao.coursDAO;
import com.spring.cours.beans.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class coursServiceImpl implements coursService{
    @Autowired
    private coursDAO coursDAO;

    @Override
    @Transactional
    public List<Cours> getAllCourses() {
        return coursDAO.getAllCourses();
    }

    @Override
    @Transactional
    public void ajouteCoure(Cours c) {
        coursDAO.ajouteCoure(c);
    }

    @Override
    @Transactional
    public Cours getCours(int id) {
        return coursDAO.getCours(id);
    }

    @Override
    @Transactional
    public void deleteCours(int id) {
        coursDAO.deleteCours(id);
    }
}
