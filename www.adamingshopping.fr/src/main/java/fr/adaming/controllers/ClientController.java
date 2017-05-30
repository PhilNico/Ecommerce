package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.model.User;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;
import fr.adaming.service.IUserService;

@Controller
@RequestMapping("/client")
// @SessionAttributes("panier")
public class ClientController {

	@Autowired
	private IClientService cSer;

	@Autowired
	private ICategorieService categorieService;
	
	@Autowired
	private IUserService userService;
	
	

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	/**
	 * @param cSer
	 *            the cSer to set
	 */
	public void setcSer(IClientService cSer) {
		this.cSer = cSer;
	}

	@Autowired
	private ILigneCommandeService ligneCommandeService;

	@Autowired
	private IPanierService panierService;

	@Autowired
	private IProduitService produitService;

	@Autowired
	private HttpSession session;

	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	public void setPanierService(IPanierService panierService) {
		this.panierService = panierService;
	}

	@RequestMapping(value = "/photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhotoProd(Long idProd) throws IOException {
		Produit p_rec = new Produit();
		p_rec.setIdProduit(idProd);
		Produit p = produitService.consulter(p_rec);
		if (p.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
		}
	}

	@RequestMapping(value = "/afficherProduitClient", method = RequestMethod.GET)
	public ModelAndView afficherListProduit(ModelMap model) {
		List<Produit> listeProduit = produitService.consulterAll();
		model.addAttribute("listeProduit", listeProduit);
		return new ModelAndView("afficherProduitClient", "pProduit", new Produit());

	}

	@RequestMapping(value = "/afficherCategories", method = RequestMethod.GET)
	public ModelAndView afficherListCategorie(ModelMap model) {
		List<Categorie> listeCategorie = categorieService.consulterAll();
		model.addAttribute("listeCategorie", listeCategorie);
		return new ModelAndView("afficherCategories", "pProduit", new Produit());

	}

	@RequestMapping(value = "/photoCat", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idCat) throws IOException {
		Categorie cat = categorieService.consulter(idCat);
		if (cat.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(cat.getPhoto()));
		}
	}

	@RequestMapping(value = "/afficherProduitCat", method = RequestMethod.GET)
	public ModelAndView supprimerProduit(ModelMap model, @RequestParam("categorieId") Long id) {

		model.addAttribute("categorie", cSer.getAllCategories());
		model.addAttribute("produit", cSer.getAllProduitByCategories(id));

		List<Produit> produitCat = cSer.getAllProduitByCategories(id);
		model.addAttribute("pListe", produitCat);

		return new ModelAndView("afficherProduitCat", "pProduit", new Produit());

	}

	@RequestMapping(value = "/rechercheParMot", method = RequestMethod.GET)
	public ModelAndView afficherFormRechercheParMot() {
		return new ModelAndView("rechercheParMot", "pProduit", new Produit());
	}

	@RequestMapping(value = "/rechercheParMot", method = RequestMethod.POST)
	public ModelAndView rechercheParMot(ModelMap model, @ModelAttribute("pProduit") Produit p) {

		Produit p_rec = cSer.getProduitByKeyWord(p);
		List<Produit> produitListe = new ArrayList<Produit>();
		produitListe.add(p_rec);
		model.addAttribute("listeProduitMot", produitListe);

		return new ModelAndView("rechercheParMot", "pProduit", p);

	}

	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public ModelAndView afficherAccueil(ModelMap model) {

		if (session.getAttribute("panier") == null) {

			Panier panier = new Panier();

			List<LigneCommande> listeLignesCommande = new ArrayList<LigneCommande>();
			panier.setListeLignesCommande(listeLignesCommande);
			session.setAttribute("panier", panier);

		} else {

			Panier panier = (Panier) session.getAttribute("panier");

			session.setAttribute("panier", panier);
		}
		List<Categorie> listeCategorie = cSer.getAllCategories();
		model.addAttribute("listeCategorie", listeCategorie);

		return new ModelAndView("accueil", "pProduit", new Produit());

	}

	@RequestMapping(value = "/panier", method = RequestMethod.GET)
	public ModelAndView afficherFormPanier(ModelMap model) {

		Panier panier = (Panier) session.getAttribute("panier");
		List<LigneCommande> listeCommande = new ArrayList<LigneCommande>();
		listeCommande = panier.getListeLignesCommande();

		model.addAttribute("listeCommande", listeCommande);
		return new ModelAndView("panier", "pProduit", new Produit());
	}

	@RequestMapping(value = "/formulaireAjout", method = RequestMethod.GET)
	public ModelAndView formulaireAjoutPanier(ModelMap model, @RequestParam("idProduit") Long id) {
		Produit p = new Produit();
		p.setIdProduit(id);
		produitService.consulter(p);

		return new ModelAndView("formulaireAjoutPanier", "pProduit", p);
	}

	@RequestMapping(value = "ajouterAuPanier", method = RequestMethod.POST)
	public String ajouterAuPanier(ModelMap model, @ModelAttribute("pProduit") Produit p) {

		Panier panier = (Panier) session.getAttribute("panier");

		int quantite = p.getQuantite();

		p = produitService.consulter(p);

		panierService.ajouterAuPanier(p, quantite, panier);

		session.setAttribute("panier", panier);

		model.addAttribute("listeCategorie", categorieService.consulterAll());

		return "accueil";

	}

	@RequestMapping(value = "/deletePanier", method = RequestMethod.GET)
	public ModelAndView supprimerLignePanier(ModelMap model, @RequestParam("index") int index) {

		Panier panier = (Panier) session.getAttribute("panier");

		List<LigneCommande> listeCommande = panier.getListeLignesCommande();

		listeCommande.remove(index);

		panier.setListeLignesCommande(listeCommande);
		session.setAttribute("panier", panier);

		model.addAttribute("listeCommande", listeCommande);

		return new ModelAndView("panier", "pProduit", new Produit());
	}
	
	public ModelAndView validerPanier(){
		
	}

	
	@RequestMapping(value ="/afficherFormClient", method= RequestMethod.GET)
	public ModelAndView afficherFormClient(){
		return new ModelAndView("formulaireClient", "uUser", new User());
	}
	
	
	@RequestMapping(value="ajouterClient", method= RequestMethod.POST)
	public ModelAndView ajouterClient(ModelMap model ,@ModelAttribute("uUser") User u){
		userService.ajouterUser(u);
		
		Panier panier = (Panier) session.getAttribute("panier");
		List<LigneCommande> listeCommande = panier.getListeLignesCommande();
		model.addAttribute("listeCommande", listeCommande);

		return new ModelAndView("panier", "pProduit", new Produit());
	}
	
	
	

}
