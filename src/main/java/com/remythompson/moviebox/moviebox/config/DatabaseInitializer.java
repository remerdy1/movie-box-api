package com.remythompson.moviebox.moviebox.config;

import com.remythompson.moviebox.moviebox.model.RoleEntity;
import com.remythompson.moviebox.moviebox.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DatabaseInitializer {

    @Bean
    CommandLineRunner initDatabase(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.count() == 0) {
                    RoleEntity user = new RoleEntity();
                    RoleEntity admin = new RoleEntity();
                    user.setName("USER");
                    admin.setName("ADMIN");

                    roleRepository.save(user);
                    roleRepository.save(admin);

                log.info("User and Admin roles created");
            } else {
                log.info("Roles already exist.");
            }
        };
    }
}
