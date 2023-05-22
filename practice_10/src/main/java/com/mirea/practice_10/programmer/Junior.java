package com.mirea.practice_10.programmer;

import org.springframework.stereotype.Component;

@Component
public class Junior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Do coding by Junior...");
    }
}
