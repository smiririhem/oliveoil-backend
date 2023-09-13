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

import com.crns.huileolive.dto.MoulinageDto;
import com.crns.huileolive.managers.MoulinageManager;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class MoulinageController {

	@Autowired
	private MoulinageManager moulinageManager;

	@GetMapping("/moulinages")
	public List<MoulinageDto> getMoulinages() {
		return moulinageManager.getMoulinages();
	}

	@GetMapping("/moulinages/{id}")
	public ResponseEntity<MoulinageDto> getMoulinage(@PathVariable Long id) {
		return ResponseEntity.ok().body(moulinageManager.getMoulinage(id));
	}

	@PostMapping("/moulinages")
	public MoulinageDto addMoulinage(@RequestBody MoulinageDto moulinage) {
		return moulinageManager.saveMoulinage(moulinage);
	}

	@PutMapping("/moulinages/{id}")
	public ResponseEntity<?> updateMoulinage(@RequestBody MoulinageDto moulinage, @PathVariable Long id) {
		return moulinageManager.updateMoulinageById(moulinage, id);
	}

	@DeleteMapping("/moulinages/{id}")
	public ResponseEntity<?> deleteMoulinage(@PathVariable Long id) {
		return moulinageManager.deleteMoulinageById(id);
	}

}
