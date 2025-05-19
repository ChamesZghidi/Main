package com.teckUP.demo.repository;

import com.teckUP.demo.models.Produit;
import com.teckUP.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository  extends JpaRepository <Produit , Integer> {

    Produit findByNom(String productname);


}
