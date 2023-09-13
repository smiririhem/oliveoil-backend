package com.crns.huileolive.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Lotolive {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateRecolte;

	@Column(nullable = false)
	private double quantite;

	@Column(nullable = false)
	private Variete variete;

	@Column
	private Boolean mouline = false;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "berger_id")
	private Berger berger;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "moulinage_id")
	private Moulinage moulinage;

}
