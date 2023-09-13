package com.crns.huileolive.controllers;

import com.crns.huileolive.entities.Lothuile;
import com.crns.huileolive.entities.Lotolive;
import com.crns.huileolive.managers.LothuileManager;
import com.crns.huileolive.managers.LotoliveManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class LotoliveController {
    @Autowired
    private LotoliveManager lotoliveManager;

    @GetMapping("/lotolives")
    public List<Lotolive> getLothuiles() {
        return lotoliveManager.getLotsolives();
    }

    @GetMapping("/lotolives/{id}")
    public ResponseEntity<Lotolive> getLotolive(@PathVariable Long id) {
        return lotoliveManager.getLotolive(id);
    }

    @PostMapping("/lotolives")
    public Lotolive addLotolive(@RequestBody Lotolive lotolive) {
        return lotoliveManager.addLotolive(lotolive);
    }

    @PutMapping("/lotolives/{id}")
    public ResponseEntity<?> updateLotolive(@RequestBody Lotolive lotolive, @PathVariable Long id) {
        return lotoliveManager.updateLotolive(lotolive, id);
    }

    @DeleteMapping("/lotolives/{id}")
    public ResponseEntity<?> deleteLotolive(@PathVariable Long id) {
        return lotoliveManager.deleteLotolive(id);
    }
}
