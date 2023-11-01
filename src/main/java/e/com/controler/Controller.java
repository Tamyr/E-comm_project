package e.com.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import e.com.entity.Categorie;
import e.com.entity.Produit;
import e.com.metier.CategorieService;
import e.com.metier.ProduitService;
import e.com.repo.CategorieRepository;
import jakarta.validation.Valid;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private ProduitService produitService;
	@Autowired
	private CategorieRepository categorieRepository;
	
	
	
	// view home page
	@GetMapping("/home")
	public String showHome()
	{
		return "/home";		
	}
	
	// redirect home page
	@GetMapping("/")
	public String redirect_HomePage()
	{
		return "redirect:/home";		
	}
	
	
	// view listProduit page
	@GetMapping("/listProduit")
	public String showHomeView(Model model,@RequestParam(name = "mc", defaultValue = "")String mc)
	{
		List<Produit> list = produitService.getAllProduits(mc+"%");
		model.addAttribute("listProduit", list);
		return "/listProduit";
	}
	
	// view ListCategorie page
	@GetMapping("/listCategorie")
	public String showListCategorieView(Model model)
	{
		model.addAttribute("listCategorie", categorieService.getAllCategories());
		return "/listCategorie";
	}
	
	// view formCategorie page
	@GetMapping("/formCategorie")
	public String showformCategorie(Model model) {
		Categorie cat = new Categorie();
		model.addAttribute("categorie", cat);
		return "/formCategorie";
	}
	
	
	// action add Categorie
	@PostMapping("/saveCategorie")
	public String save_Categorie(@Valid Categorie categorie)
	{
		categorieService.saveCategorie(categorie);
		return "redirect:/listCategorie";
	}
	
	
	// view formEditCategorie page
	@GetMapping("/formEditCategorie/{id}")
	public String showEditCategorieForm(Model model,@PathVariable(value="id") Long id)
	{
		Categorie categorie = categorieService.getCategorieById(id);
		model.addAttribute("categorie", categorie);
		return "formEditCategorie";
	}
	
	
	// action update Categorie
	@PostMapping("/updateCategorie")
	public String update_Categorie(Model model,@Valid Categorie categorie)
	{	
			//if (bindingResult.hasErrors()) return "/formCategorie";
		Categorie cat = categorieService.updateCategorie(categorie);
		model.addAttribute("listCategorie", cat);
		return "redirect:/listCategorie";
	}	
	
	// delete categorie from list categorie
	@GetMapping("/deleteCategorie")
	public String deleteCategorie(Long id) {
		
		categorieService.deleteCategorie(id);
		return "redirect:/listCategorie";
	}
	
	
	
	// view formProduit page
	@GetMapping("/formProduit")
	public String showformProduit(Model model) {
		List<Categorie> listCat = categorieRepository.findAll();
		Produit prod = new Produit();
		model.addAttribute("produit", prod);
		model.addAttribute("listCategories", listCat);
		return "/formProduit";
	}
	
	
	// action add Categorie
	@PostMapping("/saveProduit")
	public String save_Produit(@Valid Produit produit) {
			
		//if (bindingResult.hasErrors()) return "/formCategorie";
			
		produitService.saveProduit(produit);
		
		return "redirect:/listProduit";
	}
		
	
	// delete categorie from list categorie
	@GetMapping("/deleteProduit")
	public String deleteProduit(Long id)
	{
			produitService.deleteProduit(id);
			return "redirect:/listProduit";
	}

}
