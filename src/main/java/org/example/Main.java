package org.example;

import org.example.config.AppConfig;
import org.example.service.ContactRun;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(ContactRun.class).run();
    }
}