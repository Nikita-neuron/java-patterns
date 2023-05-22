package com.mirea.practice_24.patient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mirea.practice_24.patientPos.PatientPos;
import com.mirea.practice_24.patientPos.PatientPosDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private List<PatientPosDTO> patientPosDTOList;

    public static PatientDTO fromPatient(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());

        List<PatientPosDTO> patientPosDTOList = new ArrayList<>();
        for (PatientPos patientPos : patient.getPatientPosList()) {
            patientPosDTOList.add(PatientPosDTO.fromPatientPos(patientPos));
        }

        patientDTO.setPatientPosDTOList(patientPosDTOList);

        return patientDTO;
    }
}
