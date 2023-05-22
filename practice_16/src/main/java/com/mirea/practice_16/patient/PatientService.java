package com.mirea.practice_16.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    public Patient save(Patient patient) {
        return patientRepo.save(patient);
    }

    public void deleteById(Long id) {
        patientRepo.deleteById(id);
    }

    public Iterable<Patient> findAll() {
        return patientRepo.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return patientRepo.findById(id);
    }
}
