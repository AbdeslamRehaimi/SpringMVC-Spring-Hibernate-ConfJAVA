package com.spring.cours.beans.entities;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Cours")
public class Cours implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_C")
    private Integer ID_C;

    @Size(min = 1, max = 100)
    @Basic(optional = false)
    @Column(name = "titre")
    @NotBlank(message = "titre et obligatoire !")
    @NotNull
    private String titre;

    @Size(min = 1, max = 100)
    @Basic(optional = false)
    @Column(name = "module")
    @NotBlank(message = "module et obligatoire !")
    @NotNull
    private String module;

    @Size(min = 1, max = 100)
    @Basic(optional = false)
    @Column(name = "auteur")
    @NotBlank(message = "auteur et obligatoire !")
    @NotNull
    private String auteur;

    @Size(min = 1, max = 100)
    @Basic(optional = false)
    @Column(name = "image")
    @NotBlank(message = "image et obligatoire !")
    @NotNull
    private String image;

    @JoinTable(name = "association", joinColumns = {
            @JoinColumn(name = "ID_C", referencedColumnName = "ID_C")}, inverseJoinColumns = {
            @JoinColumn(name = "ID_U", referencedColumnName = "ID_U")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Utilisateur> utilisateurList;

    public Cours() {
    }

    public Integer getID_C() {
        return ID_C;
    }

    public void setID_C(Integer ID_C) {
        this.ID_C = ID_C;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Utilisateur> getUtilisateurList() {
        return utilisateurList;
    }

    public void setUtilisateurList(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }
}