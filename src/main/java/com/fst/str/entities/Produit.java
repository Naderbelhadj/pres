package com.fst.str.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
@ManyToOne
private Ctegory category;
	public Ctegory getCategory() {
	return category;
}
public Produit(Ctegory category, String name, String description, double prix) {
		super();
		this.category = category;
		this.name = name;
		this.description = description;
		this.prix = prix;
	}
public void setCategory(Ctegory category) {
	this.category = category;
}
	private String name;
	private String description;
	private double prix;
	public Produit() {
		super();
	}
	public Produit(String name, String description, double prix) {
		super();
		this.name = name;
		this.description = description;
		this.prix = prix;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

}
