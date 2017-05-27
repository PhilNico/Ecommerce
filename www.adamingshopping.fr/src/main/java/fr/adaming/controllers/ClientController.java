package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.IClientService;

@Controller
@RequestMapping("/client")
@SessionAttributes("panier")
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

	
	@RequestMapping(value = "/afficherProduitCat", method = RequestMethod.GET)
	public String supprimerProduit(ModelMap model, @RequestParam("categorieId") Long id) {

//		Produit p=new Produit();
//		Categorie c_rec=new Categorie();
//		c_rec.setIdCategorie(id);
//		Categorie c=cSer.consulter(c_rec);
//		
//		List<Produit> produitCat=cSer.getAllProduitByCategories(id);
//		model.addAttribute("pListe",  produitCat);
		
		model.addAttribute("categorie", cSer.getAllCategories());
		model.addAttribute("produit", cSer.getAllProduitByCategories(id));
		
		List<Produit> produitCat=cSer.getAllProduitByCategories(id);
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
	
//	@RequestMapping("/panier")
//	public String panier(Model model){
//		if(model.asMap().get("panier")==null){
//			model.addAttribute("panier", new Panier());
//		}
//	model.addAttribute("categorie", cSer.getAllCategories());
//	model.addAttribute("produit", cSer.getProduitSelect());
//	return "accueil";
//	}
//	
//	public String produitPanier(@RequestParam Long idCategorie, Model model, Produit p){
//		model.addAttribute("categorie", cSer.getAllCategories());
//		model.addAttribute("produit", cSer.getAllProduitByCategories(idCategorie));
//		return "accueil";
//	}
}
