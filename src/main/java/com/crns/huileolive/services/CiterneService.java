package com.crns.huileolive.services;

import com.crns.huileolive.entities.Citerne;
import com.crns.huileolive.entities.Recipient;
import com.crns.huileolive.repositories.CiterneRepository;
import com.crns.huileolive.repositories.RecipientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CiterneService {
    private final CiterneRepository citerneRepository;
    public List<Citerne> getCiternes() {
        return citerneRepository.findAll();
    }

    public Optional<Citerne> getCiterneById(Long id) {
        return citerneRepository.findById(id);
    }

    public Citerne save(Citerne citerne) {
        return citerneRepository.saveAndFlush(citerne);
    }

    public boolean existById(Long id) {
        return citerneRepository.existsById(id);
    }

    public void deleteCiterne(Long id) {
        citerneRepository.deleteById(id);
    }
}
