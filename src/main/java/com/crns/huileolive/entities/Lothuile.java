package com.crns.huileolive.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Lothuile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double quantiteObtenue;

    @Column
    private double tauxAcide;

    @Column
    private TypeHuile typeHuile;

    @Column
    private int nbciternes;

    @Column
    private String nomProducteur;

    @OneToOne
    @JoinColumn(name = "moulinage_id", referencedColumnName = "id")
    private Moulinage moulinage;
/*
    @OneToMany(mappedBy = "lothuile")
    private List<Citerne> citernes;

 */
}
