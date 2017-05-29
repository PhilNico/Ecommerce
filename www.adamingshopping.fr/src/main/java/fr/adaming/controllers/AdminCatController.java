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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/settingCat")
public class AdminCatController {

	@Autowired
	private ICategorieService categorieService;

	@Autowired
	private IProduitService produitService;

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	@RequestMapping(value = "/afficherCategorieAdmin", method = RequestMethod.GET)
	public String afficherCategorie(ModelMap model) {
		List<Categorie> listeCategorie = categorieService.consulterAll();
		model.addAttribute("listeCategorie", listeCategorie);
		return "afficherCategorieAdmin";
	}

//	@RequestMapping(value = "/afficherProduits", method = RequestMethod.GET)
//	public ModelAndView afficherListProduit(ModelMap model) {
//		List<Produit> listeProduit = produitService.consulterAll();
//		model.addAttribute("listeProduit", listeProduit);
//		return new ModelAndView("afficherProduits", "pProduit", new Produit());
//
//	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String supprimerCategorie(ModelMap model, @RequestParam("idCategorie") Long id) {

		Categorie c = categorieService.consulter(id);
		categorieService.supprimer(c);

		List<Categorie> listeCategorie = categorieService.consulterAll();
		model.addAttribute("listeCategorie", listeCategorie);

		return "afficherCategorieAdmin";
	}

	@RequestMapping(value = "/formulaireCategorie", method = RequestMethod.GET)
	public ModelAndView afficherFormCat() {
		return new ModelAndView("formulaireCategorie", "cCategorie", new Categorie());
	}

	@RequestMapping(value = "/ajouterCategorie", method = RequestMethod.POST)
	public ModelAndView ajouterCategorie(@ModelAttribute("cCategorie") Categorie c, ModelMap model, MultipartFile file) throws Exception {
		
		if (file==null || !file.isEmpty()) {
			c.setPhoto(file.getBytes());
			System.out.println("------------------------------"+file);
		}
		if (c.getIdCategorie() == null) {

			categorieService.ajouter(c);
		} else {
			categorieService.modifier(c);

		}

		model.addAttribute("listeCategorie", categorieService.consulterAll());

		return new ModelAndView("afficherCategorieAdmin", "pProduit", new Produit());
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

	@RequestMapping(value = "/modifier", method = RequestMethod.GET)
	public ModelAndView afficherFormModif(ModelMap model, @RequestParam("idCategorie") Long id) {

		Categorie c_rec = categorieService.consulter(id);
		return new ModelAndView("formulaireCategorie", "cCategorie", c_rec);

	}

	@RequestMapping(value = "/rechercherCategorie", method = RequestMethod.GET)
	public ModelAndView afficherFormRecherchecat() {
		return new ModelAndView("rechercherCategorie", "cCategorie", new Categorie());
	}

	@RequestMapping(value = "/rechercherCategorie", method = RequestMethod.POST)
	public String rechercherCat(ModelMap model, @ModelAttribute("cCategorie") Categorie c) {

		List<Categorie> listeCategorie = new ArrayList<Categorie>();

		listeCategorie.add(categorieService.consulter(c.getIdCategorie()));

		model.addAttribute("listeCategorie", listeCategorie);

		return "rechercherCategorie";

	}

}
