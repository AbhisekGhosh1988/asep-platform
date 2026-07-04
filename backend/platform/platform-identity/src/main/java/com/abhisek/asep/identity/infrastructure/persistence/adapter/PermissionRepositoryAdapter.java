package com.abhisek.asep.identity.infrastructure.persistence.adapter;

import com.abhisek.asep.identity.domain.model.Permission;
import com.abhisek.asep.identity.domain.repository.PermissionRepository;
import com.abhisek.asep.identity.infrastructure.persistence.mapper.PermissionPersistenceMapper;
import com.abhisek.asep.identity.infrastructure.persistence.repository.JpaPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PermissionRepositoryAdapter implements PermissionRepository {

    private final JpaPermissionRepository repository;
    private final PermissionPersistenceMapper mapper;

    @Override
    public Permission save(Permission permission) {

        return mapper.toDomain(repository.save(mapper.toEntity(permission)));
    }

    @Override
    public Optional<Permission> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Permission> findByName(String name) {

        return repository.findByName(name).map(mapper::toDomain);
    }

    @Override
    public boolean existsByName(String name) {

        return repository.existsByName(name);
    }

    @Override
    public List<Permission> findAll() {

        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(Permission permission) {

        repository.delete(mapper.toEntity(permission));
    }
}