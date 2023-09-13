package com.crns.huileolive.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Moulinage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Extraction typeExtraction;

	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateMoulinage;

	@Column(nullable = false)
	private double quantite;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "moulin_id")
	private Moulin moulin;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "moulinage_solvant", joinColumns = @JoinColumn(name = "moulinage_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "solvant_id", referencedColumnName = "id"))
	private List<Solvant> solvants;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "moulinage")
	private List<Lotolive> lotolives;
	/*
	 * @OneToOne(mappedBy = "moulinage") private Lothuile lothuile;
	 * 
	 */
}
