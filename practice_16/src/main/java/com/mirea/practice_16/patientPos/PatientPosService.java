package com.mirea.practice_16.patientPos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientPosService {
    @Autowired
    private PatientPosRepo patientPosRepo;

    public PatientPos save(PatientPos patientPos) {
        return patientPosRepo.save(patientPos);
    }

    public void deleteById(Long id) {
        patientPosRepo.deleteById(id);
    }

    public Iterable<PatientPos> findAll() {
        return patientPosRepo.findAll();
    }

    public Iterable<PatientPos> getAllPatientPosByPatientId(Long id) {
        return patientPosRepo.findByPatientId(id);
    }

    public void deleteByPatientId(Long id) {
        patientPosRepo.deleteByPatientId(id);
    }
}
