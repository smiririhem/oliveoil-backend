package com.crns.huileolive.services;

import com.crns.huileolive.entities.Lothuile;
import com.crns.huileolive.entities.Lotolive;
import com.crns.huileolive.repositories.LothuileRepository;
import com.crns.huileolive.repositories.LotoliveRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LothuileService {
    private final LothuileRepository lothuileRepository;

    public List<Lothuile> getLothuiles() {
        return lothuileRepository.findAll();
    }

    public Optional<Lothuile> getLothuileById(Long id) {
        return lothuileRepository.findById(id);
    }

    public Lothuile save(Lothuile lothuile) {
        return lothuileRepository.saveAndFlush(lothuile);
    }

    public boolean existById(Long id) {
        return lothuileRepository.existsById(id);
    }

    public void deleteLothuile(Long id) {
        lothuileRepository.deleteById(id);
    }
}
