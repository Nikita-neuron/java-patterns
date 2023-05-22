package com.mirea.practice_17.patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepo patientRepo;

    @PersistenceContext
    private EntityManager entityManager;

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
        return entityManager.createQuery(query).getResultList();
    }
}
