package com.crns.huileolive.services;

import com.crns.huileolive.entities.Moulin;
import com.crns.huileolive.repositories.MoulinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MoulinService {
    private final MoulinRepository moulinRepository;

    public List<Moulin> getMoulin() {
        return moulinRepository.findAll();
    }

    public Optional<Moulin> getMoulinById(Long id) {
        return moulinRepository.findById(id);
    }

    public Moulin save(Moulin moulin) {
        return moulinRepository.saveAndFlush(moulin);
    }

    public boolean existById(Long id) {
        return moulinRepository.existsById(id);
    }

    public void deleteMoulin(Long id) {
        moulinRepository.deleteById(id);
    }
}
