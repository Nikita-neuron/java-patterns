package com.mirea.practice_19.controllers;

import com.mirea.practice_19.patientPos.PatientPos;
import com.mirea.practice_19.patientPos.PatientPosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/search")
    public List<PatientPos> searchPatient(@RequestParam(value = "firstName", required = false) String firstName,
                                       @RequestParam(value = "lastName", required = false) String lastName) {
        return patientPosService.findAllByFilters(firstName, lastName);
    }
}
