package com.mirea.practice_14.patient;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepo extends CrudRepository<Patient, Long> {
}
