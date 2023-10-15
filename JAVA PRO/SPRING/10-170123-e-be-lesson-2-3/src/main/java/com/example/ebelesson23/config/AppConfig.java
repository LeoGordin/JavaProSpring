package com.example.ebelesson23.config;

import com.example.ebelesson23.domain_layer.Database;
import com.example.ebelesson23.domain_layer.SimpleDataBase;
import com.example.ebelesson23.repository_layer.Repository;
import com.example.ebelesson23.repository_layer.UserRepository;
import com.example.ebelesson23.service_layer.PasswordService;
import com.example.ebelesson23.service_layer.SimplePasswordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Database database() {
        return new SimpleDataBase();
    }

    @Bean
    public Repository repository() {
        return new UserRepository();
    }

    @Bean
    public PasswordService passwordService() {
        return new SimplePasswordService();
    }
}
