package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;

@Controller
@RequestMapping("/settingCat")
public class AdminCatController {

	@Autowired
	private ICategorieService categorieService;

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}
	
	@RequestMapping(value="/afficherCategorieAdmin", method=RequestMethod.GET)
	public String afficherCategorie(ModelMap model){
		List<Categorie> listCategorie=categorieService.consulterAll();
		model.addAttribute("listCategorie", listCategorie);
		return "afficherCategorieAdmin";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String supprimerCategorie(ModelMap model, @RequestParam("idCategorie") int id) {

		Categorie c = categorieService.consulter(id);
		categorieService.supprimer(c);
		
		List<Categorie> listCategorie=categorieService.consulterAll();
		model.addAttribute("listCategorie", listCategorie);
		
		return "afficherCategorieAdmin";
	}
	
	

	
	
}
