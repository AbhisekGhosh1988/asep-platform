package com.abhisek.asep.identity.application.bootstrap;

import com.abhisek.asep.identity.domain.entity.RoleType;
import com.abhisek.asep.identity.domain.entity.UserStatus;
import com.abhisek.asep.identity.domain.model.Role;
import com.abhisek.asep.identity.domain.model.User;
import com.abhisek.asep.identity.domain.repository.RoleRepository;
import com.abhisek.asep.identity.domain.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class IdentityBootstrapRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void bootstrap() {

        if (userRepository.existsByUsername("admin")) {
            log.info("Admin user already exists.");
            return;
        }

        Role superAdminRole = roleRepository
                .findByRoleType(RoleType.SUPER_ADMIN)
                .orElseThrow(() ->
                        new IllegalStateException(
                                "SUPER_ADMIN role not found. "
                                        + "Run Flyway migrations first."));

        User admin = User.builder()
                .username("admin")
                .email("admin@asep.ai")
                .password(passwordEncoder.encode("admin123"))
                .firstName("System")
                .lastName("Administrator")
                .status(UserStatus.ACTIVE)
                .roles(Set.of(superAdminRole))
                .build();

        userRepository.save(admin);

        log.info("=================================================");
        log.info("ASEP SUPER ADMIN CREATED");
        log.info("Username : admin");
        log.info("Password : admin123");
        log.info("=================================================");
    }
}