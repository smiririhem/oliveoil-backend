package com.crns.huileolive.services;

import com.crns.huileolive.entities.Berger;
import com.crns.huileolive.repositories.BergerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BergerService {
    private final BergerRepository bergerRepository;

    public List<Berger> getBergers() {
        return bergerRepository.findAll();
    }

    public Optional<Berger> getBergerById(Long id) {
        return bergerRepository.findById(id);
    }

    public Berger save(Berger berger) {
        return bergerRepository.saveAndFlush(berger);
    }

    public boolean existById(Long id) {
        return bergerRepository.existsById(id);
    }

    public void deleteBerger(Long id) {
        bergerRepository.deleteById(id);
    }
}
