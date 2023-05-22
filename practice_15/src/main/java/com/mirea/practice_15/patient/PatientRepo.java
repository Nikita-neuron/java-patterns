package com.mirea.practice_15.patient;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient, Long> {
}
