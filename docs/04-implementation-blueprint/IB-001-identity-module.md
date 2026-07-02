# IB-001 – Identity Module

---

# Document Information

| Property | Value |
|----------|-------|
| Document ID | IB-001 |
| Module | platform-identity |
| Version | 1.0 |
| Status | Approved |

---

# Executive Summary

The Identity Module provides authentication, authorization, user management, role management, permission evaluation, and session management for ASEP.

It is a Platform Module and does not depend on any Engineering Module.

---

# Responsibilities

- User Management
- Authentication
- Authorization
- Role Management
- Permission Management
- Session Management

---

# Maven Module

```
platform-identity
```

---

# Package Structure

```
platform-identity

src/main/java

└── com.asep.identity

      ├── api

      ├── application

      ├── domain

      ├── infrastructure

      ├── controller

      ├── repository

      ├── dto

      ├── mapper

      ├── validation

      ├── events

      ├── config

      └── exception
```

---

# Domain Classes

```
User

Role

Permission

Session

RefreshToken
```

---

# Value Objects

```
UserId

Email

PasswordHash

SessionId
```

---

# Repository Interfaces

```
UserRepository

RoleRepository

PermissionRepository

SessionRepository
```

---

# Application Services

```
RegisterUserUseCase

LoginUseCase

LogoutUseCase

AssignRoleUseCase

ChangePasswordUseCase
```

---

# Domain Services

```
AuthenticationService

AuthorizationService

RoleAssignmentService
```

---

# Controllers

```
AuthenticationController

UserController

RoleController
```

---

# DTOs

```
RegisterUserRequest

LoginRequest

LoginResponse

UserResponse

RoleResponse
```

---

# Domain Events

```
UserRegistered

UserActivated

RoleAssigned

PasswordChanged
```

---

# Security

OAuth2

JWT

RBAC

---

# Test Classes

```
AuthenticationControllerTest

UserRepositoryTest

AuthenticationServiceTest

IdentityArchitectureTest
```

---

# Generation Contract

Generate:

- Entities
- Repositories
- Controllers
- DTOs
- Mappers
- Tests

Never overwrite:

- Custom Business Logic
- Manual Extensions

Regeneration must preserve custom code.
