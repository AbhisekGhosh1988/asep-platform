package com.abhisek.asep.identity.infrastructure.persistence.adapter;

import com.abhisek.asep.identity.domain.model.User;
import com.abhisek.asep.identity.domain.repository.UserRepository;
import com.abhisek.asep.identity.infrastructure.persistence.mapper.UserPersistenceMapper;
import com.abhisek.asep.identity.infrastructure.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final JpaUserRepository repository;

    private final UserPersistenceMapper mapper;

    @Override
    public User save(User user) {

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(user)
                )
        );
    }

    @Override
    public Optional<User> findById(String id) {

        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {

        return repository.findByUsername(username)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return repository.findByEmail(email)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsByUsername(String username) {

        return repository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {

        return repository.existsByEmail(email);
    }
}