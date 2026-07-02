package com.abhisek.asep.identity.domain.service;

import com.abhisek.asep.identity.domain.model.User;

public interface UserDomainService {

    User activate(User user);

    User deactivate(User user);

    User lock(User user);

}