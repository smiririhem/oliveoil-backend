package com.crns.huileolive.managers;

import com.crns.huileolive.entities.Citerne;
import com.crns.huileolive.services.CiterneService;
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
public class CiterneManager {
    @Autowired
    private CiterneService citerneService;

    public List<Citerne> getCiternes() {
        return citerneService.getCiternes();
    }

    public ResponseEntity<Citerne> getCiterne(@PathVariable Long id) {
        Citerne citerne = citerneService.getCiterneById(id)
                .orElseThrow(() -> new EntityNotFoundException("Citerne non trouvé"));
        return ResponseEntity.ok().body(citerne);
    }

    public Citerne saveCiterne(Citerne citerne) {
        return citerneService.save(citerne);
    }

    public ResponseEntity<?> updateCiterne(@RequestBody Citerne citerne, @PathVariable Long id) {
        if (citerneService.existById(id)) {
            Citerne existingCiterne = citerneService.getCiterneById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Citerne non trouvée"));

            // Update the properties of existingSolvant with solvant
            existingCiterne.setEmplacement(citerne.getEmplacement());
            existingCiterne.setCodeQr(citerne.getCodeQr());
            existingCiterne.setTypeCiterne(citerne.getTypeCiterne());
            existingCiterne.setCapaciteReelle(citerne.getCapaciteReelle());
            // Update other properties as needed

            citerneService.save(existingCiterne);

            return ResponseEntity.ok().body(existingCiterne);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - Citerne non trouvé ou non valide");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    public ResponseEntity<?> deleteCiterne(@PathVariable Long id) {
        if (citerneService.existById(id)) {
            citerneService.deleteCiterne(id);
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
