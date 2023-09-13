package com.crns.huileolive.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Berger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nom;

	@Column
	private String details;
	/*
	 * @OneToMany(mappedBy = "berger") private List<Lotolive> lotolives;
	 */
}
