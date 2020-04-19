package com.spring.cours.beans.entities;

import javax.persistence.*;
import java.util.List;
import java.io.Serializable;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Utilisateur")
public class Utilisateur implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_U")
    private Integer ID_U;

    @Size(min = 1, max = 100)
    @Basic(optional = false)
    @Column(name = "nom")
    @NotBlank(message = "Vous devez indiquer votre nom !")
    @NotNull
    private String nom;

    @Size(min = 1, max = 100)
    @Basic(optional = false)
    @Column(name = "prenom")
    @NotBlank(message = "Vous devez indiquer votre prenom !")
    @NotNull
    private String prenom;

    @Size(min = 1, max = 100)
    @Basic(optional = false)
    @Column(name = "email")
    @NotBlank(message = "Vous devez indiquer votre email !")
    @NotNull
    @Email
    private String email;

    @Size(min = 8, max = 200)
    @Basic(optional = false)
    @Column(name = "password")
    @NotBlank(message = "Password invalid !")
    @NotNull
    private String password;

    //@Size(min = 1, max = 100)
    @Basic(optional = false)
    @Column(name = "identiter")
    @NotBlank(message = "Vous devez indique votre identiter !")
    @NotNull
    private String identiter;

    //@Size(min = 1, max = 500)
    //@Basic(optional = false)
    @Column(name = "image")
    //@NotBlank(message = "image et obligatoire !")
    //@NotNull
    private String image;

    @Size(min = 8, max = 200)
    @Basic(optional = false)
    @NotBlank(message = "password et confirmation obligatoire !")
    @NotNull
    private String confirmpassword;

    @ManyToMany(mappedBy = "utilisateurList", fetch = FetchType.EAGER)
    private List<Cours> coursList;


    public Utilisateur() {
    }

    public Integer getID_U() {
        return ID_U;
    }

    public void setID_U(Integer ID_U) {
        this.ID_U = ID_U;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getIdentiter() {
        return identiter;
    }

    public void setIdentiter(String identiter) {
        this.identiter = identiter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }
}
