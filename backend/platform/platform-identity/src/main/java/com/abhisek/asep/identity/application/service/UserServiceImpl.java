package com.abhisek.asep.identity.application.service;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.BusinessException;
import com.abhisek.asep.identity.domain.model.Role;
import com.abhisek.asep.identity.domain.entity.RoleType;
import com.abhisek.asep.identity.domain.model.User;
import com.abhisek.asep.identity.domain.entity.UserStatus;
import com.abhisek.asep.identity.domain.repository.RoleRepository;
import com.abhisek.asep.identity.domain.repository.UserRepository;
import com.abhisek.asep.identity.application.dto.request.RegisterUserRequest;
import com.abhisek.asep.identity.application.dto.response.UserResponse;
import com.abhisek.asep.identity.application.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(RegisterUserRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BusinessException(
                    ErrorCode.CONFLICT,
                    "Username already exists");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException(
                    ErrorCode.CONFLICT,
                    "Email already exists");
        }

        Role defaultRole = roleRepository.findByRoleType(RoleType.DEVELOPER)
                .orElseThrow(() -> new BusinessException(
                        ErrorCode.RESOURCE_NOT_FOUND,
                        "Default role not found"));

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .status(UserStatus.ACTIVE)
                .roles(Set.of(defaultRole))
                .build();

        userRepository.save(user);

        return UserMapper.toResponse(user);
    }
}