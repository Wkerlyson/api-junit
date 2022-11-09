package com.apiunit.config;

import com.apiunit.domain.User;
import com.apiunit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB(){
        User u1 = new User(null, "Wk", "wk@gmail.com", "123");
        User u2 = new User(null, "Pedro", "pedro@gmail.com", "1234");

        repository.saveAll(Arrays.asList(u1, u2));
    }
}
