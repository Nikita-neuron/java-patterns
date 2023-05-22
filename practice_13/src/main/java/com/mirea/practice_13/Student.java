package com.mirea.practice_13;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
    @Value("${student.name}")
    private String name;

    @Value("${student.last_name}")
    private String last_name;

    @Value("${student.group}")
    private String group;

    @PostConstruct
    public void init() {
        System.out.println("Name: " + name);
        System.out.println("Last name: " + last_name);
        System.out.println("Group: " + group);
    }

}
