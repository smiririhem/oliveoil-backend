package com.crns.huileolive.dto;

import java.util.Date;

import com.crns.huileolive.entities.Variete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LotoliveDto {
	private long id;
	private Date dateRecolte;
	private double quantite;
	private Variete variete;
	private Boolean mouline;
	private BergerDto berger;
}
