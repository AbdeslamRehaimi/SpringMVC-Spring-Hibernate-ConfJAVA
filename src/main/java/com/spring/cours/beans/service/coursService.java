package com.spring.cours.beans.service;

import com.spring.cours.beans.entities.Cours;

import java.util.List;

public interface coursService {
    public List<Cours> getAllCourses();
    public void ajouteCoure(Cours c);
    public Cours getCours(int id);
    public void deleteCours(int id);
}
