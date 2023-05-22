package com.mirea.practice_15.patient;

import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public Patient save(Patient patient) {
        return patientRepo.save(patient);
    }

    public void deleteById(Long id) {
        patientRepo.deleteById(id);
    }

    public Iterable<Patient> findAll() {
        return patientRepo.findAll();
    }
}
