package com.teckUP.demo.controllers;


import com.teckUP.demo.models.Produit;
import com.teckUP.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/produit")
public class ProduitController {
    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitController(ProduitRepository produitRepository) {

        this.produitRepository = produitRepository;
    }
@PostMapping(path = "/add")
    @ResponseBody
    Produit addnewproduit(@RequestParam String nom, @RequestParam Double prix, @RequestParam String description, @RequestParam int quantite) {

    Produit springproduit = new Produit();
    springproduit.setNom(nom);
    springproduit.setPrix(prix);
    springproduit.setDescription(description);
    springproduit.setQuantite(quantite);

    produitRepository.save(springproduit);
    return springproduit ;


}
@GetMapping(path = "/all")
    public @ResponseBody Iterable<Produit> getAllproduit(){
        return produitRepository.findAll();


}
@DeleteMapping(path = "/delete")
    @ResponseBody
    public ResponseEntity<String> deleteproduit(@RequestParam Integer idp){
        if(produitRepository.existsById(idp)){
            produitRepository.deleteById(idp);
            return ResponseEntity.ok("produit with " + idp + "has been deleted");

        }
        return null;
}

@PutMapping(path = "/update")
    @ResponseBody
    public ResponseEntity<String> updateproduit(
            @RequestParam Integer idp,
            @RequestParam(required = false) int quantite ,
            @RequestParam(required = false) Double prix ){
        Optional<Produit> optionalProduit = produitRepository.findById(idp);
        if(!optionalProduit.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produit not found with id"  + idp );

        }


        Produit produit = optionalProduit.get();
        if (quantite != 0) produit.setQuantite(quantite);
        if (prix != null) produit.setPrix(prix);
        produitRepository.save(produit);
        return ResponseEntity.ok("produit with id " + idp + "has been updated");


}










}
