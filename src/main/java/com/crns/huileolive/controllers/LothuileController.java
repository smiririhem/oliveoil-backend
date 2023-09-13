package com.crns.huileolive.controllers;

import com.crns.huileolive.entities.Citerne;
import com.crns.huileolive.entities.Lothuile;
import com.crns.huileolive.managers.CiterneManager;
import com.crns.huileolive.managers.LothuileManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class LothuileController {
    @Autowired
    private LothuileManager lothuileManager;

    @GetMapping("/lothuiles")
    public List<Lothuile> getLothuiles() {
        return lothuileManager.getLothuiles();
    }

    @GetMapping("/lothuiles/{id}")
    public ResponseEntity<Lothuile> getLothuile(@PathVariable Long id) {
        return lothuileManager.getLothuile(id);
    }

    @PostMapping("/lothuiles")
    public Lothuile addLothuile(@RequestBody Lothuile lothuile) {
        return lothuileManager.addLothuile(lothuile);
    }

    @PutMapping("/lothuiles/{id}")
    public ResponseEntity<?> updateLothuile(@RequestBody Lothuile lothuile, @PathVariable Long id) {
        return lothuileManager.updateLothuile(lothuile, id);
    }

    @DeleteMapping("/lothuiles/{id}")
    public ResponseEntity<?> deleteLothuile(@PathVariable Long id) {
        return lothuileManager.deleteLothuile(id);
    }
}
