package com.crns.huileolive.controllers;

import com.crns.huileolive.entities.Citerne;
import com.crns.huileolive.entities.Moulin;
import com.crns.huileolive.managers.CiterneManager;
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
public class CiterneController {
    @Autowired
    private CiterneManager citerneManager;

    @GetMapping("/citernes")
    public List<Citerne> getCiternes() {
        return citerneManager.getCiternes();
    }

    @GetMapping("/citernes/{id}")
    public ResponseEntity<Citerne> getCiterne(@PathVariable Long id) {
        return citerneManager.getCiterne(id);
    }

    @PostMapping("/citernes")
    public Citerne addCiterne(@RequestBody Citerne citerne) {
        return citerneManager.saveCiterne(citerne);
    }

    @PutMapping("/citernes/{id}")
    public ResponseEntity<?> updateCiterne(@RequestBody Citerne citerne, @PathVariable Long id) {
        return citerneManager.updateCiterne(citerne, id);
    }

    @DeleteMapping("/citernes/{id}")
    public ResponseEntity<?> deleteCiterne(@PathVariable Long id) {
        return citerneManager.deleteCiterne(id);
    }
}
