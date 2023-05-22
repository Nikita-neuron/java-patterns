package com.mirea.pracice_20.patientPos;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientPosRepo extends CrudRepository<PatientPos, Long> {
    List<PatientPos> findByPatientId(Long patientId);
    void deleteByPatientId(Long patientId);
}
