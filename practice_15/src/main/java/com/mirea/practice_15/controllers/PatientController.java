package com.mirea.practice_15.controllers;

import com.mirea.practice_15.patient.Patient;
import com.mirea.practice_15.patient.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        patientService.deleteById(id);
    }

    @GetMapping
    public Iterable<Patient> findAll() {
        return patientService.findAll();
    }
}
