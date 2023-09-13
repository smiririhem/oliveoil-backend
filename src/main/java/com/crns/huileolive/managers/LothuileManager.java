package com.crns.huileolive.managers;

import com.crns.huileolive.entities.Lothuile;
import com.crns.huileolive.services.LothuileService;
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
public class LothuileManager {

    @Autowired
    private LothuileService lothuileService;

    public List<Lothuile> getLothuiles() {
        return lothuileService.getLothuiles();
    }

    public ResponseEntity<Lothuile> getLothuile(@PathVariable Long id) {
        Lothuile lothuile = lothuileService.getLothuileById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requête non trouvée"));
        return ResponseEntity.ok().body(lothuile);
    }

    public Lothuile addLothuile(@RequestBody Lothuile lothuile) {
        return lothuileService.save(lothuile);
    }

    public ResponseEntity<?> updateLothuile(@RequestBody Lothuile lothuile, @PathVariable Long id) {
        if (lothuileService.existById(id)) {
            Lothuile existingLothuile = lothuileService.getLothuileById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Requête non trouvée"));


            existingLothuile.setQuantiteObtenue(lothuile.getQuantiteObtenue());
            existingLothuile.setTauxAcide(lothuile.getTauxAcide());
            existingLothuile.setTypeHuile(lothuile.getTypeHuile());
            existingLothuile.setNbciternes(lothuile.getNbciternes());
            existingLothuile.setNomProducteur(lothuile.getNomProducteur());

            lothuileService.save(existingLothuile);

            return ResponseEntity.ok().body(existingLothuile);
        } else {
            HashMap<String, String> message = new HashMap<>();
            message.put("message", id + " - Tâche non trouvée ou non valide");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    public ResponseEntity<?> deleteLothuile(@PathVariable Long id) {
        if (lothuileService.existById(id)) {
            lothuileService.deleteLothuile(id);
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
