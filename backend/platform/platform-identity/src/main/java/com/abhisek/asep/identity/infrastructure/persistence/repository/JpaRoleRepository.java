package com.abhisek.asep.identity.infrastructure.persistence.repository;

import com.abhisek.asep.identity.domain.entity.RoleType;
import com.abhisek.asep.identity.infrastructure.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRoleRepository extends JpaRepository<RoleEntity, String> {

    Optional<RoleEntity> findByRoleType(RoleType roleType);

}