package com.crns.huileolive.services;

import com.crns.huileolive.entities.Lotolive;
import com.crns.huileolive.repositories.LotoliveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LotoliveService {
    private final LotoliveRepository lotoliveRepository;

    public List<Lotolive> getLotolives() {
        return lotoliveRepository.findAll();
    }

    public Optional<Lotolive> getLotoliveById(Long id) {
        return lotoliveRepository.findById(id);
    }
    
    public List<Lotolive> getLotoliveByIds(List<Long> ids) {
        return lotoliveRepository.findByIdIn(ids);
    }

    public Lotolive save(Lotolive lotOlive) {
        return lotoliveRepository.saveAndFlush(lotOlive);
    }

    public boolean existById(Long id) {
        return lotoliveRepository.existsById(id);
    }

    public void deleteLotOlive(Long id) {
        lotoliveRepository.deleteById(id);
    }
}
