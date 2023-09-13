package com.crns.huileolive.managers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.crns.huileolive.dto.MoulinageDto;
import com.crns.huileolive.entities.Lotolive;
import com.crns.huileolive.entities.Moulinage;
import com.crns.huileolive.mapper.AppMapper;
import com.crns.huileolive.services.LotoliveService;
import com.crns.huileolive.services.MoulinageService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MoulinageManager {

	@Autowired
	private MoulinageService moulinageService;

	@Autowired
	private LotoliveService lotoliveService;

	@Autowired
	private AppMapper appMapper;

	public List<MoulinageDto> getMoulinages() {
		return appMapper.mapMoulinages(moulinageService.getMoulinages());
	}

	public MoulinageDto getMoulinage(@PathVariable Long id) {
		Moulinage moulinage = moulinageService.getMoulinageById(id)
				.orElseThrow(() -> new EntityNotFoundException("Moulinage non trouvé"));
		return appMapper.mapMoulinage(moulinage);
	}

	public MoulinageDto saveMoulinage(MoulinageDto dto) {
		Moulinage moulinage = Moulinage.builder().quantite(dto.getQuantite()).typeExtraction(dto.getTypeExtraction())
				.dateMoulinage(dto.getDateMoulinage()).moulin(appMapper.mapMoulin(dto.getMoulin())).build();
		List<Lotolive> lotOlives = lotoliveService.getLotoliveByIds(dto.getLotOlivesIds());
		moulinage.setLotolives(lotOlives);
		assignMoulinageToLotolive(moulinage, lotOlives);
		Moulinage savedMoulinage = moulinageService.save(moulinage);
		return appMapper.mapMoulinage(savedMoulinage);
	}

	private void assignMoulinageToLotolive(Moulinage moulinage, List<Lotolive> lotOlives) {
		lotOlives = lotOlives.stream().map(o -> {
			o.setMouline(true);
			o.setMoulinage(moulinage);
			return o;
		}).toList();
	}

	public ResponseEntity<?> updateMoulinageById(@RequestBody MoulinageDto dto, @PathVariable Long id) {
		if (moulinageService.existById(id)) {
			Moulinage existingMoulinage = moulinageService.getMoulinageById(id)
					.orElseThrow(() -> new EntityNotFoundException("Requête non trouvée"));

			// Update the properties of existingMoulinage with moulinage
			existingMoulinage.setTypeExtraction(dto.getTypeExtraction());
			existingMoulinage.setDateMoulinage(dto.getDateMoulinage());
			existingMoulinage.setQuantite(dto.getQuantite());
			existingMoulinage.setMoulin(appMapper.mapMoulin(dto.getMoulin()));
			// Update other properties as needed
			List<Lotolive> lotolives = existingMoulinage.getLotolives();
			unassignMoulinageToLotolive(lotolives);
			List<Lotolive> lotOlives = lotoliveService.getLotoliveByIds(dto.getLotOlivesIds());
			existingMoulinage.setLotolives(lotOlives);
			assignMoulinageToLotolive(existingMoulinage, lotOlives);
			moulinageService.save(existingMoulinage);

			return ResponseEntity.ok().body(existingMoulinage);
		} else

		{
			HashMap<String, String> message = new HashMap<>();
			message.put("message", id + " - Tâche non trouvée ou non valide");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}

	private void unassignMoulinageToLotolive(List<Lotolive> lotolives) {
		for (Lotolive o : lotolives) {
			o.setMoulinage(null);
			o.setMouline(false);
			lotoliveService.save(o);
		}
	}

	public ResponseEntity<?> deleteMoulinageById(@PathVariable Long id) {
		if (moulinageService.existById(id)) {
			Optional<Moulinage> moulinage = moulinageService.getMoulinageById(id);
			if (moulinage.isPresent()) {
				List<Lotolive> lotolives = moulinage.get().getLotolives();
				unassignMoulinageToLotolive(lotolives);
			}
			moulinageService.deleteMoulinage(id);
			HashMap<String, String> message = new HashMap<>();
			message.put("message", id + " - supprimé avec succès");
			return ResponseEntity.ok().body(message);
		} else {
			HashMap<String, String> message = new HashMap<>();
			message.put("message", id + " - Tâche non trouvée ou non valide");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
}
