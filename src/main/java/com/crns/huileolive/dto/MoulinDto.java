package com.crns.huileolive.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MoulinDto {

	private long id;
	private String nom;
	private String details;
	@JsonBackReference
	private List<MoulinageDto> moulinages;
}