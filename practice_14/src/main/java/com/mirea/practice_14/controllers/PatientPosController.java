package com.mirea.practice_14.controllers;

import com.mirea.practice_14.patientPos.PatientPos;
import com.mirea.practice_14.patientPos.PatientPosService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patientPos")
public class PatientPosController {
    private PatientPosService patientPosService;

    public PatientPosController(PatientPosService patientPosService) {
        this.patientPosService = patientPosService;
    }

    @PostMapping
    public PatientPos save(@RequestBody PatientPos patientPos) {
        return patientPosService.save(patientPos);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        patientPosService.deleteById(id);
    }

    @GetMapping
    public Iterable<PatientPos> findAll() {
        return patientPosService.findAll();
    }
}
