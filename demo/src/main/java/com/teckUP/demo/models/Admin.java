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
@Table(name = "admin")
public class Admin {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ida")
    private Integer ida ;
    @Column(name = "nom")
    private String nom ;
    @Column(name = "email")
    private String email ;
    @Column(name = "password")
    private  String password ;


    public Integer getId() {
        return ida;
    }

    public void setId(Integer id) {
        this.ida = ida;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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





    public boolean isPresent() {
        return false ;

    }
}









