package com.mirea.practice_22.patientPos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientPosDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int position;
    private Long patientId;

    public static PatientPosDTO fromPatientPos(PatientPos patientPos) {
        PatientPosDTO patientPosDTO = new PatientPosDTO();
        patientPosDTO.setId(patientPos.getId());
        patientPosDTO.setFirstName(patientPos.getFirstName());
        patientPosDTO.setLastName(patientPos.getLastName());
        patientPosDTO.setPosition(patientPos.getPosition());
        patientPosDTO.setPatientId(patientPos.getPatient().getId());

        return patientPosDTO;
    }
}
