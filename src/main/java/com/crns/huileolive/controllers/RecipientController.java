package com.crns.huileolive.controllers;

import com.crns.huileolive.entities.Moulin;
import com.crns.huileolive.entities.Recipient;
import com.crns.huileolive.managers.MoulinManager;
import com.crns.huileolive.managers.RecipientManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class RecipientController {

    @Autowired
    private RecipientManager recipientManager;

    @GetMapping("/recipients")
    public List<Recipient> getRecipients() {
        return recipientManager.getRecipients();
    }

    @GetMapping("/recipients/{id}")
    public ResponseEntity<Recipient> getRecipient(@PathVariable Long id) {
        return recipientManager.getRecipient(id);
    }

    @PostMapping("/recipients")
    public Recipient addRecipient(@RequestBody Recipient recipient) {
        return recipientManager.saveRecipient(recipient);
    }

    @PutMapping("/recipients/{id}")
    public ResponseEntity<?> updateRecipient(@RequestBody Recipient recipient, @PathVariable Long id) {
        return recipientManager.updateRecipient(recipient, id);
    }

    @DeleteMapping("/recipients/{id}")
    public ResponseEntity<?> deleteRecipient(@PathVariable Long id) {
        return recipientManager.deleteRecipient(id);
    }
}
