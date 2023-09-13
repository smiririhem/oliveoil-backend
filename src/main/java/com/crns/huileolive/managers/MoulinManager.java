package com.crns.huileolive.managers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.crns.huileolive.dto.MoulinDto;
import com.crns.huileolive.entities.Moulin;
import com.crns.huileolive.mapper.AppMapper;
import com.crns.huileolive.services.MoulinService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MoulinManager {

	@Autowired
	private MoulinService moulinService;

	@Autowired
	private AppMapper appMapper;

	public List<MoulinDto> getMoulins() {
		return appMapper.mapMoulin(moulinService.getMoulin());
	}

	public MoulinDto getMoulin(@PathVariable Long id) {
		Moulin moulin = moulinService.getMoulinById(id)
				.orElseThrow(() -> new EntityNotFoundException("Moulin non trouvé"));
		return appMapper.mapMoulin(moulin);
	}

	public Moulin addMoulin(@RequestBody Moulin moulin) {
		return moulinService.save(moulin);
	}

	public MoulinDto updateMoulin(MoulinDto dto, @PathVariable Long id) {
		Moulin existingMoulin = moulinService.getMoulinById(id)
				.orElseThrow(() -> new EntityNotFoundException("Moulin non trouvé"));

		// Update the properties of existingMoulin with moulin
		existingMoulin.setNom(dto.getNom());
		existingMoulin.setDetails(dto.getDetails());
		// Update other properties as needed

		existingMoulin = moulinService.save(existingMoulin);

		return appMapper.mapMoulin(existingMoulin);
	}

	public ResponseEntity<?> deleteMoulin(@PathVariable Long id) {
		if (moulinService.existById(id)) {
			moulinService.deleteMoulin(id);
			HashMap<String, String> message = new HashMap<>();
			message.put("message", id + " - supprimé avec succès");
			return ResponseEntity.ok().body(message);
		} else {
			HashMap<String, String> message = new HashMap<>();
			message.put("message", id + " - Moulin non trouvé ou non valide");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
}
