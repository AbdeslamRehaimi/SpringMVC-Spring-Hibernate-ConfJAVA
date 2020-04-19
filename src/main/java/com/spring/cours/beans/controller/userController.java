package com.spring.cours.beans.controller;

import com.spring.cours.beans.entities.Utilisateur;
import com.spring.cours.beans.security.SecureSHA1;
import com.spring.cours.beans.service.utilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Controller
//@RequestMapping("/user" )
public class userController {

    private utilisateurService utilisateurService;

    @Autowired(required = true)
    public void setUtilisateurService(utilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    //Navigation request
    @Transactional
    @RequestMapping(value="/user/list" )
    public String lisUtilisateur(Model model) {
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateur();
        model.addAttribute("utilisateur", utilisateurs);
        System.out.println("_____________________Reached_______________________");
        return "list-users";
    }

    //Navigation request
    @RequestMapping(value="/user/register" )
    public String registerReq(Model theModel) {
        Utilisateur user = new Utilisateur();
        theModel.addAttribute("user", user);
        return "register";
    }



    //Navigation request
    @RequestMapping(value="/user/login" )
    public String loginReq(Model theModel) {
        Utilisateur user = new Utilisateur();
        theModel.addAttribute("user", user);
        return "login";
    }


    //Action request
    @RequestMapping(value="/user/saveUser", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") Utilisateur utilisateur, BindingResult bindingResult) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (bindingResult.hasErrors()) {
            return "form-user";
        }
        String securedPassword = SecureSHA1.getSHA1(utilisateur.getPassword());
        utilisateur.setPassword(securedPassword);
        utilisateurService.ajouteUtilisateur(utilisateur);
        return "redirect:/user/list";
    }

    //Action request
    //Not implemented for the moment, As this is just a demo application.
    @RequestMapping(value="/user/authentification", method = RequestMethod.POST)
    public String authentification(@Valid @ModelAttribute("user") Utilisateur utilisateur, BindingResult bindingResult, Model model) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        //System.out.println("Email and password are"+ utilisateur.getEmail()+" "+utilisateur.getPassword());
        List<Utilisateur> allUsers = utilisateurService.getAllUtilisateur();
        //String indicateur = null;

        //String securedPassword = SecureSHA1.getSHA1(utilisateur.getPassword());
        /*for(int i=0; i<allUsers.size(); i++){
            if (utilisateur.getEmail().equals(allUsers.get(i).getEmail()) && securedPassword.equals(allUsers.get(i).getPassword())){
                indicateur = "yes";
                //break;
            }else{
                indicateur = null;
            }
        }
        if(indicateur.equals("yes")){
            return "redirect:/user/list";
        }else{
            return "redirect:/user/login";
        }*/
         //model.addAttribute("user", utilisateur);
        System.out.println("Nom Complet we got is: "+utilisateur.getNom() + " " +utilisateur.getPrenom());
        model.addAttribute("utilisateur", allUsers);
        model.addAttribute("bnvnu", "Bienvenu: ");
        model.addAttribute("nomcomplet", utilisateur.getNom() + " " + utilisateur.getPrenom());
        return "list-users";
    }

    //Navigation request
    @RequestMapping(value="/user/update")
    public String updateUser(@RequestParam("ID_U") int id, Model model) {
        Utilisateur utilisateur = utilisateurService.getUtilisateur(id);
        utilisateur.setPassword(null);
        utilisateur.setConfirmpassword(null);
        model.addAttribute("user", utilisateur);
        return "form-user";
    }

    //Action request
    @RequestMapping(value="/user/delete")
    public String deleteUser(@RequestParam("ID_U") int id) {
        utilisateurService.deleteUtilisateur(id);
        return "redirect:/user/list";
    }


    @RequestMapping(value="/user/new")
    public String deleteUser(Model theModel) {
        Utilisateur user = new Utilisateur();
        theModel.addAttribute("user", user);

        return "form-user";
    }
}
