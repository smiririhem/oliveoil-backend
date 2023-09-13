package com.crns.huileolive.services;

import com.crns.huileolive.entities.Solvant;
import com.crns.huileolive.repositories.SolvantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SolvantService {
    private final SolvantRepository solvantRepository;

    public List<Solvant> getSolvants() {
        return solvantRepository.findAll();
    }

    public Optional<Solvant> getSolvantById(Long id) {
        return solvantRepository.findById(id);
    }

    public Solvant save(Solvant solvant) {
        return solvantRepository.saveAndFlush(solvant);
    }

    public boolean existById(Long id) {
        return solvantRepository.existsById(id);
    }

    public void deleteSolvant(Long id) {
        solvantRepository.deleteById(id);
    }
}
