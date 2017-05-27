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

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService cSer;

	/**
	 * @param cSer
	 *            the cSer to set
	 */
	public void setcSer(IClientService cSer) {
		this.cSer = cSer;
	}

	@RequestMapping(value = "/afficherCategories", method = RequestMethod.GET)
	public String afficherListCategorie(ModelMap model) {
		List<Categorie> listeCategorie = cSer.getAllCategories();
		model.addAttribute("listeCategorie", listeCategorie);
		return "afficherCategories";
	}

//	@RequestMapping(value = "/afficherProduitCat", method = RequestMethod.GET)
//	public String afficherListProduitByCat(ModelMap model, Produit p) {
//		List<Produit> listeProduitsCat = cSer.getAllProduitByCategories(p);
//		model.addAttribute("listeCategorie", listeProduitsCat);
//		return "afficherProduitCat";
//	}

//	@RequestMapping(value = "/afficherProduitCat", method = RequestMethod.GET)
//	public String rechercheProduit(ModelMap model, @ModelAttribute("pProduit") Produit p) {
//
//		Produit p_rec = (Produit) cSer.getAllProduitByCategories(p);
//		List<Produit> listeProduitsCat = new ArrayList<Produit>();
//		listeProduitsCat.add(p_rec);
//		model.addAttribute("listeProduitCat", listeProduitsCat);
//
//		return "afficherProduitCat";
//
//	}
////	
//	@RequestMapping(value="/afficherProduitCat", method=RequestMethod.GET)
//	public ModelAndView afficherFormProduitCat(){
//		return new ModelAndView("afficherProduitCat","mProduit", new Produit());
//	}
//	
//	@RequestMapping(value="/afficherProduitCat")
//	public String afficherListProduitByCat(ModelMap model,@PathVariable("mProduit") Produit p){
//		Produit p_rec=(Produit) cSer.getAllProduitByCategories(p);
//		List<Produit> listeProduitsCat = new ArrayList<Produit>();
//		listeProduitsCat.add(p_rec);
//		model.addAttribute("pListe", listeProduitsCat);
//		return "afficherProduitCat";
//	}
	
	@RequestMapping(value = "/afficherProduitCat", method = RequestMethod.GET)
	public String supprimerProduit(ModelMap model, @RequestParam("categorieId") Long id) {

		Produit p=new Produit();
		Categorie c_rec=new Categorie();
		c_rec.setIdCategorie(id);
		Categorie c=cSer.consulter(c_rec);
		
		List<Produit> produitCat=cSer.getAllProduitByCategories(p);
		model.addAttribute("pListe",  produitCat);
		
		return "afficherProduitCat";

	}

	
	

	@RequestMapping(value="/rechercheParMot", method=RequestMethod.GET)
	public ModelAndView afficherFormRechercheParMot(){
		return new ModelAndView("rechercheParMot","mProduit", new Produit());
	}
	
	@RequestMapping(value="/rechercheParMot", method=RequestMethod.POST)
	public String rechercheParMot(ModelMap model, @ModelAttribute("mProduit") Produit p){

		Produit p_rec = cSer.getProduitByKeyWord(p);
		List<Produit> produitListe = new ArrayList<Produit>();
		produitListe.add(p_rec);
		model.addAttribute("listeProduitMot", produitListe);
		
		return "rechercheParMot";
		
	}
	
	@RequestMapping(value="/accueil", method=RequestMethod.GET)
	public ModelAndView afficherAccueil(){
		return new ModelAndView("accueil","mProduit", new Produit());
	
	}
}
