package com.teckUP.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Adresse {


    @Column(name = "pays")
    private  String pays ;

    @Column(name = "ville")
    private  String ville;

    @Column(name = "code_postale")
    private String code_postale ;


}
