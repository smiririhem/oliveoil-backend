package com.crns.huileolive.managers;

import com.crns.huileolive.entities.Solvant;
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
public class SolvantManager {

    @Autowired
    private SolvantService solvantService;

    public List<Solvant> getSolvants() {
        return solvantService.getSolvants();
    }

    public ResponseEntity<Solvant> getSolvant(@PathVariable Long id) {
        Solvant solvant = solvantService.getSolvantById(id)
                .orElseThrow(() -> new EntityNotFoundException("Solvant non trouvé"));
        return ResponseEntity.ok().body(solvant);
    }

    public Solvant saveSolvant(Solvant solvant) {
        return solvantService.save(solvant);
    }

    public ResponseEntity<?> updateSolvant(@RequestBody Solvant solvant, @PathVariable Long id) {
        if (solvantService.existById(id)) {
            Solvant existingSolvant = solvantService.getSolvantById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Solvant non trouvé"));

            // Update the properties of existingSolvant with solvant
            existingSolvant.setTypeSolvant(solvant.getTypeSolvant());
            existingSolvant.setMesure(solvant.getMesure());
            // Update other properties as needed

            solvantService.save(existingSolvant);

            return ResponseEntity.ok().body(existingSolvant);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - Solvant non trouvé ou non valide");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    public ResponseEntity<?> deleteSolvant(@PathVariable Long id) {
        if (solvantService.existById(id)) {
            solvantService.deleteSolvant(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - supprimé avec succès");
            return ResponseEntity.ok().body(message);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - Solvant non trouvé ou non valide");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
