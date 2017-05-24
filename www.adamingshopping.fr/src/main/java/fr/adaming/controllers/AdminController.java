package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/setting")
public class AdminController {

	@Autowired
	private IProduitService produitService;

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}



	@RequestMapping(value = "/afficherProduits", method = RequestMethod.GET)
	public String afficherListProduit(ModelMap model) {
		List<Produit> listeProduit = produitService.consulterAll();
		model.addAttribute("listeProduit", listeProduit);
		return "afficherProduits";

	}

	// @RequestMapping(value="/consulterProduit", method=RequestMethod.POST)
	// public String consulterProduit(ModelMap model, @ModelAttribute("prod")
	// Produit p ){
	//
	// Produit prod_rec = produitService.consulter(p);
	// List<Produit> listeUnProduit = new ArrayList<Produit>();
	// listeUnProduit.add(prod_rec);
	// model.addAttribute("listeUnProduit", listeUnProduit);
	// return "afficherUnProduit";
	//
	// }
	// 
	//
	 @RequestMapping(value="/delete", method=RequestMethod.GET)
	 public String supprimerProduit(ModelMap model,@RequestParam("idProduit")
	 Long id){
	
	 Produit p_rec=new Produit();
	 p_rec.setIdProduit(id);
	 Produit p = produitService.consulter(p_rec);
	 produitService.supprimer(p);
	 
	 
	 List<Produit> listeProduit = produitService.consulterAll();
	 model.addAttribute("listeProduit", listeProduit);
	 return "afficherProduits";
	 }
	 
	 
	 //public String afficherFormProduit(Model)
	
	 @RequestMapping(value="/modifier", method=RequestMethod.POST)
	 public String modifierProduit(ModelMap model, @ModelAttribute("prod")
	 Produit p){
	
	 produitService.modifier(p);
	
	 return "afficherProduits";
	
	 }
	
	 
	 
	 
	 
	// @RequestMapping(value="/ajouter", method=RequestMethod.POST)
	// public String ajouterProduit(ModelMap model,
	// @ModelAttribute("prod")Produit p){
	//
	// produitService.ajouter(p);
	//
	// return "afficherProduits";
	//
	// }

}
