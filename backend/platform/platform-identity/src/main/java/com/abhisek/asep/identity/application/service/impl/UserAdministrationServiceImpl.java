package com.abhisek.asep.identity.application.service.impl;

import com.abhisek.asep.identity.application.service.UserAdministrationService;
import com.abhisek.asep.identity.domain.entity.UserStatus;
import com.abhisek.asep.identity.domain.exception.RoleNotFoundException;
import com.abhisek.asep.identity.domain.exception.UserNotFoundException;
import com.abhisek.asep.identity.domain.model.Role;
import com.abhisek.asep.identity.domain.model.User;
import com.abhisek.asep.identity.domain.repository.RoleRepository;
import com.abhisek.asep.identity.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAdministrationServiceImpl
        implements UserAdministrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public void assignRole(String userId, String roleId) {

        User user = userRepository.findById(userId).orElseThrow(() ->
                new RoleNotFoundException(
                        "User not found: " + roleId));

        Role role = roleRepository.findById(roleId).orElseThrow(() ->
                new RoleNotFoundException(
                        "Role not found: " + roleId));

        user.getRoles().add(role);

        userRepository.save(user);

    }

    @Override
    public void removeRole(String userId, String roleId) {

        User user = userRepository.findById(userId).orElseThrow(() ->
                new RoleNotFoundException(
                        "User not found: " + roleId));

        user.getRoles().removeIf(role ->
                role.getId().equals(roleId));

        userRepository.save(user);

    }

    @Override
    public void enableUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(
                        "User not found: " + userId));

        user.setStatus(UserStatus.ACTIVE);

        userRepository.save(user);

    }

    @Override
    public void disableUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(
                        "User not found: " + userId));

        user.setStatus(UserStatus.DISABLED);

        userRepository.save(user);

    }

    @Override
    public void lockUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(
                        "User not found: " + userId));

        user.setStatus(UserStatus.LOCKED);

        userRepository.save(user);

    }

    @Override
    public void unlockUser(String userId) {

        User user = userRepository.findById(userId).orElseThrow(() ->
                new UserNotFoundException(
                        "User not found: " + userId));

        user.setStatus(UserStatus.ACTIVE);

        userRepository.save(user);

    }

}