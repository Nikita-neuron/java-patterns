package com.mirea.practice_23.patientPos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mirea.practice_23.patient.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patientPos")
@Getter
@Setter
public class PatientPos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private int position;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Override
    public String toString() {
        return "PatientPos{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", patient=" + patient.getId() +
                '}';
    }
}
