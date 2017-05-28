package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Produit;

@Controller
public class LoginController {

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String affichePageLogin(){
		return "loginPage";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logoutMethode(){
		return new ModelAndView("accueil","mProduit", new Produit());
	}
	
	
	@RequestMapping(value="/denied",method=RequestMethod.GET)
	public String deniedMethode(){
		return "denied";
	}
	
	@RequestMapping(value="/loginEchec",method=RequestMethod.GET)
	public String echecLogin(ModelMap model){
		model.addAttribute("erreur", "true");
		return "loginPage";
	}

}
