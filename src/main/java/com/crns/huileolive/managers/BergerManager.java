package com.crns.huileolive.managers;

import com.crns.huileolive.entities.Berger;
import com.crns.huileolive.services.BergerService;
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
public class BergerManager {
    @Autowired
    private BergerService bergerService;

    public List<Berger> getBergers() {
        return bergerService.getBergers();
    }

    public ResponseEntity<Berger> getBerger(@PathVariable Long id) {
        Berger berger = bergerService.getBergerById(id)
                .orElseThrow(() -> new EntityNotFoundException("Berger non trouvé"));
        return ResponseEntity.ok().body(berger);
    }

    public Berger addBerger(@RequestBody Berger berger) {
        return bergerService.save(berger);
    }

    public ResponseEntity<?> updateBerger(@RequestBody Berger berger, @PathVariable Long id) {
        if (bergerService.existById(id)) {
            Berger existingBerger = bergerService.getBergerById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Berger non trouvé"));

            existingBerger.setNom(berger.getNom());
            existingBerger.setDetails(berger.getDetails());

            bergerService.save(existingBerger);

            return ResponseEntity.ok().body(existingBerger);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - Berger non trouvé ou non valide");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    public ResponseEntity<?> deleteBerger(@PathVariable Long id) {
        if (bergerService.existById(id)) {
            bergerService.deleteBerger(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - supprimé avec succès");
            return ResponseEntity.ok().body(message);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - Berger non trouvé ou non valide");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
