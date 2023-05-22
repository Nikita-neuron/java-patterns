package com.mirea.practice_18.patientPos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientPosService {
    @Autowired
    private PatientPosRepo patientPosRepo;

    @PersistenceContext
    private EntityManager entityManager;

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

    public List<PatientPos> findAllByFilters(String firstName, String lastName) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PatientPos> query = builder.createQuery(PatientPos.class);
        Root<PatientPos> patientRoot = query.from(PatientPos.class);

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
