package com.crns.huileolive.controllers;

import com.crns.huileolive.entities.Moulin;
import com.crns.huileolive.entities.Solvant;
import com.crns.huileolive.managers.MoulinManager;
import com.crns.huileolive.managers.SolvantManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api")
public class SolvantController {

    @Autowired
    private SolvantManager solvantManager;

    @GetMapping("/solvants")
    public List<Solvant> getSolvants() {
        return solvantManager.getSolvants();
    }

    @GetMapping("/solvants/{id}")
    public ResponseEntity<Solvant> getSolvant(@PathVariable Long id) {
        return solvantManager.getSolvant(id);
    }

    @PostMapping("/solvants")
    public Solvant addSolvant(@RequestBody Solvant solvant) {
        return solvantManager.saveSolvant(solvant);
    }

    @PutMapping("/solvants/{id}")
    public ResponseEntity<?> updateSolvant(@RequestBody Solvant solvant, @PathVariable Long id) {
        return solvantManager.updateSolvant(solvant, id);
    }

    @DeleteMapping("/solvants/{id}")
    public ResponseEntity<?> deleteSolvant(@PathVariable Long id) {
        return solvantManager.deleteSolvant(id);
    }
}
