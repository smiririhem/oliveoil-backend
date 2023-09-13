package com.crns.huileolive.services;

import com.crns.huileolive.entities.Moulinage;
import com.crns.huileolive.repositories.MoulinageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MoulinageService {
	private final MoulinageRepository moulinageRepository;

	public List<Moulinage> getMoulinages() {
		return moulinageRepository.findAll();
	}

	public Optional<Moulinage> getMoulinageById(Long id) {
		return moulinageRepository.findById(id);
	}

	public Moulinage save(Moulinage moulinage) {
		return moulinageRepository.saveAndFlush(moulinage);
	}

	public boolean existById(Long id) {
		return moulinageRepository.existsById(id);
	}

	public void deleteMoulinage(Long id) {
		moulinageRepository.deleteMoulinageById(id);
	}
}
