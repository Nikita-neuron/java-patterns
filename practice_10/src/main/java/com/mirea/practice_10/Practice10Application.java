package com.mirea.practice_10;

import com.mirea.practice_10.programmer.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;

@SpringBootApplication
public class Practice10Application {

	public static void main(String[] args) {
		HashMap<String, Class> beans = new HashMap<>();

		beans.put("Junior", Junior.class);
		beans.put("Middle", Middle.class);
		beans.put("Senior", Senior.class);

		String className = "Senior";

		if (beans.containsKey(className)) {
			ApplicationContext context = new AnnotationConfigApplicationContext(ProgrammerConfig.class);
			Programmer programmer = (Programmer) context.getBean(beans.get(className));
			programmer.doCoding();
		}
		else {
			System.out.println("Bean not found");
		}
	}

}
