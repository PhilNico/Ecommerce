package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String afficherListProduit(ModelMap model) {
		List<Categorie> listeCategorie = cSer.getAllCategories();
		model.addAttribute("listeCategorie", listeCategorie);
		return "afficherCategories";
	}

}
