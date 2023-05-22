package com.mirea.practice_24.scheduling;

import com.mirea.practice_24.patient.Patient;
import com.mirea.practice_24.patient.PatientDTO;
import com.mirea.practice_24.patient.PatientService;
import com.mirea.practice_24.patientPos.PatientPos;
import com.mirea.practice_24.patientPos.PatientPosDTO;
import com.mirea.practice_24.patientPos.PatientPosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

interface IWriteData {
    void exec(FileWriter writer) throws IOException;
}

@Service
@Slf4j
@ManagedResource(objectName = "com.mirea.practice_22:name=SchedulerService")
public class SchedulerService {
    private final PatientService patientService;
    private final PatientPosService patientPosService;

    public SchedulerService(PatientService patientService, PatientPosService patientPosService) {
        this.patientService = patientService;
        this.patientPosService = patientPosService;
    }

    private void generateFile(String path, IWriteData writeData) {
        try {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writeData.exec(writer);
            writer.close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    @ManagedOperation(description = "Creates DB files")
    @Scheduled(fixedDelay = 1_800_000)
//    @Scheduled(fixedDelay = 60_000)
    public void generateFiles() {
        generateFile("patientDB.txt", writer -> {
            List<Patient> patientList = (List<Patient>) patientService.findAll();
            for (Patient patient : patientList) {
                writer.write(PatientDTO.fromPatient(patient).toString());
                writer.write(System.lineSeparator());
            }
        });

        generateFile("patientPosDB.txt", writer -> {
            List<PatientPos> patientPosList = (List<PatientPos>) patientPosService.findAll();
            for (PatientPos patientPos : patientPosList) {
                writer.write(PatientPosDTO.fromPatientPos(patientPos).toString());
                writer.write(System.lineSeparator());
            }
        });
    }
}
