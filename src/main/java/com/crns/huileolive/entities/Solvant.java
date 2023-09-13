package com.crns.huileolive.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Solvant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private TypeSolvant typeSolvant;

    @Column
    private Double mesure;
/*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "moulinage_solvant",
            joinColumns = @JoinColumn(name = "moulinage_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "solvant_id",
                    referencedColumnName = "id"))
    private List<Moulinage> moulinages;

 */
}
