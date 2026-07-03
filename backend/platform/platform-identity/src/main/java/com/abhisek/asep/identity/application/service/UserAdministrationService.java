package com.abhisek.asep.identity.application.service;

public interface UserAdministrationService {

    void assignRole(String userId, String roleId);

    void removeRole(String userId, String roleId);

    void enableUser(String userId);

    void disableUser(String userId);

    void lockUser(String userId);

    void unlockUser(String userId);

}