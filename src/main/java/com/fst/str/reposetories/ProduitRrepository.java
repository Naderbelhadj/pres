package com.fst.str.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fst.str.entities.Produit;
@Repository
public interface ProduitRrepository extends JpaRepository<Produit,Long> {


}
