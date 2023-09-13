package com.crns.huileolive.controllers;

import com.crns.huileolive.entities.Berger;
import com.crns.huileolive.entities.Moulin;
import com.crns.huileolive.managers.BergerManager;
import com.crns.huileolive.managers.MoulinManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class BergerController {
    @Autowired
    private BergerManager bergerManager;

    @GetMapping("/bergers")
    public List<Berger> getBergers() {
        return bergerManager.getBergers();
    }

    @GetMapping("/bergers/{id}")
    public ResponseEntity<Berger> getBerger(@PathVariable Long id) {
        return bergerManager.getBerger(id);
    }

    @PostMapping("/bergers")
    public Berger addBerger(@RequestBody Berger berger) {
        return bergerManager.addBerger(berger);
    }

    @PutMapping("/bergers/{id}")
    public ResponseEntity<?> updateBerger(@RequestBody Berger berger, @PathVariable Long id) {
        return bergerManager.updateBerger(berger, id);
    }

    @DeleteMapping("/bergers/{id}")
    public ResponseEntity<?> deleteBerger(@PathVariable Long id) {
        return bergerManager.deleteBerger(id);
    }
}
