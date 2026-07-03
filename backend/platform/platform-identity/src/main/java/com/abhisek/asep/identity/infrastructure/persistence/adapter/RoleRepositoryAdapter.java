package com.abhisek.asep.identity.infrastructure.persistence.adapter;

import com.abhisek.asep.identity.domain.entity.RoleType;
import com.abhisek.asep.identity.domain.model.Role;
import com.abhisek.asep.identity.domain.repository.RoleRepository;
import com.abhisek.asep.identity.infrastructure.persistence.mapper.RolePersistenceMapper;
import com.abhisek.asep.identity.infrastructure.persistence.repository.JpaRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryAdapter implements RoleRepository {

    private final JpaRoleRepository repository;
    private final RolePersistenceMapper mapper;

    @Override
    public Role save(Role role) {
        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(role)
                )
        );
    }

    @Override
    public Optional<Role> findById(String id) {
        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Role> findByRoleType(RoleType roleType) {
        return repository.findByRoleType(roleType)
                .map(mapper::toDomain);
    }

    @Override
    public List<Role> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Role role) {

        repository.delete(
                mapper.toEntity(role)
        );
    }
}