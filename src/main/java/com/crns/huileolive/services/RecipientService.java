package com.crns.huileolive.services;

import com.crns.huileolive.entities.Recipient;
import com.crns.huileolive.repositories.RecipientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class RecipientService {

    private final RecipientRepository recipientRepository;

    public Optional<Recipient> getRecipientById(long id) {
        return recipientRepository.findById(id);
    }
    public List<Recipient> getRecipients() {
        return recipientRepository.findAll();
    }

    public Optional<Recipient> getRecipientById(Long id) {
        return recipientRepository.findById(id);
    }

    public Recipient save(Recipient recipient) {
        return recipientRepository.saveAndFlush(recipient);
    }

    public boolean existById(Long id) {
        return recipientRepository.existsById(id);
    }

    public void deleteRecipient(Long id) {
        recipientRepository.deleteById(id);
    }
}
