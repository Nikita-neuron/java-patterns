package com.mirea.practice_23.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
@EnableMBeanExport
@Import({DatabaseConfig.class, SecurityConfig.class})
public class AppConfig {
}

