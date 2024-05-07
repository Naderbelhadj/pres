package com.fst.str.entities;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity

public class Ctegory {


public Ctegory(String nom, List<Produit> produits) {
		super();
		this.nom = nom;
		this.produits = produits;
	}
public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

@Id
@GeneratedValue(strategy = GenerationType.AUTO) 
private long id;
private String nom;
@OneToMany
List<Produit> produits;

public Ctegory(String nom) {
	super();
	this.nom = nom;
}
public List<Produit> getProduits() {
	return produits;
}
public void setProduits(List<Produit> produits) {
	this.produits = produits;
}

public Ctegory() {
	super();
}

}
