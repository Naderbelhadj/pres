package com.fst.str.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fst.str.entities.Ctegory;
import com.fst.str.entities.Produit;
import com.fst.str.reposetories.CategoryRepository;
import com.fst.str.reposetories.ProduitRrepository;

@Controller
@RequestMapping("produit")
public class ProduitController {
	 //Produit produit=new Produit(1,"Refrigrateur Samsung RT50","Equipement electro menagers",2890.0);
	//Best practice to use the Autowired l'injection d'impedance
	private final ProduitRrepository produitRepository;
	private final CategoryRepository categoryRepository;
	@Autowired
	public ProduitController(ProduitRrepository produitRepository, CategoryRepository categoryRepository)
	{
		this.produitRepository=produitRepository;
		this.categoryRepository=categoryRepository;
	}

	@GetMapping("afficher" )
	public String afficher(Model model) {
	//	List<Produit> produits= new ArrayList<>();
		model.addAttribute("produits", produitRepository.findAll());
		//model.addAttribute("categories", categoryRepository.findAll());
	return "afficher.html";
	}
	@GetMapping("ajouter")
	public String add(Model model)
	{
		model.addAttribute("categories", categoryRepository.findAll());
		return "add.html";
		}
/*	@PostMapping("ajouter")
public String ajouter(	Produit produit, @RequestParam("categoryId") Long id,@RequestParam("nom") String nom, @RequestParam("description") String description,
			@RequestParam("price") double price) {
	//	Ctegory c = categoryRepository.getById(id);
produit.setName(nom);
produit.setDescription(description);
produit.setPrix(price);
        produit.setCategory(c);
	//Produit p=new Produit(nom,description,price);
	
//List<Produit>produits;
//Produit p1=produitRepository.save(p);
	//Produit p1=new Produit(nom,description,price);
	produitRepository.save(produit);
	return  "redirect:afficher";
	}*/ 
	@PostMapping("ajouter")
	public String add(Produit produit,@RequestParam("nom") String nom, @RequestParam("price") double price,
			@RequestParam("description") String description, @RequestParam("categoryId") long id)
	{  
		
		Ctegory category = categoryRepository.getById(id);
		produit.setName(nom);
		produit.setDescription(description);
		produit.setPrix(price);
		produit.setCategory(category);
		produitRepository.save(produit);
		return "redirect:afficher";
	}
	@GetMapping("delete/{id}")
	public String supprimer(@PathVariable("id") long id)
	{
		produitRepository.deleteById(id);
		return "redirect:../afficher";
	}
	@GetMapping("modifier/{id}")
	public String modifier(@PathVariable("id") long id, Model model)
	{
	Produit produit= produitRepository.getById(id);
	List<Ctegory> categories = categoryRepository.findAll();
		model.addAttribute("produit",produit);
		model.addAttribute("categories",categories);
		return "modifier";
	}
	@PostMapping("modifier")
	public String update (Produit produit,Ctegory category)
	{
		produitRepository.save(produit);
		return "redirect:afficher";  
		
		
	}
	
	}
