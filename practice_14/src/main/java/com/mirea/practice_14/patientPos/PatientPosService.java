package com.mirea.practice_14.patientPos;

import org.springframework.stereotype.Service;

@Service
public class PatientPosService {
    private PatientPosRepo patientPosRepo;

    public PatientPosService(PatientPosRepo patientPosRepo) {
        this.patientPosRepo = patientPosRepo;
    }

    public PatientPos save(PatientPos patientPos) {
        return patientPosRepo.save(patientPos);
    }

    public void deleteById(Long id) {
        patientPosRepo.deleteById(id);
    }

    public Iterable<PatientPos> findAll() {
        return patientPosRepo.findAll();
    }
}
