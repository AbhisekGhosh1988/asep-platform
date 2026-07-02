package com.abhisek.asep.identity.infrastructure.persistence.repository;

import com.abhisek.asep.identity.infrastructure.persistence.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPermissionRepository extends JpaRepository<PermissionEntity, String> {

    Optional<PermissionEntity> findByName(String name);

    boolean existsByName(String name);

}