package com.crns.huileolive.managers;

import com.crns.huileolive.entities.Recipient;
import com.crns.huileolive.entities.Solvant;
import com.crns.huileolive.services.RecipientService;
import com.crns.huileolive.services.SolvantService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;

@Service
public class RecipientManager {

    @Autowired
    private RecipientService recipientService;

    public List<Recipient> getRecipients() {
        return recipientService.getRecipients();
    }

    public ResponseEntity<Recipient> getRecipient(@PathVariable Long id) {
        Recipient recipient = recipientService.getRecipientById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipient non trouvé"));
        return ResponseEntity.ok().body(recipient);
    }

    public Recipient saveRecipient(Recipient recipient) {
        return recipientService.save(recipient);
    }

    public ResponseEntity<?> updateRecipient(@RequestBody Recipient recipient, @PathVariable Long id) {
        if (recipientService.existById(id)) {
            Recipient existingRecipient = recipientService.getRecipientById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Recipient non trouvé"));

            // Update the properties of existingSolvant with solvant
            existingRecipient.setTypeRecipient(recipient.getTypeRecipient());
            existingRecipient.setCodeQr(recipient.getCodeQr());
            // Update other properties as needed

            recipientService.save(existingRecipient);

            return ResponseEntity.ok().body(existingRecipient);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - Recipient non trouvé ou non valide");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    public ResponseEntity<?> deleteRecipient(@PathVariable Long id) {
        if (recipientService.existById(id)) {
            recipientService.deleteRecipient(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - supprimé avec succès");
            return ResponseEntity.ok().body(message);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - Recipient non trouvé ou non valide");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
