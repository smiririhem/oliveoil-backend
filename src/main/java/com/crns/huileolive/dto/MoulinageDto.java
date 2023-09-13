package com.crns.huileolive.dto;

import java.util.Date;
import java.util.List;

import com.crns.huileolive.entities.Extraction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MoulinageDto {
	private Long id;
	private Extraction typeExtraction;
	private Date dateMoulinage;
	private double quantite;
	private MoulinDto moulin;
	private String variete;
	private List<LotoliveDto> lotOlives;
	private List<Long> lotOlivesIds;
}