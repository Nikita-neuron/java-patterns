package com.mirea.practice_16.controllers;

import com.mirea.practice_16.patient.PatientService;
import com.mirea.practice_16.patientPos.PatientPos;
import com.mirea.practice_16.patientPos.PatientPosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patientPos")
public class PatientPosController {
    @Autowired
    private PatientPosService patientPosService;

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
