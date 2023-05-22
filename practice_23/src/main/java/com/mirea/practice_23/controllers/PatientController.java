package com.mirea.practice_23.controllers;

import com.mirea.practice_23.email.EmailService;
import com.mirea.practice_23.patient.Patient;
import com.mirea.practice_23.patient.PatientService;
import com.mirea.practice_23.patientPos.PatientPos;
import com.mirea.practice_23.patientPos.PatientPosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientPosService patientPosService;

    @Autowired
    private EmailService emailService;

    @PostMapping
    @Transactional
    public Patient save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteById(@PathVariable Long id) {
        patientService.deleteById(id);
    }

    @GetMapping
    @Transactional
    public Iterable<Patient> findAll() {
        emailService.sendEmailAsync("PatientController", "Find all phones");
        return patientService.findAll();
    }

    @GetMapping("/{id}/patientPos")
    @Transactional
    public Iterable<PatientPos> getAllPatientPosByPatientId(@PathVariable Long id) {
        return patientPosService.getAllPatientPosByPatientId(id);
    }

    @DeleteMapping("/{id}/patientPos")
    @Transactional
    public void deleteByPatientId(@PathVariable Long id) {
        patientPosService.deleteByPatientId(id);
    }

    @PostMapping("/{id}/patientPos")
    @Transactional
    public void savePatientPosByPatientId(@PathVariable Long id, @RequestBody PatientPos patientPos) {
        patientService.findById(id).map(patient -> {
            patientPos.setPatient(patient);
            return patientPosService.save(patientPos);
        });
    }

    @GetMapping("/search")
    @Transactional
    public List<Patient> searchPatient(@RequestParam(value = "firstName", required = false) String firstName,
                                       @RequestParam(value = "lastName", required = false) String lastName) {
        return patientService.findAllByFilters(firstName, lastName);
    }
}
