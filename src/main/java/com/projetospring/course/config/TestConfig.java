package com.projetospring.course.config;

import com.projetospring.course.entities.User;
import com.projetospring.course.repositores.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Maria Brown","maria@gmail.com","96937583728", "123");
        User u2 = new User(null,"Alex Green", "alex@gmail.com","97527364579","09304");

        userRepository.saveAll(Arrays.asList(u1,u2));


    }
}

