package com.teckUP.demo.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Data
@Table(name = "user")
public class User {

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id ;
    @Column(name = "nom")
    private String nom ;
    @Column(name = "prenom")
    private String prenom ;
    @Column(name = "password")
    private  String password ;
    @Column(name = "numtel")
    private String numtel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }



    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "email" )
    private String email ;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Column(name = "photo")

    private String photo;

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }



    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Embedded
    private Adresse adresse ;


    public boolean isPresent() {
        return false ;

    }
}









