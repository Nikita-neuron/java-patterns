package com.mirea.practice_12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;

@Component
public class FileHash {
    private File inputFile;

    @Autowired
    private ApplicationArguments applicationArguments;

    @PostConstruct
    public void init() throws Exception {
        String inputFilePath = applicationArguments.getSourceArgs()[0];
        String outputFilePath = applicationArguments.getSourceArgs()[1];

        inputFile = new File(inputFilePath);

        hashFile(inputFilePath, outputFilePath);
    }

    public void hashFile(String inputFilePath, String outputFilePath) throws Exception {
        FileOutputStream outputStream = new FileOutputStream(outputFilePath);
        if (!inputFile.exists()) {
            outputStream.write("null".getBytes());
            outputStream.close();
            System.out.println("Data write null");
            return;
        }

        FileInputStream inputStream = new FileInputStream(inputFilePath);
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();

        data = MessageDigest.getInstance("SHA-256").digest(data);

        outputStream.write(data);
        outputStream.close();
        System.out.println("Data write");
    }

    @PreDestroy
    public void deleteFile() {
        if (inputFile.exists()) {
            inputFile.delete();
            System.out.println("File delete");
        }
    }
}
