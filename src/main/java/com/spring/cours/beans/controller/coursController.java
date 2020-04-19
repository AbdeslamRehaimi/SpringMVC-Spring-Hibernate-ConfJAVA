package com.spring.cours.beans.controller;

 import com.spring.cours.beans.entities.Cours;
 import com.spring.cours.beans.entities.Utilisateur;
 import com.spring.cours.beans.security.SecureSHA1;
 import com.spring.cours.beans.service.coursService;
 import com.spring.cours.beans.service.utilisateurService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 import org.springframework.validation.BindingResult;
 import org.springframework.web.bind.annotation.ModelAttribute;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.RequestParam;

 import javax.validation.Valid;
 import java.io.UnsupportedEncodingException;
 import java.security.NoSuchAlgorithmException;
 import java.util.List;

@Controller
//@RequestMapping("/cours")
public class coursController {
    @Autowired
    private utilisateurService utilisateurService;

    private coursService coursService;


    @Autowired(required = true)
    public void setCoursService(coursService coursService) {
        this.coursService = coursService;
    }

    @RequestMapping(value="/cours/list" )
    public String lisCours(Model model) {
        List<Cours> coursList = coursService.getAllCourses();
        model.addAttribute("cours", coursList);
        return "list-cours";
    }


    @RequestMapping(value="/cours/new")
    public String deleteUser(Model theModel) {
        Cours cours = new Cours();
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateur();
        theModel.addAttribute("utilisateur", utilisateurs);
        theModel.addAttribute("cour", cours);

        return "form-cour";
    }

    //Action request
    @RequestMapping(value="/cours/saveCour", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("cour") Cours cours, BindingResult bindingResult, Model theModel) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (bindingResult.hasErrors()) {
            List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateur();
            theModel.addAttribute("utilisateur", utilisateurs);
            return "form-cour";
        }

        coursService.ajouteCoure(cours);
        return "redirect:/cours/list";
    }


    //Navigation request
    @RequestMapping(value="/cours/update")
    public String updateUser(@RequestParam("ID_C") int id, Model model) {
        Cours cours = coursService.getCours(id);
        model.addAttribute("cour", cours);
        //Cours cours = new Cours();
        List<Utilisateur> utilisateurs = utilisateurService.getAllUtilisateur();
        model.addAttribute("utilisateur", utilisateurs);
        return "form-cour";
    }

    //Action request
    @RequestMapping(value="/cours/delete")
    public String deleteUser(@RequestParam("ID_C") int id) {
        coursService.deleteCours(id);
        return "redirect:/cours/list";
    }
}
