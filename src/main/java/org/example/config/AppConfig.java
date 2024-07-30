package org.example.config;

import org.example.service.ContactRun;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class AppConfig {
    @Bean
    public ContactRun contactRun(){
        return new ContactRun();
    }
}
