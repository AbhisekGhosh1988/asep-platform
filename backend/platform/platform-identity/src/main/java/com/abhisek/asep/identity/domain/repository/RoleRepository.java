package com.abhisek.asep.identity.domain.repository;

import com.abhisek.asep.identity.domain.entity.RoleType;
import com.abhisek.asep.identity.domain.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {

    Role save(Role role);

    Optional<Role> findById(String id);

    Optional<Role> findByRoleType(RoleType roleType);

    List<Role> findAll();

    void delete(Role role);

}