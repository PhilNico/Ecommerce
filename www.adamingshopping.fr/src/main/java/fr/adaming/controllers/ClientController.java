package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import fr.adaming.model.Commande;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.IClientService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/client")
//@SessionAttributes("panier")
public class ClientController {

	@Autowired
	private IClientService cSer;
	
	@Autowired
	private IClientService cSer;

	/**
	 * @param cSer
	 *            the cSer to set
	 */
	public void setcSer(IClientService cSer) {
		this.cSer = cSer;
	}
	
	
	
	@Autowired
	private IPanierService panierService;
	
	@Autowired
	private IProduitService produitService;
	
	@Autowired
	private HttpSession session;
	
	
	

	public void setSession(HttpSession session) {
		this.session = session;
	}


	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}


	public void setPanierService(IPanierService panierService) {
		this.panierService = panierService;
	}


	@RequestMapping(value = "/afficherProduitClient", method = RequestMethod.GET)
	public ModelAndView afficherListProduit(ModelMap model) {
		List<Produit> listeProduit = produitService.consulterAll();
		model.addAttribute("listeProduit", listeProduit);
		return new ModelAndView("afficherProduitClient","pProduit", new Produit());

	}
	
	@RequestMapping(value = "/afficherCategories", method = RequestMethod.GET)
	public ModelAndView afficherListCategorie(ModelMap model) {
		List<Categorie> listeCategorie = cSer.getAllCategories();
		model.addAttribute("listeCategorie", listeCategorie);
		return new ModelAndView("afficherCategories","pProduit", new Produit());
	
	}

	
	@RequestMapping(value = "/afficherProduitCat", method = RequestMethod.GET)
	public ModelAndView supprimerProduit(ModelMap model, @RequestParam("categorieId") Long id) {


		
		model.addAttribute("categorie", cSer.getAllCategories());
		model.addAttribute("produit", cSer.getAllProduitByCategories(id));
		
		List<Produit> produitCat=cSer.getAllProduitByCategories(id);
		model.addAttribute("pListe",  produitCat);
		
		return new ModelAndView("afficherProduitCat","pProduit", new Produit());

	}


	@RequestMapping(value="/rechercheParMot", method=RequestMethod.GET)
	public ModelAndView afficherFormRechercheParMot(){
		return new ModelAndView("rechercheParMot","pProduit", new Produit());
	}
	
	
	@RequestMapping(value="/rechercheParMot", method=RequestMethod.POST)
	public ModelAndView rechercheParMot(ModelMap model, @ModelAttribute("pProduit") Produit p){

		Produit p_rec = cSer.getProduitByKeyWord(p);
		List<Produit> produitListe = new ArrayList<Produit>();
		produitListe.add(p_rec);
		model.addAttribute("listeProduitMot", produitListe);
		
		return new ModelAndView("rechercheParMot", "pProduit", p);
		
	}
	
	@RequestMapping(value="/accueil", method=RequestMethod.GET)
	public ModelAndView afficherAccueil(ModelMap model){
		
		
		if(session.getAttribute("panier")==null){
		Panier panier = new Panier();		
		session.setAttribute("panier", panier);
		
		}else{
			
			Panier panier = (Panier) session.getAttribute("panier");
	
			session.setAttribute("panier", panier);
		}
		List<Categorie> listeCategorie = cSer.getAllCategories();
		model.addAttribute("listeCategorie", listeCategorie);	
		
		
		return new ModelAndView("accueil","pProduit", new Produit());
	
	}
	
	
	@RequestMapping(value="/panier", method=RequestMethod.GET)
	public ModelAndView afficherFormPanier(ModelMap model){
		
		
		Panier panier = (Panier) session.getAttribute("panier");
		List<LigneCommande> listeCommande = new ArrayList<LigneCommande>();
		listeCommande=panier.getListeLignesCommande();
		
		model.addAttribute("listeCommande", listeCommande);
		return new ModelAndView("panier","pProduit", new Produit());
	}
	
	@RequestMapping(value="/formulaireAjout", method=RequestMethod.GET)
	public ModelAndView formulaireAjoutPanier(ModelMap model, @RequestParam("idProduit") Long id){
		Produit p = new Produit();
		p.setIdProduit(id);
		produitService.consulter(p);
		return new ModelAndView("formulaireAjoutPanier", "pProduit", p);
	}
	
	
	@RequestMapping(value="ajouterAuPanier", method=RequestMethod.POST)
	public String ajouterAuPanier(@ModelAttribute("pProduit") Produit p){
		
		Panier panier =(Panier) session.getAttribute("panier");
		
		int quantite = p.getQuantite();
		
		p=produitService.consulter(p);
		
		panierService.ajouterAuPanier(p, quantite, panier);
		
		session.setAttribute("panier", panier);
		
		return "accueil";
		
	}

}//
