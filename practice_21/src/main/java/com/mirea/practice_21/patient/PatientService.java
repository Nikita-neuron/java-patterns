package com.mirea.practice_21.patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public Patient save(Patient patient) {
        log.info("Save patient: {}", patient);
        return patientRepo.save(patient);
    }

    public void deleteById(Long id) {
        patientRepo.deleteById(id);
        log.info("Delete patient by ID: {}", id);
    }

    public Iterable<Patient> findAll() {
        log.info("Find all patients");
        return patientRepo.findAll();
    }

    public Optional<Patient> findById(Long id) {
        log.info("Find patient by ID: {}", id);
        return patientRepo.findById(id);
    }

    public List<Patient> findAllByFilters(String firstName, String lastName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
        Root<Patient> patientRoot = query.from(Patient.class);

        Predicate predicate = builder.conjunction();

        if (firstName != null && !firstName.isEmpty()) {
            predicate = builder.and(predicate, builder.like(patientRoot.get("firstName"), firstName));
        }
        if (lastName != null && !lastName.isEmpty()) {
            predicate = builder.and(predicate, builder.like(patientRoot.get("lastName"), lastName));
        }

        query.select(patientRoot).orderBy(builder.asc(patientRoot.get("firstName")));
        query.where(predicate);
        log.info("Find patients by filters: firstName = {}, lastName = {}", firstName, lastName);
        return entityManager.createQuery(query).getResultList();
    }
}
