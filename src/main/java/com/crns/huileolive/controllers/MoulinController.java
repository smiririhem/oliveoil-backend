package com.crns.huileolive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crns.huileolive.dto.MoulinDto;
import com.crns.huileolive.entities.Moulin;
import com.crns.huileolive.managers.MoulinManager;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class MoulinController {

	@Autowired
	private MoulinManager moulinManager;

	@GetMapping("/moulins")
	public List<MoulinDto> getMoulins() {
		return moulinManager.getMoulins();
	}

	@GetMapping("/moulins/{id}")
	public ResponseEntity<MoulinDto> getMoulin(@PathVariable Long id) {
		return ResponseEntity.ok().body(moulinManager.getMoulin(id));
	}

	@PostMapping("/moulins")
	public Moulin addMoulin(@RequestBody Moulin moulin) {
		return moulinManager.addMoulin(moulin);
	}

	@PutMapping("/moulins/{id}")
	public MoulinDto updateMoulin(@RequestBody MoulinDto moulin, @PathVariable Long id) {
		return moulinManager.updateMoulin(moulin, id);
	}

	@DeleteMapping("/moulins/{id}")
	public ResponseEntity<?> deleteMoulin(@PathVariable Long id) {
		return moulinManager.deleteMoulin(id);
	}
}
