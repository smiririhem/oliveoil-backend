package com.crns.huileolive.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String emplacement;

    @Column
    private String codeQr;

    @Column
    private TypeRecipient typeRecipient;

    @ManyToOne
    @JoinColumn(name="citerne_id")
    private Citerne citerne;
}
