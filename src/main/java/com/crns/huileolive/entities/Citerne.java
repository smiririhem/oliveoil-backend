package com.crns.huileolive.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Citerne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String emplacement;

    @Column
    private double capaciteReelle;

    @Column
    private TypeCiterne typeCiterne;

    @Column
    private String codeQr;

    @ManyToOne
    @JoinColumn(name="lothuile_id")
    private Lothuile lothuile;
/*
    @OneToMany(mappedBy = "citerne")
    private List<Recipient> recipients;

 */
}
