package fr.adaming.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.IClientService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/setting")
public class AdminProdController {

	@Autowired
	private IProduitService produitService;

	@Autowired
	private IClientService cSer;

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	/**
	 * @param cSer
	 *            the cSer to set
	 */
	public void setcSer(IClientService cSer) {
		this.cSer = cSer;
	}

	@RequestMapping(value = "/afficherProduits", method = RequestMethod.GET)
	public ModelAndView afficherListProduit(ModelMap model) {
		List<Produit> listeProduit = produitService.consulterAll();
		model.addAttribute("listeProduit", listeProduit);
		return new ModelAndView("afficherProduits", "pProduit", new Produit());

	}

	@RequestMapping(value = "/rechercheParMotAdmin", method = RequestMethod.GET)
	public ModelAndView afficherFormRechercheParMot() {
		return new ModelAndView("rechercheParMotAdmin", "pProduit", new Produit());
	}

	@RequestMapping(value = "/rechercheParMotAdmin", method = RequestMethod.POST)
	public ModelAndView rechercheParMot(ModelMap model, @ModelAttribute("pProduit") Produit p) {

		Produit p_rec = cSer.getProduitByKeyWord(p);
		List<Produit> produitListe = new ArrayList<Produit>();
		produitListe.add(p_rec);
		model.addAttribute("listeProduitMot", produitListe);

		return new ModelAndView("rechercheParMotAdmin", "pProduit", p);

	}

	@RequestMapping(value = "/deleteProd", method = RequestMethod.GET)
	public ModelAndView supprimerProduit(ModelMap model, @RequestParam("idProduit") Long id) {

		Produit p_rec = new Produit();
		p_rec.setIdProduit(id);
		Produit p = produitService.consulter(p_rec);
		produitService.supprimer(p);

		List<Produit> listeProduit = produitService.consulterAll();
		model.addAttribute("listeProduit", listeProduit);
		return new ModelAndView("afficherProduits", "pProduit", p);

	}

	@RequestMapping(value = "/formulaireProduit", method = RequestMethod.GET)
	public ModelAndView afficherFormAjout() {
		return new ModelAndView("formulaireProduit", "pProduit", new Produit());
	}

	@RequestMapping(value = "/ajouterProduit", method = RequestMethod.POST)
	public ModelAndView ajouterProduit(@ModelAttribute("pProduit") Produit p, ModelMap model, MultipartFile file)
			throws Exception {

		if (file == null || !file.isEmpty()) {
			p.setPhoto(file.getBytes());
		}

		if (p.getIdProduit() == null) {
			produitService.ajouter(p);
		} else {
			produitService.modifier(p);
		}

		List<Produit> listeProduit = produitService.consulterAll();
		model.addAttribute("listeProduit", listeProduit);

		return new ModelAndView("afficherProduits", "pProduit", new Produit());
	}

	@RequestMapping(value = "/photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idProd) throws IOException {
		Produit p_rec = new Produit();
		p_rec.setIdProduit(idProd);
		Produit p = produitService.consulter(p_rec);
		if (p.getPhoto() == null) {
			return new byte[0];
		} else {
			return IOUtils.toByteArray(new ByteArrayInputStream(p.getPhoto()));
		}
	}

	@RequestMapping(value = "/modifierProduit", method = RequestMethod.GET)
	public ModelAndView afficherFormModif(ModelMap model, @RequestParam("idProduit") Long id) {

		Produit p_rec = new Produit();
		p_rec.setIdProduit(id);
		p_rec = produitService.consulter(p_rec);

		return new ModelAndView("formulaireProduit", "pProduit", p_rec);

	}

	@RequestMapping(value = "/rechercheProduit", method = RequestMethod.GET)
	public ModelAndView afficherFormRecherche() {
		return new ModelAndView("rechercheProduit", "pProduit", new Produit());
	}

	@RequestMapping(value = "/rechercheProduit", method = RequestMethod.POST)
	public String rechercheProduit(ModelMap model, @ModelAttribute("pProduit") Produit p) {

		Produit p_rec = produitService.consulter(p);
		List<Produit> listeProduit = new ArrayList<Produit>();
		listeProduit.add(p_rec);
		model.addAttribute("listeProduit", listeProduit);

		return "rechercheProduit";

	}

}
