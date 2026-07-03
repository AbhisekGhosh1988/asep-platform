package com.abhisek.asep.identity.application.service.impl;

import com.abhisek.asep.identity.application.dto.response.CurrentUserResponse;
import com.abhisek.asep.identity.application.service.CurrentUserService;
import com.abhisek.asep.identity.domain.exception.UserNotFoundException;
import com.abhisek.asep.identity.domain.model.User;
import com.abhisek.asep.identity.domain.repository.UserRepository;
import com.abhisek.asep.identity.infrastructure.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrentUserServiceImpl implements CurrentUserService {

    private final UserRepository userRepository;

    @Override
    public CurrentUserResponse currentUser() {

        User user = userRepository.findByUsername(SecurityUtils.currentUsername()).
                orElseThrow(() -> new UserNotFoundException("Current user not found."));

        return CurrentUserResponse.builder().id(user.getId()).username(user.getUsername()).
                email(user.getEmail()).roles(user.getRoles().stream().
                        map(role -> role.getRoleType().name()).collect(Collectors.toSet())).build();
    }
}