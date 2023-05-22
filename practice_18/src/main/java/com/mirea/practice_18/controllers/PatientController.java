package com.mirea.practice_18.controllers;

import com.mirea.practice_18.patient.Patient;
import com.mirea.practice_18.patient.PatientService;
import com.mirea.practice_18.patientPos.PatientPos;
import com.mirea.practice_18.patientPos.PatientPosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientPosService patientPosService;

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

    @GetMapping("/{id}/patientPos")
    public Iterable<PatientPos> getAllPatientPosByPatientId(@PathVariable Long id) {
        return patientPosService.getAllPatientPosByPatientId(id);
    }

    @DeleteMapping("/{id}/patientPos")
    public void deleteByPatientId(@PathVariable Long id) {
        patientPosService.deleteByPatientId(id);
    }

    @PostMapping("/{id}/patientPos")
    public void savePatientPosByPatientId(@PathVariable Long id, @RequestBody PatientPos patientPos) {
        patientService.findById(id).map(patient -> {
            patientPos.setPatient(patient);
            return patientPosService.save(patientPos);
        });
    }

    @GetMapping("/search")
    public List<Patient> searchPatient(@RequestParam(value = "firstName", required = false) String firstName,
                                       @RequestParam(value = "lastName", required = false) String lastName) {
        return patientService.findAllByFilters(firstName, lastName);
    }
}
