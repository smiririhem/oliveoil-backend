package com.crns.huileolive.managers;

import com.crns.huileolive.entities.Lotolive;
import com.crns.huileolive.services.LotoliveService;
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
public class LotoliveManager {

    @Autowired
    private LotoliveService lotoliveService;

    public List<Lotolive> getLotsolives() {
        return lotoliveService.getLotolives();
    }

    public ResponseEntity<Lotolive> getLotolive(@PathVariable Long id) {
        Lotolive lotolive = lotoliveService.getLotoliveById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requête non trouvée"));
        return ResponseEntity.ok().body(lotolive);
    }

    public Lotolive addLotolive(@RequestBody Lotolive lotOlive) {
        return lotoliveService.save(lotOlive);
    }

    public ResponseEntity<?> updateLotolive(@RequestBody Lotolive lotolive, @PathVariable Long id) {
        if (lotoliveService.existById(id)) {
            Lotolive existingLotolive = lotoliveService.getLotoliveById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Requête non trouvée"));

            existingLotolive.setDateRecolte(lotolive.getDateRecolte());
            existingLotolive.setVariete(lotolive.getVariete());
            existingLotolive.setQuantite(lotolive.getQuantite());
            existingLotolive.setMouline(lotolive.getMouline());

            lotoliveService.save(existingLotolive);

            return ResponseEntity.ok().body(existingLotolive);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - Tâche non trouvée ou non valide");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    public ResponseEntity<?> deleteLotolive(@PathVariable Long id) {
        if (lotoliveService.existById(id)) {
            lotoliveService.deleteLotOlive(id);
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - supprimé avec succès");
            return ResponseEntity.ok().body(message);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - Tâche non trouvée ou non valide");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}
