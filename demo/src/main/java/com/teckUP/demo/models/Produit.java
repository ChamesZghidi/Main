package com.teckUP.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Data
@Table(name = "produit")
public class Produit {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idp")
    private Integer idp ;



    @Column(name = "nom")
    private String nom ;




    @Column(name = "prix")
    private Double prix ;




    @Column(name = "quantite")
    private int quantite;


    @Column(name = "description")
    private  String description  ;



    public Integer getId() {
        return idp;
    }

    public void setId(Integer idp) {
        this.idp = idp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
