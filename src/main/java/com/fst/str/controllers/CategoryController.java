package com.fst.str.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fst.str.entities.Ctegory;
import com.fst.str.entities.Produit;
import com.fst.str.reposetories.CategoryRepository;

@Controller
@RequestMapping("category")
public class CategoryController {
	private final CategoryRepository categoryRepository;
	@Autowired
	public CategoryController(CategoryRepository categoryRepository)
	{
		this.categoryRepository=categoryRepository;
	}
	@GetMapping("afficher" )
	public String afficher(Model model) {
	//	List<Produit> produits= new ArrayList<>();
		model.addAttribute("categories", categoryRepository.findAll());

	return "afficherC.html";
	}
	@GetMapping("ajouter")
	public String add()
	{
	
		return "ajouterC.html";
		}
	@PostMapping("ajouter")
	public String ajouter(	@RequestParam("nom")String nom) {

	//Produit p=new Produit(nom,description,price);
//List<Produit>produits;
//Produit p1=produitRepository.save(p);
	Ctegory c1=new Ctegory(nom);
	categoryRepository.save(c1);
	return  "redirect:afficher";
	}
	
	
}
